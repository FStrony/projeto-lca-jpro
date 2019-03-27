package com.jpro.lca.bean;

import java.io.Serializable;

public class TipoCobranca implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_cobranca;
	private String ds_cobranca;
	private int tx_juros;
	private double vl_mora_diaria;
	
	public TipoCobranca(){}

	public TipoCobranca(int cd_cobranca, String ds_cobranca, int tx_juros,
			double vl_mora_diaria) {
		super();
		this.cd_cobranca = cd_cobranca;
		this.ds_cobranca = ds_cobranca;
		this.tx_juros = tx_juros;
		this.vl_mora_diaria = vl_mora_diaria;
	}

	public TipoCobranca(String ds_cobranca, int tx_juros, double vl_mora_diaria) {
		super();
		this.ds_cobranca = ds_cobranca;
		this.tx_juros = tx_juros;
		this.vl_mora_diaria = vl_mora_diaria;
	}

	public int getCd_cobranca() {
		return cd_cobranca;
	}

	public void setCd_cobranca(int cd_cobranca) {
		this.cd_cobranca = cd_cobranca;
	}

	public String getDs_cobranca() {
		return ds_cobranca;
	}

	public void setDs_cobranca(String ds_cobranca) {
		this.ds_cobranca = ds_cobranca;
	}

	public int getTx_juros() {
		return tx_juros;
	}

	public void setTx_juros(int tx_juros) {
		this.tx_juros = tx_juros;
	}

	public double getVl_mora_diaria() {
		return vl_mora_diaria;
	}

	public void setVl_mora_diaria(double vl_mora_diaria) {
		this.vl_mora_diaria = vl_mora_diaria;
	}
	
	
}
