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

	//INSERIR HONORARIO
	public void LancarHonorario(AdvogadoHonorario advHonorario){
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "INSERT INTO AM_ADVOGADO_HONORARIO (NR_PROCESSO, CD_PESSOA_ADV, CD_TAREFA, DT_HONORARIO, QT_HORAS, DS_OBSERVACAO) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try{
			
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
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//ALTERAR HONORARIO
	public void AlterarHonorario(int cd_honorario){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		AdvogadoHonorario advHonorario = null;
		String sql = "UPDATE AM_ADVOGADO_HONORARIO SET NR_PROCESSO = ?, CD_PESSOA_ADV = ?, CD_TAREFA = ?, DT_HONORARIO = ?, QT_HORAS = ?, DS_OBSERVACAO = ? WHERE CD_HONORARIO = ?";
		PreparedStatement ps = null;
		
		try{
			
			conn.setAutoCommit(false);
			advHonorario = new AdvogadoHonorario();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, advHonorario.getProcesso().getNr_processo());
			ps.setInt(2, advHonorario.getAdvogado().getCd_pessoa());
			ps.setInt(3, advHonorario.getTarefa().getCd_tarefa());
			ps.setDate(4, ConversaoUtil.converterCalendarToSQLDate(advHonorario.getDt_honorario()));
			ps.setDouble(5, advHonorario.getQt_horas());
			ps.setString(6, advHonorario.getDs_observacao());
			ps.setInt(7, cd_honorario);
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	//CONSULTAR HONORARIO
	public AdvogadoHonorario ConsultarHonorario(int cd_honorario){
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "SELECT * FROM AM_ADVOGADO_HONORARIO WHERE CD_HONORARIO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		AdvogadoHonorario advHono = null;
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_honorario);
			rs = ps.executeQuery();
			
			if(rs.next()){
				advHono = new AdvogadoHonorario();
				advHono.setCd_honorario(rs.getInt("CD_HONORARIO"));
				advHono.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				advHono.getAdvogado().setCd_pessoa(rs.getInt("CD_PESSOA_ADV"));
				advHono.getTarefa().setCd_tarefa(rs.getInt("CD_TAREFA"));
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return advHono;
	}
	
	
	//CONSULTAR TODOS HONORARIOS
	public List<AdvogadoHonorario> ConsultarHonorarios(){
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<AdvogadoHonorario> honorarios = new ArrayList<AdvogadoHonorario>();
		String sql = "SELECT * FROM AM_ADVOGADO_HONORARIO";
		
		try{
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				AdvogadoHonorario advHono = new AdvogadoHonorario();
				advHono.setCd_honorario(rs.getInt("CD_HONORARIO"));
				advHono.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				advHono.getAdvogado().setCd_pessoa(rs.getInt("CD_PESSOA_ADV"));
				advHono.getTarefa().setCd_tarefa(rs.getInt("CD_TAREFA"));
				advHono.setDt_honorario(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HONORARIO")));
				advHono.setQt_horas(rs.getDouble("QT_HORAS"));
				advHono.setDs_observacao(rs.getString("DS_OBSERVACAO"));
				
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return honorarios;
	}
	
	//REMOVER HONORARIO
	public void removerHonorario(int cd_honorario){
		Connection conn = ConnectionFactory.getConnectionOracle();
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_ADVOGADO_HONORARIO WHERE CD_HONORARIO = ?";
		
		try{
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
}