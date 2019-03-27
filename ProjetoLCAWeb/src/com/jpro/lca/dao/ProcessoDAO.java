package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IProcessoDAO;
import com.jpro.lca.util.ConversaoUtil;

public class ProcessoDAO implements IProcessoDAO{


	private static Connection conn;

	public ProcessoDAO() {
	}

	public ProcessoDAO(Connection conn) {
		ProcessoDAO.conn = conn;
	}
	
	// Criar Processo
	public void CriarProcesso(Processo processo){
		boolean flagClose = false;
		
		
		String sql ="INSERT INTO AM_PROCESSO (CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO, DT_ABERTURA, DD_DIA_VENCIMENTO, CD_RESULTADO, DS_OBSERVACAO) VALUES (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		

		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, processo.getForum().getCd_pessoa());
			ps.setInt(2, processo.getCliente().getCd_pessoa());
			ps.setInt(3, processo.getTipoCausa().getCd_causa());
			ps.setInt(4, processo.getTipoCobranca().getCd_cobranca());
			ps.setString(5, processo.getDs_processo());
			ps.setDate(6, ConversaoUtil.converterCalendarToSQLDate(processo.getDt_abertura()));			
			ps.setInt(7, processo.getDd_dia_vencimento());
			ps.setInt(8, 0);
			ps.setString(9, processo.getDs_observacao());
			
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

	
	//Alterar Processo
	
	public void AlterarProcesso(int nr_processo){
		
		boolean flagClose = false;
		
		Processo processo = null;
		
		String sql = "UPDATE AM_PROCESSO SET CD_PESSOA_FORUM = ?, CD_PESSOA_CLIENTE = ?, CD_CAUSA = ?, CD_COBRANCA = ?, DS_PROCESSO = ?, DT_ABERTURA = ?, DT_FECHAMENTO = ?, DD_DIA_VENCIMENTO = ?, CD_RESULTADO = ?, DS_OBSERVACAO = ? WHERE NR_PROCESSO = ?";
		
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			conn.setAutoCommit(false);
			
			processo = new Processo();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, processo.getForum().getCd_pessoa());
			ps.setInt(2, processo.getCliente().getCd_pessoa());
			ps.setInt(3, processo.getTipoCausa().getCd_causa());
			ps.setInt(4, processo.getTipoCobranca().getCd_cobranca());
			ps.setString(5, processo.getDs_processo());
			ps.setDate(6, ConversaoUtil.converterCalendarToSQLDate(processo.getDt_abertura()));
			ps.setDate(7, ConversaoUtil.converterCalendarToSQLDate(processo.getDt_fechamento()));
			ps.setInt(8, processo.getDd_dia_vencimento());
			ps.setInt(9, processo.getCd_resultado());
			ps.setString(10, processo.getDs_observacao());
			ps.setInt(11, nr_processo);
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
	
	
	
	//Consultar Processo
	public Processo ConsultarProcesso(int nr_processo){
		boolean flagClose = false;
		
		String sql = "SELECT A.NR_PROCESSO, A.CD_PESSOA_FORUM, A.CD_PESSOA_CLIENTE, CAUSA.CD_CAUSA, COBRANCA.CD_COBRANCA, A.DS_PROCESSO, A.DT_ABERTURA, A.DT_FECHAMENTO, A.DD_DIA_VENCIMENTO, A.CD_RESULTADO, A.DS_OBSERVACAO FROM AM_PROCESSO A, AM_PESSOA FORUM, AM_PESSOA CLIENTE, AM_TIPO_CAUSA CAUSA, AM_TIPO_COBRANCA COBRANCA WHERE NR_PROCESSO = ? AND FORUM.CD_PESSOA = A.CD_PESSOA_FORUM AND CLIENTE.CD_PESSOA = A.CD_PESSOA_CLIENTE AND CAUSA.CD_CAUSA = A.CD_CAUSA AND COBRANCA.CD_COBRANCA = A.CD_COBRANCA";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps= conn.prepareStatement(sql);
			ps.setInt(1, nr_processo);
			rs = ps.executeQuery();
			
			if(rs.next()){
				processo = new Processo();
				processo.setNr_processo(rs.getInt("NR_PROCESSO"));
				processo.setForum(new GenericaDAO(conn).ConsultarForum(rs.getInt("CD_PESSOA_FORUM")));
				processo.setCliente(new GenericaDAO(conn).ConsultarCliente(rs.getInt("CD_PESSOA_CLIENTE")));
				processo.setTipoCausa(new GenericaDAO(conn).ConsultarTipoCausa((rs.getInt("CD_CAUSA"))));
				processo.setTipoCobranca(new GenericaDAO(conn).ConsultarTipoCobranca(rs.getInt("CD_COBRANCA")));
				processo.setDs_processo(rs.getString("DS_PROCESSO"));
				
				processo.setDt_abertura(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_ABERTURA")));
				processo.setDt_fechamento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_FECHAMENTO")));
				
				
				processo.setDd_dia_vencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				//status.setStatus(rs.getInt("CD_RESULTADO"));
				processo.setCd_resultado(rs.getInt("CD_RESULTADO"));
				processo.setDs_observacao(rs.getString("DS_OBSERVACAO"));
		
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
		return processo;
	}
	
	//Consultar Todos os Processos
	public List<Processo> ConsultarProcessos(){
		
		boolean flagClose = false;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Processo> processos = new ArrayList<Processo>();
		String sql = "SELECT NR_PROCESSO, DS_PROCESSO, DT_ABERTURA, DT_FECHAMENTO, CD_RESULTADO FROM AM_PROCESSO WHERE CD_RESULTADO < 3 ORDER BY NR_PROCESSO";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Processo processo = new Processo();
				
				processo.setNr_processo(rs.getInt("NR_PROCESSO"));
				processo.setDs_processo(rs.getString("DS_PROCESSO"));
				processo.setDt_abertura(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_ABERTURA")));
				processo.setDt_fechamento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_FECHAMENTO")));
				processo.setCd_resultado(rs.getInt("CD_RESULTADO"));
				
				processos.add(processo);
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
		return processos;
	}
	
	
	//mudar status do processo
	public void apagarProcesso(int nr_processo){
		
		boolean flagClose = false;
		
		Processo processo = null;
		
		String sql = "UPDATE AM_PROCESSO SET CD_RESULTADO = ? WHERE NR_PROCESSO = ?";
		
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			conn.setAutoCommit(false);
			
			processo = new Processo();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setInt(2, nr_processo);
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

	
	//Excluir Processo
	public void deletarProcesso(int nr_processo){
	
		boolean flagClose = false;
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_PROCESSO WHERE NR_PROCESSO = ?";
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nr_processo);
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

	
	//CONSULTAR TODOS HONORARIOS DO PROCESSO
		public List<AdvogadoHonorario> ConsultarHonorariosProcesso(int nr_processo){
			boolean flagClose = false;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<AdvogadoHonorario> honorarios = new ArrayList<AdvogadoHonorario>();
			String sql = "SELECT A.CD_HONORARIO, B.CD_PESSOA, C.CD_TAREFA, A.DT_HONORARIO FROM AM_ADVOGADO_HONORARIO A, AM_PESSOA B, AM_TAREFA C WHERE A.CD_PESSOA_ADV = B.CD_PESSOA AND A.CD_TAREFA = C.CD_TAREFA AND NR_PROCESSO = ? ORDER BY NR_PROCESSO, DT_HONORARIO";
			
			try{
				if (conn == null || conn.isClosed()) {
					conn = ConnectionFactory.getConnectionOracle();
					flagClose = true;
				}
				ps= conn.prepareStatement(sql);
				ps.setInt(1, nr_processo);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					AdvogadoHonorario advHono = new AdvogadoHonorario();
					advHono.setCd_honorario(rs.getInt("CD_HONORARIO"));
					advHono.setAdvogado(new GenericaDAO(conn).ConsultarAdvogado(rs.getInt("CD_PESSOA")));
					advHono.setTarefa(new GenericaDAO(conn).ConsultarTarefa(rs.getInt("CD_TAREFA")));
					advHono.setDt_honorario(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HONORARIO")));
;
					
					honorarios.add(advHono);
					
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
			return honorarios;
		}
		
		//CONSULTAR ADVOGADOS DO PROCESSO
		public List<Pessoa> ConsultarAdvogadosProcesso(int nr_processo){
			boolean flagClose = false;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Pessoa> advogados = new ArrayList<Pessoa>();
			String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_ADVOGADO_PROCESSO B WHERE B.NR_PROCESSO = ? AND A.CD_PESSOA = B.CD_PESSOA_ADV";
			
			try{
				if (conn == null || conn.isClosed()) {
					conn = ConnectionFactory.getConnectionOracle();
					flagClose = true;
				}
				
				ps= conn.prepareStatement(sql);
				ps.setInt(1, nr_processo);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					Advogado adv = new Advogado();
					adv.setCd_pessoa(rs.getInt("CD_PESSOA"));
					adv.setNm_pessoa(rs.getString("NM_PESSOA"));
					
					advogados.add(adv);
					
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
			return advogados;
		}
}
