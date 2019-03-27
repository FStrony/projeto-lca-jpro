package com.jpro.lca.action;

import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.AgendaAudiencia;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.bo.AdvocaciaNegocio;
import com.jpro.lca.util.ConversaoUtil;
import com.jpro.lca.util.EnviaEmail;
import com.opensymphony.xwork2.ActionSupport;

public class ControllerAudiencia extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private List<Processo> listaProcesso;
	private List<Pessoa> listaAdvogado;
	private final String espaco = " - ";
	private AgendaAudiencia agendaAudiencia;
	private String hora;
	private Calendar datahora;
	private int idAud;
	private int idPro;
	private Processo proAux;
	private Advogado advAux;
	private String data;
	private String sala;
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Processo getProAux() {
		return proAux;
	}

	public void setProAux(Processo proAux) {
		this.proAux = proAux;
	}

	public Advogado getAdvAux() {
		return advAux;
	}

	public void setAdvAux(Advogado advAux) {
		this.advAux = advAux;
	}

	private String retorno = null;

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public Calendar getDatahora() {
		return datahora;
	}

	public void setDatahora(Calendar datahora) {
		this.datahora = datahora;
	}

	public AgendaAudiencia getAgendaAudiencia() {
		return agendaAudiencia;
	}

	public void setAgendaAudiencia(AgendaAudiencia agendaAudiencia) {
		this.agendaAudiencia = agendaAudiencia;
	}

	public List<Pessoa> getListaAdvogado() {
		return listaAdvogado;
	}

	public void setListaAdvogado(List<Pessoa> listaAdvogado) {
		this.listaAdvogado = listaAdvogado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Processo> getListaProcesso() {
		return listaProcesso;
	}

	public void setListaProcesso(List<Processo> listaProcesso) {
		this.listaProcesso = listaProcesso;
	}

	public String getEspaco() {
		return espaco;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Action(value="audiencia", results={
			@Result(location="/audiencias.jsp", name="audiencia")})
	public String listar(){
		listaProcesso = AdvocaciaNegocio.ListarProcessos();
		
		if (idPro > 0){
			listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		} else {
			listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		}
		
		//retorno = "carga";
		
		return "audiencia";
	}
	
	@Action(value="atualizaAudiencia", results={
			@Result(location="/audienciasAtualiza.jsp", name="atualiza")})
	public String listarAtualiza(){

		agendaAudiencia = AdvocaciaNegocio.consultarAudiencia(idAud);
		
		proAux = AdvocaciaNegocio.consultarProcesso(agendaAudiencia.getProcesso().getNr_processo());
		advAux = AdvocaciaNegocio.ConsultarAdvogado(agendaAudiencia.getAdvogado().getCd_pessoa());
		
		data = ConversaoUtil.ExibirData(agendaAudiencia.getDt_hora_agenda(), "dd/MM/yyyy");
		sala = agendaAudiencia.getSl_forum();
		
		//listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		//listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		
		//retorno = "carga";
		
		return "atualiza";
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getIdAud() {
		return idAud;
	}

	public void setIdAud(int idAud) {
		this.idAud = idAud;
	}

	@Action(value="agendar", results={
			@Result(location="/audiencias.jsp", name="audiencia")})
	public String agendaAudiencia(){
		
		if(agendaAudiencia == null ||
				agendaAudiencia.getProcesso().getNr_processo() == 0 ||
				agendaAudiencia.getAdvogado().getCd_pessoa() == 0 ||
				agendaAudiencia.getSl_forum() == ""){
			retorno = "erro";
		} else {
		
			agendaAudiencia.setDt_hora_agenda(datahora);
		
			try{
				AdvocaciaNegocio.agendarAudiencia(agendaAudiencia);
			}catch(Exception e){
				e.printStackTrace();
				retorno = "erro";
			}finally{
				//EnviaEmail.enviar(agendaAudiencia);
				retorno = "cadastro";
			}
		}
		
		listar();
		return "audiencia";
	}
	
	@Action(value="atualizarAgenda", results={
			@Result(location="/audiencias.jsp", name="atualizarAgenda")})
	public String atualizarAgenda(){
		
	if(idAud <= 0){
			retorno = "erro";
		} else {
		
			try{
				Calendar cdata = null; 
				cdata = ConversaoUtil.converterStringToCalendar(data, "DD/MM/yyyy");
				AdvocaciaNegocio.alterarAudiencia(idAud, cdata, sala);
			}catch(Exception e){
				e.printStackTrace();
				retorno = "erro";
			}finally{
				retorno = "cadastro";
			}
		}
		
		listar();
		return "atualizarAgenda";
	}
	
	@Action(value="listaAdvProcesso", results={
			@Result(location="/audiencias.jsp", name="audiencia")})
	public String listarAdvogado(){
		listaProcesso = AdvocaciaNegocio.ListarProcessos();
		
		/*if (listaAdvogado.size() > 0){
			listaAdvogado.clear();
		}*/
		
		if (idPro > 0){
			listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		} else {
			listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		}
		
		retorno = "carga";
		
		return "audiencia";
	}
	
	@Action(value="enviaremail", results={
			@Result(location="/audiencias.jsp", name="audiencia")})
	public String enviarEmail(){
		listaProcesso = AdvocaciaNegocio.ListarProcessos();
		
		if (idPro > 0){
			listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		} else {
			listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		}
		//email.enviar();
		return "audiencia";
	}
}
