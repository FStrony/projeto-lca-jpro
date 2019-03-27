package com.jpro.lca.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.Cliente;
import com.jpro.lca.bean.Forum;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IGenericaDAO;

public class GenericaDAO implements IGenericaDAO{

	// LISTAR TIPO CAUSA
	public List<TipoCausa> ListarTipoCausa() {

		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<TipoCausa> tipos = new ArrayList<TipoCausa>();
		String sql = "SELECT * FROM AM_TIPO_CAUSA";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				TipoCausa tipo = new TipoCausa();
				tipo.setCd_causa(rs.getInt("CD_CAUSA"));
				tipo.setDs_causa(rs.getString("DS_CAUSA"));

				tipos.add(tipo);
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tipos;
	}

	// LISTAR TIPO DE COBRANÇA
	public List<TipoCobranca> ListarTipoCobranca() {

		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<TipoCobranca> tipos = new ArrayList<TipoCobranca>();
		String sql = "SELECT CD_COBRANCA, DS_COBRANCA FROM AM_TIPO_COBRANCA";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				TipoCobranca tipo = new TipoCobranca();
				tipo.setCd_cobranca(rs.getInt("CD_COBRANCA"));
				tipo.setDs_cobranca(rs.getString("DS_COBRANCA"));

				tipos.add(tipo);
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tipos;
	}
	
	// LISTAR CLIENTE
	public List<Pessoa> ConsultarClientes(){
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> clientes = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_CLIENTE B WHERE A.CD_PESSOA = B.CD_PESSOA_CLIENTE";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setCd_pessoa(rs.getInt("CD_PESSOA"));
				cliente.setNm_pessoa(rs.getString("NM_PESSOA"));
				
				clientes.add(cliente);
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
		return clientes;
	}
	
	// LISTAR FORUM
	public List<Pessoa> ConsultarForuns(){
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> foruns = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_FORUM B WHERE A.CD_PESSOA = B.CD_PESSOA_FORUM";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Forum forum = new Forum();
				forum.setCd_pessoa(rs.getInt("CD_PESSOA"));
				forum.setNm_pessoa(rs.getString("NM_PESSOA"));
				
				foruns.add(forum);
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
		return foruns;
	}
	
	// LISTAR ADVOGADOS
	public List<Pessoa> ConsultarAdvogados(){
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> adovogados = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_ADVOGADO B WHERE A.CD_PESSOA = B.CD_PESSOA_ADV";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Advogado adv = new Advogado();
				adv.setCd_pessoa(rs.getInt("CD_PESSOA"));
				adv.setNm_pessoa(rs.getString("NM_PESSOA"));
				
				adovogados.add(adv);
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
		return adovogados;
	}
		
	//TAREFA
	public List<Tarefa> ConsultarTarefas(){
		Connection conn = ConnectionFactory.getConnectionOracle();
		Statement stmt = null;
		ResultSet rs = null;
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "SELECT * FROM AM_TAREFA";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Tarefa tarefa = new Tarefa();
				tarefa.setCd_tarefa(rs.getInt("CD_TAREFA"));
				tarefa.setDs_tarefa(rs.getString("DS_TAREFA"));
				
				tarefas.add(tarefa);
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
		return tarefas;
		
	}
}
