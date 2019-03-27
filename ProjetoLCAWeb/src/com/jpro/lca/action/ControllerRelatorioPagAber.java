package com.jpro.lca.action;



import java.util.Calendar;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Months;


import com.jpro.lca.bean.Processo;
import com.jpro.lca.bean.Telefone;
import com.jpro.lca.bean.Titulo;
import com.jpro.lca.bo.AdvocaciaNegocio;
import com.jpro.lca.util.ConversaoUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ControllerRelatorioPagAber extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Processo processo;
	private List<Processo> processos;
	private Titulo titulo;
    private List<Telefone> listaTelefone;
	private String tele;
    private String data;
	private String valor;
	private long dias;
	private long meses;
	private Calendar dtInico;
	private String valorMultar;
	private String juros;
	
	@Action(value="gerarRelatorio", results={
			@Result(location="/relatorioPagAbt.jsp", name="gerarRelatorio" )})
	public String  gerarRelatorio(){
		processo = new Processo();
		processo = AdvocaciaNegocio.consultarProcesso(1);
		listaTelefone = AdvocaciaNegocio.ListarTelefone(processo.getCliente().getCd_pessoa());
		int cont = 0;
		for(Telefone telefone : listaTelefone){
			cont = cont +1;
			if(tele != null){
				tele = tele + telefone.getTipotelefone().getDs_tipo_telefone() + ": ("
						+ telefone.getNr_ddd() + ")" + telefone.getNr_telefone();
				if(cont < listaTelefone.size()){
					tele = tele + ", ";
				}
			}else{
				tele =  telefone.getTipotelefone().getDs_tipo_telefone() + ": ("
						+ telefone.getNr_ddd() + ")" + telefone.getNr_telefone();
			
				if(cont < listaTelefone.size()){
					tele = tele + ", ";
				}
			}
		}
		titulo = AdvocaciaNegocio.consultarTitulo(4);
		data = ConversaoUtil.ExibirData(titulo.getDt_vencimento(), "dd/MM/yyyy");
		valor = "R$ "+ titulo.getVl_documento();
		
		
		
		dtInico = Calendar.getInstance();
		dtInico = titulo.getDt_vencimento();
				

		int m = dtInico.get(Calendar.MONTH);
		int d = dtInico.get(Calendar.DAY_OF_MONTH)-1;
		int y = dtInico.get(Calendar.YEAR);
		
		LocalDate dataI = new LocalDate(y,m,d);
		LocalDate dataAt = new LocalDate();
		
		Days days = Days.daysBetween(dataI, dataAt);
		dias = days.getDays();
		
		Months months = Months.monthsBetween(dataI, dataAt);
		meses = months.getMonths();
		
		
		if(processo != null){
			if(processo.getTipoCobranca().getCd_cobranca() == 1){
				
				//MENSAL
				double v;
				v = meses * processo.getTipoCobranca().getTx_juros();
				juros = v + "%";
				double vm,vmulta;
				vm = (titulo.getVl_documento() / 100)*v;
				vmulta = vm + dias;
				valorMultar = "R$ " + vmulta;
				
			}else if(processo.getTipoCobranca().getCd_cobranca() == 2){
			
				//TRIMESTRAl
				double v;
				long ms = meses/3;
				v = ms*processo.getTipoCobranca().getTx_juros();
				juros = v + "%";
				double vm,vmulta;
				vm = (titulo.getVl_documento() / 100)*v;
				vmulta = vm + dias;
				valorMultar = "R$ " + vmulta;
			
			}else if(processo.getTipoCobranca().getCd_cobranca() == 3){
				
				//Semestral
				double v;
				long ms = meses/6;
				v = ms*processo.getTipoCobranca().getTx_juros();
				juros = v + "%";
				double vm,vmulta;
				vm = (titulo.getVl_documento() / 100)*v;
				vmulta = vm + dias;
				valorMultar = "R$ " + vmulta;
			
			}
		}
		
		return "gerarRelatorio";
	}
	
	@Action(value="relatorio", results={
			@Result(location="/relatorios.jsp", name="relatorio" )})
	public String  listarRelatorios(){
		processos = AdvocaciaNegocio.ListarProcessos();
		return "relatorio";
	}

	
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Telefone> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(List<Telefone> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}

	public String getValorMultar() {
		return valorMultar;
	}

	public void setValorMultar(String valorMultar) {
		this.valorMultar = valorMultar;
	}

	public String getJuros() {
		return juros;
	}

	public void setJuros(String juros) {
		this.juros = juros;
	}


	public Calendar getDtInico() {
		return dtInico;
	}



	public void setDtInico(Calendar dtInico) {
		this.dtInico = dtInico;
	}



	public long getMeses() {
		return meses;
	}



	public void setMeses(long meses) {
		this.meses = meses;
	}

	
	
	
}
