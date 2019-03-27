package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IAgendaAudienciaDAO;
import com.jpro.lca.util.ConversaoUtil;

public class AgendaAudienciaDAO implements IAgendaAudienciaDAO{

	
	//Inserir Audiencia
	public void InserirAudiencia(AgendaAudiencia agendaAudiencia){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "INSERT INTO AM_AGENDA_AUDIENCIA (NR_PROCESSO, CD_PESSOA_ADV, DT_HORA_AGENDA, SL_FORUM) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, agendaAudiencia.getProcesso().getNr_processo());
			ps.setInt(2, agendaAudiencia.getAdvogado().getCd_pessoa());
			ps.setDate(3, ConversaoUtil.converterCalendarToSQLDate(agendaAudiencia.getDt_hora_agenda()));
			ps.setString(4, agendaAudiencia.getSl_forum());
	
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
	public void AlterarAudiencia(int cd_agenda){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		AgendaAudiencia agendaAudiencia = null;
		
		String sql = "UPDATE AM_AGENDA_AUDIENCIA SET NR_PROCESSO = ?, CD_PESSOA_ADV = ?, DT_HORA_AGENDA = ?, SL_FORUM = ? WHERE CD_AGENDA = ?";
		
		PreparedStatement ps = null;
		
		try{
			conn.setAutoCommit(false);
			
			agendaAudiencia = new AgendaAudiencia();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, agendaAudiencia.getProcesso().getNr_processo());
			ps.setInt(2, agendaAudiencia.getAdvogado().getCd_pessoa());
			ps.setDate(3, ConversaoUtil.converterCalendarToSQLDate(agendaAudiencia.getDt_hora_agenda()));
			ps.setString(4, agendaAudiencia.getSl_forum());
			ps.setInt(5, cd_agenda);
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
	
	
	//Consulta Audiencia
	public AgendaAudiencia ConsultarAudiencia(int cd_agenda){
		Connection conn =  ConnectionFactory.getConnectionOracle();
		
		String sql = "SELECT * FROM AM_AGENDA_AUDIENCIA WHERE CD_AGENDA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		AgendaAudiencia agenda = null;
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_agenda);
			rs = ps.executeQuery();
			
			if(rs.next()){
				agenda = new AgendaAudiencia();
				agenda.setCd_agenda(rs.getInt("CD_AGENDA"));
				agenda.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				agenda.getAdvogado().setCd_pessoa(rs.getInt("CD_PESSOA_ADV"));
				agenda.setDt_hora_agenda(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HORA_AGENDA")));
				agenda.setSl_forum(rs.getString("SL_FORUM"));
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
		return agenda;
	}
	
	// Consultar Todos as Audiencias
	public List<AgendaAudiencia> ConsultarAudiencias(){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<AgendaAudiencia> agendas = new ArrayList<AgendaAudiencia>();
		String sql = "SELECT * FROM AM_AGENDA_AUDIENCIA";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				AgendaAudiencia agenda = new AgendaAudiencia();
				agenda.setCd_agenda(rs.getInt("CD_AGENDA"));
				agenda.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				agenda.getAdvogado().setCd_pessoa(rs.getInt("CD_PESSOA_ADV"));
				agenda.setDt_hora_agenda(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_HORA_AGENDA")));
				agenda.setSl_forum(rs.getString("SL_FORUM"));
				
				agendas.add(agenda);
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
		return agendas;
		
	}
	
	//Excluir Audiencia
	public void apagarAudiencia(int cd_agenda){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_AGENDA_AUDIENCIA WHERE CD_AGENDA = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_agenda);
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
