package com.jpro.lca.bo;

import java.util.List;

import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
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
	
	public static void DesassociarAdvProc(AdvogadoProcesso advProc){
		IAdvogadoProcessoDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoProcessoDAO();
		dao.DesassociarAdvogado(advProc);
	}
	

	//AGENDA AUDIENCIA
	public static void agendarAudiencia(AgendaAudiencia agendaAudiencia){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		dao.InserirAudiencia(agendaAudiencia);
	}

	public static void alterarAudiencia(int cd_agenda){
		IAgendaAudienciaDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAgendaAudienciaDAO();
		dao.AlterarAudiencia(cd_agenda);
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

	public static void alterarHonorario(int cd_honorario){
		IAdvogadoHonorarioDAO dao = DAOFactory.getDAOFactory(DBVendor.ORACLE).getAdvogadoHonorarioDAO();
		dao.AlterarHonorario(cd_honorario);
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
}
