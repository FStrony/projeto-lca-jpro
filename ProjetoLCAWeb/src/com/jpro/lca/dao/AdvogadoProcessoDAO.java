package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IAdvogadoProcessoDAO;
import com.jpro.lca.util.ConversaoUtil;

public class AdvogadoProcessoDAO implements IAdvogadoProcessoDAO{
	private static Connection conn;

	public AdvogadoProcessoDAO() {
	}

	public AdvogadoProcessoDAO(Connection conn) {
		AdvogadoProcessoDAO.conn = conn;
	}

	//Associar Advogado ao processo
		public void AssociarAdvProc(AdvogadoProcesso advProc){
			boolean flagClose = false;
			
			
			
			String sql = "INSERT INTO AM_ADVOGADO_PROCESSO (NR_PROCESSO, CD_PESSOA_ADV, DT_INICIO_PARTICIPACAO) VALUES (?,?,?)";
			PreparedStatement ps = null;
			
			try{
				if (conn == null || conn.isClosed()) {
					conn = ConnectionFactory.getConnectionOracle();
					flagClose = true;
				}
				ps = conn.prepareStatement(sql);
				ps.setInt(1, advProc.getProcesso());
				ps.setInt(2, advProc.getAdvogado());
				ps.setDate(3, ConversaoUtil.converterCalendarToSQLDate(advProc.getDt_inicio_participacao()));
				
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
		

		public int proximoNume() {
			boolean flagClose = false;
			

			
			Statement stmt = null;
			ResultSet rs = null;
			int numero = 0;
			String sql = "SELECT MAX(A.NR_PROCESSO) FROM AM_PROCESSO A";

			try {
				if (conn == null || conn.isClosed()) {
					conn = ConnectionFactory.getConnectionOracle();
					flagClose = true;
				}
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				if(rs.next()){
				Processo pr = new Processo();
				
					pr.setNr_processo(rs.getInt("MAX(A.NR_PROCESSO)"));
					
					numero= pr.getNr_processo();
				}
				

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
					
					if(flagClose){
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return numero;
		}
	
	
}
