package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class Despesa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_lancamento;
	private TipoDespesa tipoDespesa;
	private Processo processo;
	private Calendar dt_despesa;
	private double vl_despesa;
	private String ds_observacao;
	
	public Despesa(){}
	
	public Despesa(TipoDespesa tipoDespesa, Processo processo,
			Calendar dt_despesa, double vl_despesa, String ds_observacao) {
		super();
		this.tipoDespesa = tipoDespesa;
		this.processo = processo;
		this.dt_despesa = dt_despesa;
		this.vl_despesa = vl_despesa;
		this.ds_observacao = ds_observacao;
	}


	public Despesa(int cd_lancamento, TipoDespesa tipoDespesa,
			Processo processo, Calendar dt_despesa, double vl_despesa,
			String ds_observacao) {
		super();
		this.cd_lancamento = cd_lancamento;
		this.tipoDespesa = tipoDespesa;
		this.processo = processo;
		this.dt_despesa = dt_despesa;
		this.vl_despesa = vl_despesa;
		this.ds_observacao = ds_observacao;
	}

	public int getCd_lancamento() {
		return cd_lancamento;
	}

	public void setCd_lancamento(int cd_lancamento) {
		this.cd_lancamento = cd_lancamento;
	}

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Calendar getDt_despesa() {
		return dt_despesa;
	}

	public void setDt_despesa(Calendar dt_despesa) {
		this.dt_despesa = dt_despesa;
	}

	public double getVl_despesa() {
		return vl_despesa;
	}

	public void setVl_despesa(double vl_despesa) {
		this.vl_despesa = vl_despesa;
	}

	public String getDs_observacao() {
		return ds_observacao;
	}

	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}
	
	
	
	
}
