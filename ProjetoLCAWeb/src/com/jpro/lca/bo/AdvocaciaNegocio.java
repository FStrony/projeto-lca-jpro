package com.jpro.lca.bo;

import java.util.Calendar;
import java.util.List;

import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.bean.Cliente;
import com.jpro.lca.bean.Forum;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bean.Telefone;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
import com.jpro.lca.bean.TipoTelefone;
import com.jpro.lca.bean.Titulo;
import com.jpro.lca.factory.DAOFactory;
import com.jpro.lca.factory.DBVendor;
import com.jpro.lca.interfaces.IAdvogadoHonorarioDAO;
import com.jpro.lca.interfaces.IAdvogadoProcessoDAO;
import com.jpro.lca.interfaces.IAgendaAudienciaDAO;
import com.jpro.lca.interfaces.IGenericaDAO;
import com.jpro.lca.interfaces.IProcessoDAO;
import com.jpro.lca.interfaces.ITituloDAO;

public class AdvocaciaNegocio {

	//PROCESSO
	public static void inserirProcesso(Processo processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		dao.CriarProcesso(processo);
	}

	public static void alterarProcesso(int nr_processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		dao.AlterarProcesso(nr_processo);
	}
	
	public static void excluirProcesso(int nr_processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		dao.apagarProcesso(nr_processo);
	}
	
	public static Processo consultarProcesso(int nr_processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		return dao.ConsultarProcesso(nr_processo);
	}
	
	public static List<Processo> ListarProcessos()	{
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		return dao.ConsultarProcessos();
	}
	
	public static List<Pessoa> ListarAdvogadosProcesso(int nr_processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		return dao.ConsultarAdvogadosProcesso(nr_processo);
	}
	
	public static List<AdvogadoHonorario> ListarHonorariosProcesso(int nr_processo){
		IProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getProcessoDAO();
		return dao.ConsultarHonorariosProcesso(nr_processo);
	}
	
	//TITULO
	public static Titulo consultarTitulo(int nr_titulo){
		ITituloDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getTituloDAO();
		return dao.ConsultarTitulo(nr_titulo);
	}
	
	public static List<Titulo> ListarTitulosEmAberto(int nr_processo){
		ITituloDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getTituloDAO();
		return dao.ConsultarTitulosEmAberto(nr_processo);
	}
	
	//ASSOCIAR ADVOGADO AO PROCESSO
	public static void AssociarAdvProc(AdvogadoProcesso advProc){
		IAdvogadoProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoProcessoDAO();
		dao.AssociarAdvProc(advProc);
	}

	
	public static int num(){
		IAdvogadoProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoProcessoDAO();
		return dao.proximoNume();
	}

	//AGENDA AUDIENCIA
	public static void agendarAudiencia(AgendaAudiencia agendaAudiencia){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		dao.InserirAudiencia(agendaAudiencia);
	}

	public static void alterarAudiencia(int cd_agenda, Calendar data, String sala){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		dao.AlterarAudiencia(cd_agenda, data, sala);
	}
	
	public static void excluirAudiencia(int cd_agenda){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		dao.apagarAudiencia(cd_agenda);
	}
	
	public static AgendaAudiencia consultarAudiencia(int cd_agenda){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		return dao.ConsultarAudiencia(cd_agenda);
	}
	
	public static List<AgendaAudiencia> ListarAudiencias()	{
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		return dao.ConsultarAudiencias();
	}
	
	//HONORARIOS
	public static void lancarHonorarios(AdvogadoHonorario advHonorario){
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		dao.LancarHonorario(advHonorario);
	}

	public static void alterarHonorario(double duracao, String desc, int idHon){
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		dao.AlterarHonorario(duracao, desc, idHon);
	}
	
	public static void excluirHonorario(int cd_honorario){
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		dao.removerHonorario(cd_honorario);
	}
	
	public static AdvogadoHonorario consultarHonoraroi(int cd_honorario){
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		return dao.ConsultarHonorario(cd_honorario);
	}
	
	public static List<AdvogadoHonorario> ListarHonorarios()	{
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		return dao.ConsultarHonorarios();
	}
	
	//GENERICA
	public static List<TipoCausa> ListarTipoCausa(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ListarTipoCausa();
	}
	
	public static List<TipoCobranca> ListarTipoCobranca(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ListarTipoCobranca();
	}
	
	public static List<Pessoa> ListarClientes(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarClientes();
	}
	
	public static List<Pessoa> ListarForuns(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarForuns();
	}
	
	public static List<Pessoa> ListarAdvogados(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarAdvogados();
	}
	
	public static List<Tarefa> ListarTarefas(){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarTarefas();
	}
	
	public static Advogado ConsultarAdvogado(int cd_advogado){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarAdvogado(cd_advogado);
	}
	
	public static Forum ConsultarForum(int cd_forum){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarForum(cd_forum);
	}
	
	public static Tarefa ConsultarTarefa(int cd_tarefa){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarTarefa(cd_tarefa);
	}

	public static Cliente ConsultarCliente(int cd_cliente){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarCliente(cd_cliente);
	}
	
	public static TipoCausa ConsultarTipoCausa(int cd_causa){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarTipoCausa(cd_causa);
	}
	
	public static TipoCobranca ConsultarTipoCobranca(int cd_cobranca){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarTipoCobranca(cd_cobranca);
	}
	
	public static TipoTelefone ConsutlarTipoTelefone(int cd_tipo){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ConsultarTipoTelefon(cd_tipo);
	}
	
	public static List<Telefone> ListarTelefone(int cd_cliente){
		IGenericaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getGenericaDAO();
		return dao.ListarTelefon(cd_cliente);
	}
}
