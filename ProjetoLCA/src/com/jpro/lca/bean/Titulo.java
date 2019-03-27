package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class Titulo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int nr_titulo;
	private Processo processo;
	private int nr_agencia_cedente;
	private Calendar dt_documento;
	private Calendar dt_vencimento;
	private double vl_documento;
	
	
	public Titulo(){}


	public Titulo(int nr_titulo, Processo processo, int nr_agencia_cedente,
			Calendar dt_documento, Calendar dt_vencimento, double vl_documento) {
		super();
		this.nr_titulo = nr_titulo;
		this.processo = processo;
		this.nr_agencia_cedente = nr_agencia_cedente;
		this.dt_documento = dt_documento;
		this.dt_vencimento = dt_vencimento;
		this.vl_documento = vl_documento;
	}


	public Titulo(Processo processo, int nr_agencia_cedente,
			Calendar dt_documento, Calendar dt_vencimento, double vl_documento) {
		super();
		this.processo = processo;
		this.nr_agencia_cedente = nr_agencia_cedente;
		this.dt_documento = dt_documento;
		this.dt_vencimento = dt_vencimento;
		this.vl_documento = vl_documento;
	}


	public int getNr_titulo() {
		return nr_titulo;
	}


	public void setNr_titulo(int nr_titulo) {
		this.nr_titulo = nr_titulo;
	}


	public Processo getProcesso() {
		return processo;
	}


	public void setProcesso(Processo processo) {
		this.processo = processo;
	}


	public int getNr_agencia_cedente() {
		return nr_agencia_cedente;
	}


	public void setNr_agencia_cedente(int nr_agencia_cedente) {
		this.nr_agencia_cedente = nr_agencia_cedente;
	}


	public Calendar getDt_documento() {
		return dt_documento;
	}


	public void setDt_documento(Calendar dt_documento) {
		this.dt_documento = dt_documento;
	}


	public Calendar getDt_vencimento() {
		return dt_vencimento;
	}


	public void setDt_vencimento(Calendar dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}


	public double getVl_documento() {
		return vl_documento;
	}


	public void setVl_documento(double vl_documento) {
		this.vl_documento = vl_documento;
	}


	

	
	
}
