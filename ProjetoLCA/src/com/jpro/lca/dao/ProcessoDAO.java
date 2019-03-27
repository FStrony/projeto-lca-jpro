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
import com.jpro.lca.bean.proSatus;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.factory.DBVendor;
import com.jpro.lca.interfaces.IProcessoDAO;
import com.jpro.lca.util.ConversaoUtil;

public class ProcessoDAO implements IProcessoDAO{

	// Criar Processo
	public void CriarProcesso(Processo processo){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql ="INSERT INTO AM_PROCESSO (CD_PESSOA_FORUM, CD_PESSOA_CLIENTE, CD_CAUSA, CD_COBRANCA, DS_PROCESSO, DT_ABERTURA, DT_FECHAMENTO, DD_DIA_VENCIMENTO, CD_RESULTADO, DS_OBSERVACAO) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		

		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, processo.getForum().getCd_pessoa());
			ps.setInt(2, processo.getCliente().getCd_pessoa());
			ps.setInt(3, processo.getTipoCausa().getCd_causa());
			ps.setInt(4, processo.getTipoCobranca().getCd_cobranca());
			ps.setString(5, processo.getDs_processo());
			ps.setDate(6, ConversaoUtil.converterCalendarToSQLDate(processo.getDt_abertura()));
			ps.setDate(7, ConversaoUtil.converterCalendarToSQLDate(processo.getDt_fechamento()));			
			ps.setInt(8, processo.getDd_dia_vencimento());
			ps.setInt(9, processo.getCd_resultado().getStatus());
			ps.setString(10, processo.getDs_observacao());
			
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

	
	//Alterar Processo
	
	public void AlterarProcesso(int nr_processo){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		Processo processo = null;
		
		String sql = "UPDATE AM_PROCESSO SET CD_PESSOA_FORUM = ?, CD_PESSOA_CLIENTE = ?, CD_CAUSA = ?, CD_COBRANCA = ?, DS_PROCESSO = ?, DT_ABERTURA = ?, DT_FECHAMENTO = ?, DD_DIA_VENCIMENTO = ?, CD_RESULTADO = ?, DS_OBSERVACAO = ? WHERE NR_PROCESSO = ?";
		
		PreparedStatement ps = null;
		
		try{
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
			ps.setInt(9, processo.getCd_resultado().getStatus());
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	
	//Consultar Processo
	public Processo ConsultarProcesso(int nr_processo){
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "SELECT * FROM AM_PROCESSO WHERE NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Processo processo = null;
		
		try{
			ps= conn.prepareStatement(sql);
			ps.setInt(1, nr_processo);
			rs = ps.executeQuery();
			
			if(rs.next()){
				processo = new Processo();
				processo.setNr_processo(rs.getInt("NR_PROCESSO"));
				processo.getForum().setCd_pessoa(rs.getInt("CD_PESSOA_FORUM"));
				processo.getCliente().setCd_pessoa(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.getTipoCausa().setCd_causa(rs.getInt("CD_CAUSA"));
				processo.getTipoCobranca().setCd_cobranca(rs.getInt("CD_COBRANCA"));
				processo.setDs_processo(rs.getString("DS_PROCESSO"));
				
				processo.setDt_abertura(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_ABERTURA")));
				processo.setDt_fechamento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_FECHAMENTO")));
				
				
				processo.setDd_dia_vencimento(rs.getInt("DD_DIA_VENCIMENTO"));
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return processo;
	}
	
	//Consultar Todos os Processos
	public List<Processo> ConsultarProcessos(){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<Processo> processos = new ArrayList<Processo>();
		String sql = "SELECT * FROM AM_PROCESSO";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Processo processo = new Processo();
				processo.setNr_processo(rs.getInt("NR_PROCESSO"));
				processo.getForum().setCd_pessoa(rs.getInt("CD_PESSOA_FORUM"));
				processo.getCliente().setCd_pessoa(rs.getInt("CD_PESSOA_CLIENTE"));
				processo.getTipoCausa().setCd_causa(rs.getInt("CD_CAUSA"));
				processo.getTipoCobranca().setCd_cobranca(rs.getInt("CD_COBRANCA"));
				processo.setDs_processo(rs.getString("DS_PROCESSO"));
				
				
				processo.setDt_abertura(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_ABERTURA")));
				processo.setDt_fechamento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_FECHAMENTO")));
				
				processo.setDd_dia_vencimento(rs.getInt("DD_DIA_VENCIMENTO"));
				processo.setCd_resultado(rs.getInt("CD_RESULTADO"));
				processo.setDs_observacao(rs.getString("DS_OBSERVACAO"));
				
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return processos;
	}
	
	
	//Excluir Processo
	public void apagarProcesso(int nr_processo){
	
		Connection conn = ConnectionFactory.getConnectionOracle();
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_PROCESSO WHERE NR_PROCESSO = ?";
		try{
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
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	//CONSULTAR TODOS HONORARIOS DO PROCESSO
		public List<AdvogadoHonorario> ConsultarHonorariosProcesso(int nr_processo){
			Connection conn = ConnectionFactory.getConnectionOracle();
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<AdvogadoHonorario> honorarios = new ArrayList<AdvogadoHonorario>();
			String sql = "SELECT * FROM AM_ADVOGADO_HONORARIO WHERE NR_PROCESSO = ?";
			
			try{
				ps= conn.prepareStatement(sql);
				ps.setInt(1, nr_processo);
				rs = ps.executeQuery();
				
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
					if(ps!=null){
						ps.close();
					}
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return honorarios;
		}
		
		//CONSULTAR ADVOGADOS DO PROCESSO
		public List<Pessoa> ConsultarAdvogadosProcesso(int nr_processo){
			Connection conn = ConnectionFactory.getConnectionOracle();
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Pessoa> advogados = new ArrayList<Pessoa>();
			String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_ADVOGADO_PROCESSO B WHERE B.NR_PROCESSO = ? AND A.CD_PESSOA = B.CD_PESSOA_ADV";
			
			try{
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
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return advogados;
		}
}
