package com.jpro.lca.dao;


import java.sql.PreparedStatement;
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
import com.jpro.lca.bean.Telefone;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
import com.jpro.lca.bean.TipoTelefone;
import com.jpro.lca.factory.ConnectionFactory;
import com.jpro.lca.interfaces.IGenericaDAO;

public class GenericaDAO implements IGenericaDAO{

	private static Connection conn;

	public GenericaDAO() {
	}

	public GenericaDAO(Connection conn) {
		GenericaDAO.conn = conn;
	}
	
	// LISTAR TIPO CAUSA
	public List<TipoCausa> ListarTipoCausa() {
		boolean flagClose = false;
		

		
		Statement stmt = null;
		ResultSet rs = null;
		List<TipoCausa> tipos = new ArrayList<TipoCausa>();
		String sql = "SELECT * FROM AM_TIPO_CAUSA ORDER BY DS_CAUSA";

		try {
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				
				if(flagClose){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tipos;
	}

	// LISTAR TIPO DE COBRANÇA
	public List<TipoCobranca> ListarTipoCobranca() {

		boolean flagClose = false;
	

		Statement stmt = null;
		ResultSet rs = null;
		List<TipoCobranca> tipos = new ArrayList<TipoCobranca>();
		String sql = "SELECT CD_COBRANCA, DS_COBRANCA FROM AM_TIPO_COBRANCA ORDER BY CD_COBRANCA";

		try {
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				
				if(flagClose){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tipos;
	}
	
	// LISTAR CLIENTE
	public List<Pessoa> ConsultarClientes(){
		boolean flagClose = false;
	

		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> clientes = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_CLIENTE B WHERE A.CD_PESSOA = B.CD_PESSOA_CLIENTE ORDER BY A.NM_PESSOA";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return clientes;
	}
	
	// LISTAR FORUM
	public List<Pessoa> ConsultarForuns(){
		boolean flagClose = false;
	

		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> foruns = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_FORUM B WHERE A.CD_PESSOA = B.CD_PESSOA_FORUM ORDER BY A.NM_PESSOA";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return foruns;
	}
	
	public Forum ConsultarForum(int cd_forum){
		
		boolean flagClose = false;
		
	
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_FORUM B WHERE A.CD_PESSOA = b.cd_pessoa_forum AND b.cd_pessoa_forum = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Forum forum = null;
				
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_forum);
			rs = ps.executeQuery();
			
			if(rs.next()){
				forum = new Forum();
				forum.setCd_pessoa(rs.getInt("CD_PESSOA"));
				forum.setNm_pessoa(rs.getString("NM_PESSOA"));
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
		return forum;
	}
	
	// LISTAR ADVOGADOS
	public List<Pessoa> ConsultarAdvogados(){
		boolean flagClose = false;
		
		Statement stmt = null;
		ResultSet rs = null;
		List<Pessoa> adovogados = new ArrayList<Pessoa>();
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA FROM AM_PESSOA A, AM_ADVOGADO B WHERE A.CD_PESSOA = B.CD_PESSOA_ADV ORDER BY NM_PESSOA";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
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
				
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return adovogados;
	}
	
	public Advogado ConsultarAdvogado(int cd_advogado){
		
		boolean flagClose = false;
		

				
		String sql = "SELECT A.CD_PESSOA, A.NM_PESSOA, B.NR_OAB, B.NR_CPF, B.NR_RG, B.DS_EMAIL, B.DS_PASSWORD FROM AM_PESSOA A, AM_ADVOGADO B WHERE A.CD_PESSOA = B.CD_PESSOA_ADV AND B.CD_PESSOA_ADV=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Advogado adv = null;
				
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_advogado);
			rs = ps.executeQuery();
			
			if(rs.next()){
				adv = new Advogado();
				adv.setCd_pessoa(rs.getInt("CD_PESSOA"));
				adv.setDs_email(rs.getString("DS_EMAIL"));
				adv.setDs_password(rs.getString("DS_PASSWORD"));
				adv.setNm_pessoa(rs.getString("NM_PESSOA"));
				adv.setNr_cpf(rs.getInt("NR_CPF"));
				adv.setNr_oab(rs.getInt("NR_OAB"));
				adv.setNr_rg(rs.getString("NR_RG"));
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
		return adv;
	}
		
	public Tarefa ConsultarTarefa(int cd_tarefa){
		
		boolean flagClose = false;
		

				
		String sql = "SELECT * FROM AM_TAREFA WHERE CD_TAREFA = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tarefa tarefa = null;
				
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_tarefa);
			rs = ps.executeQuery();
			
			if(rs.next()){
				tarefa = new Tarefa();
				tarefa.setCd_tarefa(rs.getInt("CD_TAREFA"));
				tarefa.setDs_tarefa(rs.getString("DS_TAREFA"));
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
		return tarefa;
	}
	
	
	
	//TAREFA
	public List<Tarefa> ConsultarTarefas(){
		boolean flagClose = false;
		

		Statement stmt = null;
		ResultSet rs = null;
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		String sql = "SELECT * FROM AM_TAREFA ORDER BY CD_TAREFA";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			
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
				
				if(flagClose){
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return tarefas;
		
	}
	//Consultar Cliente
	public Cliente ConsultarCliente(int cd_cliente){
		boolean flagClose = false;
	

		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		String sql = "SELECT CLIENTE.CD_PESSOA_CLIENTE, PESSOA.NM_PESSOA, CLIENTE.NM_RAZAO_SOCIAL,CLIENTE.NR_CNPJ, CLIENTE.NR_INSC_ESTADUAL, CLIENTE.DS_EMAIL, CLIENTE.DS_PASSWORD FROM AM_CLIENTE CLIENTE, AM_PESSOA PESSOA WHERE CLIENTE.CD_PESSOA_CLIENTE = ? AND CLIENTE.CD_PESSOA_CLIENTE = PESSOA.CD_PESSOA";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_cliente);
			rs = ps.executeQuery();
			if(rs.next()){
				cliente = new Cliente();
				cliente.setCd_pessoa(rs.getInt("CD_PESSOA_CLIENTE"));
				cliente.setNm_pessoa(rs.getString("NM_PESSOA"));
				cliente.setNm_razao_social(rs.getString("NM_RAZAO_SOCIAL"));
				cliente.setNr_cnpj(rs.getInt("NR_CNPJ"));
				cliente.setNr_insc_estadual(rs.getInt("NR_INSC_ESTADUAL"));
				cliente.setDs_email(rs.getString("DS_EMAIL"));
				cliente.setDs_password(rs.getString("DS_PASSWORD"));
				
				
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
		return cliente;
	}
	
	//Consultar Tipo Causa
	public TipoCausa ConsultarTipoCausa(int cd_causa){
		boolean flagClose = false;
	

		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCausa causa = null;
		String sql = "SELECT * FROM AM_TIPO_CAUSA WHERE CD_CAUSA = ?";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_causa);
			rs = ps.executeQuery();
			if(rs.next()){
				causa = new TipoCausa();
				causa.setCd_causa(rs.getInt("CD_CAUSA"));
				causa.setDs_causa(rs.getString("DS_CAUSA"));
				
				
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
		return causa;
	}
	//Consultar Tipo Cobranca
	public TipoCobranca ConsultarTipoCobranca(int cd_cobranca){
		boolean flagClose = false;
	

		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoCobranca cobranca = null;
		String sql = "SELECT CD_COBRANCA, DS_COBRANCA, TX_JUROS, VL_MORA_DIARIA FROM AM_TIPO_COBRANCA WHERE CD_COBRANCA = ?";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_cobranca);
			rs = ps.executeQuery();
			if(rs.next()){
				cobranca = new TipoCobranca();
				cobranca.setCd_cobranca(rs.getInt("CD_COBRANCA"));
				cobranca.setDs_cobranca(rs.getString("DS_COBRANCA"));
				cobranca.setTx_juros(rs.getDouble("TX_JUROS"));
				cobranca.setVl_mora_diaria(rs.getDouble("VL_MORA_DIARIA"));
				
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
		return cobranca;
	}
	
	//Consultar Tipo telefone
	public TipoTelefone ConsultarTipoTelefon(int cd_tipo){
		boolean flagClose = false;
	

		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoTelefone tipo= null;
		String sql = "SELECT CD_TIPO_TELEFONE, DS_TIPO_TELEFONE FROM AM_TIPO_TELEFONE WHERE CD_TIPO_TELEFONE = ?";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_tipo);
			rs = ps.executeQuery();
			if(rs.next()){
				tipo = new TipoTelefone();
				tipo.setCd_tipo_telefone(rs.getInt("CD_TIPO_TELEFONE"));
				tipo.setDs_tipo_telefone(rs.getString("DS_TIPO_TELEFONE"));
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
		return tipo;
	}
	
	
	//Consultar  telefone
	public List<Telefone> ListarTelefon(int cd_cliente){
		boolean flagClose = false;
	

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Telefone> telefones = new ArrayList<Telefone>();
		String sql = "SELECT A.CD_TELEFONE, B.CD_TIPO_TELEFONE, A.NR_DDD, A.NR_TELEFONE FROM AM_TELEFONE A, AM_TIPO_TELEFONE B WHERE A.CD_TIPO_TELEFONE = B.CD_TIPO_TELEFONE AND A.CD_PESSOA = ?";
		
		try{
			if (conn == null || conn.isClosed()) {
				conn = ConnectionFactory.getConnectionOracle();
				flagClose = true;
			}
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cd_cliente);
			rs = ps.executeQuery();
			while(rs.next()){
				Telefone telefone = new Telefone();
				telefone.setCd_telefone(rs.getInt("CD_TELEFONE"));
				telefone.setTipotelefone(new GenericaDAO(conn).ConsultarTipoTelefon(rs.getInt("CD_TIPO_TELEFONE")));
				telefone.setNr_ddd(rs.getInt("NR_DDD"));
				telefone.setNr_telefone(rs.getInt("NR_TELEFONE"));
				
				telefones.add(telefone);
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
		return telefones;
	}
}
