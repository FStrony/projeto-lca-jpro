package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IAgendaAudienciaDAO;
import com.jpro.lca.util.ConversaoUtil;

public class AgendaAudienciaDAO implements IAgendaAudienciaDAO{
	private static Connection conn;

	public AgendaAudienciaDAO() {
	}

	public AgendaAudienciaDAO(Connection conn) {
		AgendaAudienciaDAO.conn = conn;
	}
	
	//Inserir Audiencia
	public void InserirAudiencia(AgendaAudiencia agendaAudiencia){
		
		boolean flagClose = false;
		
		String sql = "INSERT INTO AM_AGENDA_AUDIENCIA (NR_PROCESSO, CD_PESSOA_ADV, DT_HORA_AGENDA, SL_FORUM) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, agendaAudiencia.getProcesso().getNr_processo());
			ps.setInt(2, agendaAudiencia.getAdvogado().getCd_pessoa());
			ps.setDate(3, ConversaoUtil.converterCalendarToSQLDate(agendaAudiencia.getDt_hora_agenda()),agendaAudiencia.getDt_hora_agenda());
			ps.setString(4, agendaAudiencia.getSl_forum());
	
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
	
	//Alterar Audiencia
	public void AlterarAudiencia(int cd_agenda, Calendar data, String sala){
		
		boolean flagClose = false;
		
		String sql = "UPDATE AM_AGENDA_AUDIENCIA SET DT_HORA_AGENDA = ?, SL_FORUM = ? WHERE CD_AGENDA = ?";
		
		PreparedStatement ps = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			conn.setAutoCommit(false);
			
			ps = conn.prepareStatement(sql);
			
			ps.setDate(1, ConversaoUtil.converterCalendarToSQLDate(data));
			ps.setString(2, sala);
			ps.setInt(3, cd_agenda);
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
	
	
	//Consulta Audiencia
	public AgendaAudiencia ConsultarAudiencia(int cd_agenda){
		boolean flagClose = false;
		
		String sql = "SELECT A.CD_AGENDA, P.NR_PROCESSO, B.CD_PESSOA, A.DT_HORA_AGENDA, A.SL_FORUM " +
				"FROM AM_AGENDA_AUDIENCIA A, AM_PESSOA B, AM_PROCESSO P " +
				"WHERE CD_AGENDA = ? " +
				"AND A.CD_PESSOA_ADV = B.CD_PESSOA " +
				"AND P.NR_PROCESSO = A.NR_PROCESSO";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		AgendaAudiencia agenda = null;
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_agenda);
			rs = ps.executeQuery();
			
			if(rs.next()){
				agenda = new AgendaAudiencia();
				agenda.setCd_agenda(rs.getInt("CD_AGENDA"));
				agenda.setProcesso(new ProcessoDAO(conn).ConsultarProcesso(rs.getInt("NR_PROCESSO")));
				agenda.setAdvogado(new GenericaDAO(conn).ConsultarAdvogado(rs.getInt("CD_PESSOA")));
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
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return agenda;
	}
	
	// Consultar Todos as Audiencias
	public List<AgendaAudiencia> ConsultarAudiencias(){
		
		boolean flagClose = false;
		Statement stmt = null;
		ResultSet rs = null;
		List<AgendaAudiencia> agendas = new ArrayList<AgendaAudiencia>();
		String sql = "SELECT A.CD_AGENDA, A.NR_PROCESSO, B.CD_PESSOA, A.DT_HORA_AGENDA, A.SL_FORUM FROM AM_AGENDA_AUDIENCIA A, AM_PESSOA B WHERE A.CD_PESSOA_ADV = B.CD_PESSOA ORDER BY A.NR_PROCESSO";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				AgendaAudiencia agenda = new AgendaAudiencia();
				agenda.setCd_agenda(rs.getInt("CD_AGENDA"));
				agenda.setProcesso(new ProcessoDAO(conn).ConsultarProcesso(rs.getInt("NR_PROCESSO")));
				agenda.setAdvogado(new GenericaDAO(conn).ConsultarAdvogado(rs.getInt("CD_PESSOA")));
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
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return agendas;
		
	}
	
	//Excluir Audiencia
	public void apagarAudiencia(int cd_agenda){
		
		boolean flagClose = false;
		PreparedStatement ps = null;
		String sql = "DELETE FROM AM_AGENDA_AUDIENCIA WHERE CD_AGENDA = ?";
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
	
	}
}
