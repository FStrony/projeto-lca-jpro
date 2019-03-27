package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class HistoricoEmailCobranca implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Processo processo;
	private Calendar dt_geracao;
	private String ds_assunto;
	private String ds_corpo_email;
	private Calendar dt_envio;
	
	public HistoricoEmailCobranca(){}

	public HistoricoEmailCobranca(Processo processo, Calendar dt_geracao,
			String ds_assunto, String ds_corpo_email, Calendar dt_envio) {
		super();
		this.processo = processo;
		this.dt_geracao = dt_geracao;
		this.ds_assunto = ds_assunto;
		this.ds_corpo_email = ds_corpo_email;
		this.dt_envio = dt_envio;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Calendar getDt_geracao() {
		return dt_geracao;
	}

	public void setDt_geracao(Calendar dt_geracao) {
		this.dt_geracao = dt_geracao;
	}

	public String getDs_assunto() {
		return ds_assunto;
	}

	public void setDs_assunto(String ds_assunto) {
		this.ds_assunto = ds_assunto;
	}

	public String getDs_corpo_email() {
		return ds_corpo_email;
	}

	public void setDs_corpo_email(String ds_corpo_email) {
		this.ds_corpo_email = ds_corpo_email;
	}

	public Calendar getDt_envio() {
		return dt_envio;
	}

	public void setDt_envio(Calendar dt_envio) {
		this.dt_envio = dt_envio;
	}
	
	
	
	
}
