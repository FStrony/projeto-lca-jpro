package com.jpro.lca.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jpro.lca.bean.AdvogadoProcesso;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
import com.jpro.lca.bo.AdvocaciaNegocio;
import com.jpro.lca.util.ConversaoUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ControllerProcesso extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private Processo processo;
	private List<Processo> Processos;
	private List<Pessoa> listaForum;
	private List<Pessoa> listaCliente;
	private List<Pessoa> listaAdvogado;
	private List<TipoCausa> listaCausa;
	private List<TipoCobranca> listaCobranca;
	private Processo cadastraProcesso;
	private AdvogadoProcesso advproc;
	private int idPro;

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Action(value="processo", results={
			@Result(location="/processos.jsp", name="processo")})
	public String listar(){
		cadastraProcesso = new Processo();
		advproc = new AdvogadoProcesso();
		listaForum = AdvocaciaNegocio.ListarForuns();
		listaCliente = AdvocaciaNegocio.ListarClientes();
		listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		listaCausa = AdvocaciaNegocio.ListarTipoCausa();
		listaCobranca = AdvocaciaNegocio.ListarTipoCobranca();

		return "processo";
	}
	
	@Action(value="cadastrarprocesso", results={
			@Result(location="/processos.jsp", name="cadastrarprocesso")})
	public String cadastrarProcesso(){

		AdvocaciaNegocio.inserirProcesso(cadastraProcesso);
		int pr = AdvocaciaNegocio.num(); 
		
		advproc.setDt_inicio_participacao(cadastraProcesso.getDt_abertura());
		advproc.setProcesso(pr);
		AdvocaciaNegocio.AssociarAdvProc(advproc);
		listar();
		return "cadastrarprocesso";
	}
	
	@Action(value="editaprocesso", results={
			@Result(location="/editaprocesso.jsp", name="editaprocesso")})
	public String editaProcesso(){
		//String id = request.getParameter("id");
		//AdvocaciaNegocio.alterarProcesso(Integer.parseInt(id));
		//listar();
		return "editaprocesso";
	}
	
	@Action(value="atualizaProcesso", results={
			@Result(location="/processoAtualiza.jsp", name="atualiza")})
	public String listarAtualiza(){
		
		
		Processo proc = AdvocaciaNegocio.consultarProcesso(idPro);
		
		//proAux = AdvocaciaNegocio.consultarProcesso(agendaAudiencia.getProcesso().getNr_processo());
		//advAux = AdvocaciaNegocio.ConsultarAdvogado(agendaAudiencia.getAdvogado().getCd_pessoa());
		
		//data = ConversaoUtil.ExibirData(agendaAudiencia.getDt_hora_agenda(), "dd/MM/yyyy");
		//sala = agendaAudiencia.getSl_forum();
		
		//listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		//listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		
		//retorno = "carga";
		
		return "atualiza";
	}
	
	
	 
	public List<Pessoa> getListaAdvogado() {
		return listaAdvogado;
	}

	public void setListaAdvogado(List<Pessoa> listaAdvogado) {
		this.listaAdvogado = listaAdvogado;
	}

	public Processo getCadastraProcesso() {
		return cadastraProcesso;
	}

	public void setCadastraProcesso(Processo cadastraProcesso) {
		this.cadastraProcesso = cadastraProcesso;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Processo> getProcessos() {
		return Processos;
	}

	public void setProcessos(List<Processo> processos) {
		Processos = processos;
	}

	public List<Pessoa> getListaForum() {
		return listaForum;
	}

	public void setListaForum(List<Pessoa> listaForum) {
		this.listaForum = listaForum;
	}

	public List<Pessoa> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Pessoa> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<TipoCausa> getListaCausa() {
		return listaCausa;
	}

	public void setListaCausa(List<TipoCausa> listaCausa) {
		this.listaCausa = listaCausa;
	}

	public List<TipoCobranca> getListaCobranca() {
		return listaCobranca;
	}

	public void setListaCobranca(List<TipoCobranca> listaCobranca) {
		this.listaCobranca = listaCobranca;
	}

	public AdvogadoProcesso getAdvproc() {
		return advproc;
	}

	public void setAdvproc(AdvogadoProcesso advproc) {
		this.advproc = advproc;
	}

	

}
