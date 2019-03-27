package com.jpro.lca.bean;

import java.io.Serializable;

public class TipoDespesa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_despesa;
	private String ds_despesa;
	
	public TipoDespesa(){}

	public TipoDespesa(int cd_despesa, String ds_despesa) {
		super();
		this.cd_despesa = cd_despesa;
		this.ds_despesa = ds_despesa;
	}

	public TipoDespesa(String ds_despesa) {
		super();
		this.ds_despesa = ds_despesa;
	}

	public int getCd_despesa() {
		return cd_despesa;
	}

	public void setCd_despesa(int cd_despesa) {
		this.cd_despesa = cd_despesa;
	}

	public String getDs_despesa() {
		return ds_despesa;
	}

	public void setDs_despesa(String ds_despesa) {
		this.ds_despesa = ds_despesa;
	}
	
	
}
