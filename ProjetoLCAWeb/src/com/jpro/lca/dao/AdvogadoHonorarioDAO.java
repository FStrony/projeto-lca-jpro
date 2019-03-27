package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IAdvogadoHonorarioDAO;
import com.jpro.lca.util.ConversaoUtil;

public class AdvogadoHonorarioDAO implements IAdvogadoHonorarioDAO{

	private static Connection conn;

	public AdvogadoHonorarioDAO() {
	}

	public AdvogadoHonorarioDAO(Connection conn) {
		AdvogadoHonorarioDAO.conn = conn;
	}
	
	//INSERIR HONORARIO
	public void LancarHonorario(AdvogadoHonorario advHonorario){
		boolean flagClose = false;
		
		
		String sql = "INSERT INTO AM_ADVOGADO_HONORARIO (NR_PROCESSO, CD_PESSOA_ADV, CD_TAREFA, DT_HONORARIO, QT_HORAS, DS_OBSERVACAO) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, advHonorario.getProcesso().getNr_processo());
			ps.setInt(2, advHonorario.getAdvogado().getCd_pessoa());
			ps.setInt(3, advHonorario.getTarefa().getCd_tarefa());
			ps.setDate(4, ConversaoUtil.converterCalendarToSQLDate(advHonorario.getDt_honorario()));
			ps.setDouble(5, advHonorario.getQt_horas());
			ps.setString(6, advHonorario.getDs_observacao());
			
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(ps!=null){
					ps.close();
				}
				if(flagClose){
					conn.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//ALTERAR HONORARIO
	public void AlterarHonorario(double duracao, String Descricao, int idHon){
		boolean flagClose = false;
		
		String sql = "UPDATE AM_ADVOGADO_HONORARIO SET QT_HORAS = ?, DS_OBSERVACAO = ? WHERE CD_HONORARIO = ?";
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			

			ps.setDouble(1, duracao);
			ps.setString(2, Descricao);
			ps.setInt(3, idHon);
			ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try{
				if(ps!=null){
					ps.close();
				}
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//CONSULTAR HONORARIO
	public AdvogadoHonorario ConsultarHonorario(int cd_honorario){
		boolean flagClose = false;
	
		
		String sql = "SELECT A.CD_HONORARIO, A.NR_PROCESSO, B.CD_PESSOA, C.CD_TAREFA , A.DT_HONORARIO, A.QT_HORAS, A.DS_OBSERVACAO FROM AM_ADVOGADO_HONORARIO A, AM_PESSOA B, AM_TAREFA C WHERE CD_HONORARIO = ? AND A.CD_PESSOA_ADV = B.CD_PESSOA AND A.CD_TAREFA = C.CD_TAREFA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		AdvogadoHonorario advHono = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_honorario);
			rs = ps.executeQuery();
			
			if(rs.next()){
				advHono = new AdvogadoHonorario();
				advHono.setCd_honorario(rs.getInt("CD_HONORARIO"));
				advHono.setProcesso(new ProcessoDAO(conn).ConsultarProcesso(rs.getInt("NR_PROCESSO")));
				advHono.setAdvogado(new GenericaDAO(conn).ConsultarAdvogado(rs.getInt("CD_PESSOA")));
				advHono.setTarefa(new GenericaDAO(conn).ConsultarTarefa(rs.getInt("CD_TAREFA")));
				advHono.setDt_honorario(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HONORARIO")));
				advHono.setQt_horas(rs.getDouble("QT_HORAS"));
				advHono.setDs_observacao(rs.getString("DS_OBSERVACAO"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return advHono;
	}
	
	
	//CONSULTAR TODOS HONORARIOS
	public List<AdvogadoHonorario> ConsultarHonorarios(){
		boolean flagClose = false;
		Statement stmt = null;
		ResultSet rs = null;
		List<AdvogadoHonorario> honorarios = new ArrayList<AdvogadoHonorario>();
		String sql = "SELECT A.CD_HONORARIO, A.NR_PROCESSO, B.CD_PESSOA, C.CD_TAREFA, A.DT_HONORARIO FROM AM_ADVOGADO_HONORARIO A, AM_PESSOA B, AM_TAREFA C WHERE A.CD_PESSOA_ADV = B.CD_PESSOA AND A.CD_TAREFA = C.CD_TAREFA ORDER BY NR_PROCESSO, DT_HONORARIO";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				AdvogadoHonorario advHono = new AdvogadoHonorario();
				advHono.setCd_honorario(rs.getInt("CD_HONORARIO"));
				advHono.setProcesso(new ProcessoDAO(conn).ConsultarProcesso(rs.getInt("NR_PROCESSO")));
				advHono.setAdvogado(new GenericaDAO(conn).ConsultarAdvogado(rs.getInt("CD_PESSOA")));
				advHono.setTarefa(new GenericaDAO(conn).ConsultarTarefa(rs.getInt("CD_TAREFA")));
				advHono.setDt_honorario(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HONORARIO")));

				
				honorarios.add(advHono);
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return honorarios;
	}
	
	//REMOVER HONORARIO
	public void removerHonorario(int cd_honorario){
		boolean flagClose = false;
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_ADVOGADO_HONORARIO WHERE CD_HONORARIO = ?";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_honorario);
			ps.execute();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(ps!=null){
					ps.close();
				}
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
}