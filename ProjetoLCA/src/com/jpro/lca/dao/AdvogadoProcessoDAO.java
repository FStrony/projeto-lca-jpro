package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IAdvogadoProcessoDAO;
import com.jpro.lca.util.ConversaoUtil;

public class AdvogadoProcessoDAO implements IAdvogadoProcessoDAO{

	//Associar Advogado ao processo
	public void AssociarAdvProc(AdvogadoProcesso advProc){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "INSERT INTO AM_ADVOGADO_PROCESSO (NR_PROCESSO, CD_PESSOA_ADV, DT_INICIO_PARTICIPACAO) VALUES (?,?,?)";
		PreparedStatement ps = null;
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, advProc.getProcesso().getNr_processo());
			ps.setInt(2, advProc.getAdvogado().getCd_pessoa());
			ps.setDate(3, ConversaoUtil.converterCalendarToSQLDate(advProc.getDt_inicio_participacao()));
			
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
	
	//Desassociar Advogado
	public void DesassociarAdvogado(AdvogadoProcesso advProc){
		
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM AM_ADVOGADO_PROCESSO WHERE NR_PROCESSO = ? AND CD_PESSOA_ADV = ?";
		
		try{
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, advProc.getProcesso().getNr_processo());
			ps.setInt(2, advProc.getAdvogado().getCd_pessoa());
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
