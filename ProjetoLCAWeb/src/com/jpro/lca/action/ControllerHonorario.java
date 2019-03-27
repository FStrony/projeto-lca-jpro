package com.jpro.lca.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bo.AdvocaciaNegocio;
import com.jpro.lca.util.ConversaoUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ControllerHonorario extends ActionSupport{


	private static final long serialVersionUID = 1L;
	private List<Pessoa> listaAdvogado;
	private List<Tarefa> listaTarefa;
	private List<Processo> listaProcesso;
	private AdvogadoHonorario lancaHonorario;
	private final String espaco = " - ";
	private List<AdvogadoHonorario> listaHonorario;
	private AdvogadoHonorario AdvHonorario;
	private String data;
	private int idPro;
	private int idHon;
	private Processo proAux;
	private Advogado advAux;
	private Tarefa tarAux;
	private double horas;
	private String desc;
	private String retorno = null;
	
	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public Tarefa getTarAux() {
		return tarAux;
	}

	public void setTarAux(Tarefa tarAux) {
		this.tarAux = tarAux;
	}
	
	public int getIdHon() {
		return idHon;
	}

	public void setIdHon(int idHon) {
		this.idHon = idHon;
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

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Action(value="honorario", results={
			@Result(location="/honorarios.jsp", name="honorario")})
	public String listar(){
		lancaHonorario = new AdvogadoHonorario();
		
		if (idPro > 0){
			listaAdvogado = AdvocaciaNegocio.ListarAdvogadosProcesso(idPro);
		} else {
			listaAdvogado = AdvocaciaNegocio.ListarAdvogados();
		}
		
		listaTarefa = AdvocaciaNegocio.ListarTarefas();
		listaProcesso = AdvocaciaNegocio.ListarProcessos();
		return "honorario";
	}

	@Action(value="lancar", results={
			@Result(location="/honorarios.jsp", name="honorario")})
	public String LancaHonorario(){
			
			AdvocaciaNegocio.lancarHonorarios(lancaHonorario);
			listar();
			return "honorario";
	}
	
	@Action(value="lancaAtt",results={
			@Result(location="/honorarioAtualiza.jsp", name="atualiza")})
	public String AtualizaHonorario(){
		AdvHonorario = new AdvogadoHonorario();
		AdvHonorario = AdvocaciaNegocio.consultarHonoraroi(35);
		data = ConversaoUtil.ExibirData(AdvHonorario.getDt_honorario(), "dd/MM/yyyy");
		//AdvocaciaNegocio.alterarHonorario(AdvHonorario);
		listarUp();
		return "atualiza";
	}
	
	@Action(value="atualiza", results={
			@Result(location="/honorarioAtualiza.jsp", name="atualiza")})
		public String listarUp(){
			AdvHonorario = AdvocaciaNegocio.consultarHonoraroi(35);
			data = ConversaoUtil.ExibirData(AdvHonorario.getDt_honorario(), "dd/MM/yyyy");
			listaAdvogado = AdvocaciaNegocio.ListarAdvogados();   	
			listaTarefa = AdvocaciaNegocio.ListarTarefas();       
			listaProcesso = AdvocaciaNegocio.ListarProcessos();   
			return "atualiza";
	}

	
	@Action(value="consultar", results={
			@Result(location="/honorarioConsulta.jsp", name="consultar")})
	public String consultarHonorario(){
		AdvHonorario = new AdvogadoHonorario();
		AdvHonorario = AdvocaciaNegocio.consultarHonoraroi(35);
		data = ConversaoUtil.ExibirData(AdvHonorario.getDt_honorario(), "dd/MM/yyyy");
		return "consultar";
	}
	
	@Action(value="listarHonorario", results={
			@Result(location="/honorarios.jsp", name="listarHonorario")})
	public String listarHonorario(){
		listaHonorario = new ArrayList<AdvogadoHonorario>();
		listaHonorario = AdvocaciaNegocio.ListarHonorarios();
		return "listarHonorario";
	}
	
	@Action(value="atualizaHonorario", results={
			@Result(location="/honorarioAtualiza.jsp", name="atualiza")})
	public String listarAtualiza(){

		AdvHonorario = AdvocaciaNegocio.consultarHonoraroi(idHon);
		
		proAux = AdvocaciaNegocio.consultarProcesso(AdvHonorario.getProcesso().getNr_processo());
		advAux = AdvocaciaNegocio.ConsultarAdvogado(AdvHonorario.getAdvogado().getCd_pessoa());
		tarAux = AdvocaciaNegocio.ConsultarTarefa(AdvHonorario.getTarefa().getCd_tarefa());
		
		horas = AdvHonorario.getQt_horas();
		desc = AdvHonorario.getDs_observacao();
		//retorno = "carga";
		
		return "atualiza";
	}
	
	@Action(value="atualizarHonorario", results={
			@Result(location="/honorarios.jsp", name="atualizarHonorario")})
	public String atualizarAgenda(){
		
	if(idHon <= 0){
			retorno = "erro";
		} else {
		
			try{
				
				AdvocaciaNegocio.alterarHonorario(horas, desc, idHon);
			}catch(Exception e){
				e.printStackTrace();
				retorno = "erro";
			}finally{
				retorno = "cadastro";
			}
		}
		
		listar();
		return "atualizarHonorario";
	}

	public List<AdvogadoHonorario> getListaHonorario() {
		return listaHonorario;
	}

	public void setListaHonorario(List<AdvogadoHonorario> listaHonorario) {
		this.listaHonorario = listaHonorario;
	}

	public List<Pessoa> getListaAdvogado() {
		return listaAdvogado;
	}

	public void setListaAdvogado(List<Pessoa> listaAdvogado) {
		this.listaAdvogado = listaAdvogado;
	}

	public List<Tarefa> getListaTarefa() {
		return listaTarefa;
	}

	public void setListaTarefa(List<Tarefa> listaTarefa) {
		this.listaTarefa = listaTarefa;
	}

	public List<Processo> getListaProcesso() {
		return listaProcesso;
	}

	public void setListaProcesso(List<Processo> listaProcesso) {
		this.listaProcesso = listaProcesso;
	}

	public AdvogadoHonorario getLancaHonorario() {
		return lancaHonorario;
	}

	public void setLancaHonorario(AdvogadoHonorario lancaHonorario) {
		this.lancaHonorario = lancaHonorario;
	}


	public String getEspaco() {
		return espaco;
	}
	public AdvogadoHonorario getAdvHonorario() {
		return AdvHonorario;
	}
	public void setAdvHonorario(AdvogadoHonorario advHonorario) {
		AdvHonorario = advHonorario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
}
