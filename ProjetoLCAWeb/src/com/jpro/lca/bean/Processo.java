package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Processo implements Serializable{

	private static final long serialVersionUID = 1L;
	private int nr_processo;
	private Forum forum;
	private Cliente cliente;
	private TipoCausa tipoCausa;
	private TipoCobranca tipoCobranca;
	private String ds_processo;
	private Calendar dt_abertura;
	private Calendar dt_fechamento;
	private int dd_dia_vencimento;
	//private proSatus cd_resultado;
	private int cd_resultado;
	private String ds_observacao;
	
	private List<Advogado> advogados;

	public Processo(){}


	public Processo(int nr_processo, Forum forum, Cliente cliente,
			TipoCausa tipoCausa, TipoCobranca tipoCobranca, String ds_processo,
			Calendar dt_abertura, Calendar dt_fechamento,
			int dd_dia_vencimento, int cd_resultado, String ds_observacao) {
		super();
		this.nr_processo = nr_processo;
		this.forum = forum;
		this.cliente = cliente;
		this.tipoCausa = tipoCausa;
		this.tipoCobranca = tipoCobranca;
		this.ds_processo = ds_processo;
		this.dt_abertura = dt_abertura;
		this.dt_fechamento = dt_fechamento;
		this.dd_dia_vencimento = dd_dia_vencimento;
		this.cd_resultado = cd_resultado;
		this.ds_observacao = ds_observacao;
	}


	public Processo(Forum forum, Cliente cliente, TipoCausa tipoCausa,
			TipoCobranca tipoCobranca, String ds_processo,
			Calendar dt_abertura, Calendar dt_fechamento,
			int dd_dia_vencimento, int cd_resultado, String ds_observacao) {
		super();
		this.forum = forum;
		this.cliente = cliente;
		this.tipoCausa = tipoCausa;
		this.tipoCobranca = tipoCobranca;
		this.ds_processo = ds_processo;
		this.dt_abertura = dt_abertura;
		this.dt_fechamento = dt_fechamento;
		this.dd_dia_vencimento = dd_dia_vencimento;
		this.cd_resultado = cd_resultado;
		this.ds_observacao = ds_observacao;
	}


	public int getNr_processo() {
		return nr_processo;
	}


	public void setNr_processo(int nr_processo) {
		this.nr_processo = nr_processo;
	}


	public Forum getForum() {
		return forum;
	}


	public void setForum(Forum forum) {
		this.forum = forum;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public TipoCausa getTipoCausa() {
		return tipoCausa;
	}


	public void setTipoCausa(TipoCausa tipoCausa) {
		this.tipoCausa = tipoCausa;
	}


	public TipoCobranca getTipoCobranca() {
		return tipoCobranca;
	}


	public void setTipoCobranca(TipoCobranca tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}


	public String getDs_processo() {
		return ds_processo;
	}


	public void setDs_processo(String ds_processo) {
		this.ds_processo = ds_processo;
	}


	public Calendar getDt_abertura() {
		return dt_abertura;
	}


	public void setDt_abertura(Calendar dt_abertura) {
		this.dt_abertura = dt_abertura;
	}


	public Calendar getDt_fechamento() {
		return dt_fechamento;
	}


	public void setDt_fechamento(Calendar dt_fechamento) {
		this.dt_fechamento = dt_fechamento;
	}


	public int getDd_dia_vencimento() {
		return dd_dia_vencimento;
	}


	public void setDd_dia_vencimento(int dd_dia_vencimento) {
		this.dd_dia_vencimento = dd_dia_vencimento;
	}


	public int getCd_resultado() {
		return cd_resultado;
	}


	public void setCd_resultado(int cd_resultado) {
		this.cd_resultado = cd_resultado;
	}


	public String getDs_observacao() {
		return ds_observacao;
	}


	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}


	public List<Advogado> getAdvogados() {
		return advogados;
	}


	public void setAdvogados(List<Advogado> advogados) {
		this.advogados = advogados;
	}

	

	
	
	
}
