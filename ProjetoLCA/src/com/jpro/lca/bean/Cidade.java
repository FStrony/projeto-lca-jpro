package com.jpro.lca.bean;

import java.io.Serializable;

public class Cidade implements Serializable{


	private static final long serialVersionUID = 1L;
	private int cd_cidade;
	private Estado estado;
	private String ds_cidade;
	
	public Cidade(){}
	public Cidade(int cd_cidade, Estado estado, String ds_cidade) {
		super();
		this.cd_cidade = cd_cidade;
		this.estado = estado;
		this.ds_cidade = ds_cidade;
	}


	public Cidade(Estado estado, String ds_cidade) {
		super();
		this.estado = estado;
		this.ds_cidade = ds_cidade;
	}


	public int getCd_cidade() {
		return cd_cidade;
	}


	public void setCd_cidade(int cd_cidade) {
		this.cd_cidade = cd_cidade;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public String getDs_cidade() {
		return ds_cidade;
	}


	public void setDs_cidade(String ds_cidade) {
		this.ds_cidade = ds_cidade;
	}
	
	
	
}
