package com.jpro.lca.bean;

import java.io.Serializable;

public class Bairro implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cd_bairro;
	private Cidade cidade;
	private String ds_bairro;
	
	public Bairro(){}
	
	public Bairro(int cd_bairro, Cidade cidade, String ds_bairro) {
		super();
		this.cd_bairro = cd_bairro;
		this.cidade = cidade;
		this.ds_bairro = ds_bairro;
	}


	public Bairro(Cidade cidade, String ds_bairro) {
		super();
		this.cidade = cidade;
		this.ds_bairro = ds_bairro;
	}

	public int getCd_bairro() {
		return cd_bairro;
	}

	public void setCd_bairro(int cd_bairro) {
		this.cd_bairro = cd_bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getDs_bairro() {
		return ds_bairro;
	}

	public void setDs_bairro(String ds_bairro) {
		this.ds_bairro = ds_bairro;
	}
	
	 
	
}
