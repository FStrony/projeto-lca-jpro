package com.jpro.lca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jpro.lca.bean.Titulo;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.ITituloDAO;
import com.jpro.lca.util.ConversaoUtil;

public class TituloDAO implements ITituloDAO{


	//Consultar Titulo
	public Titulo ConsultarTitulo(int nr_titulo){
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "SELECT * FROM AM_TITULO WHERE NR_TITULO = ?";
		PreparedStatement ps = null;
		ResultSet rs= null;
		Titulo titulo = null;
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nr_titulo);
			rs = ps.executeQuery();
			
			if(rs.next()){
				titulo = new Titulo();
				titulo.setNr_titulo(rs.getInt("NR_TITULO"));
				titulo.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				titulo.setNr_agencia_cedente(rs.getInt("NR_AGENCIA"));
				titulo.setDt_documento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_DOCUMENTO")));
				titulo.setDt_vencimento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_VENCIMENTO")));
				titulo.setVl_documento(rs.getDouble("VL_DOCUMENTO"));
				
				
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
		return titulo;
		
	}
	

	
	// ConsultarTitulos NÃO PAGOS por processo
	public List<Titulo> ConsultarTitulosEmAberto(int nr_processo){
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		String sql = "SELECT * FROM AM_TITULO A LEFT OUTER JOIN AM_TITULO_PAGO PAGO ON A.NR_TITULO = PAGO.NR_TITULO WHERE PAGO.NR_TITULO IS NULL AND NR_PROCESSO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Titulo> titulos = new ArrayList<Titulo>();
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nr_processo);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Titulo titulo = new Titulo();
				titulo.setNr_titulo(rs.getInt("NR_TITULO"));
				titulo.getProcesso().setNr_processo(rs.getInt("NR_PROCESSO"));
				titulo.setNr_agencia_cedente(rs.getInt("NR_AGENCIA"));
				titulo.setDt_documento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_DOCUMENTO")));
				titulo.setDt_vencimento(ConversaoUtil.converterSQLDateToCalendar(rs.getDate("DT_VENCIMENTO")));
				titulo.setVl_documento(rs.getDouble("VL_DOCUMENTO"));
				
				titulos.add(titulo);
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
		return titulos;
	}
	
	
	
	
}
