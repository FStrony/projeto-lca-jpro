package com.jpro.lca.bean;

import java.io.Serializable;

public class TipoLogradouro implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_tipo_logradouro;
	private String ds_tipo_logradouro;
	
	public TipoLogradouro(){}
	
	public TipoLogradouro(int cd_tipo_logradouro, String ds_tipo_logradouro) {
		super();
		this.cd_tipo_logradouro = cd_tipo_logradouro;
		this.ds_tipo_logradouro = ds_tipo_logradouro;
	}

	public TipoLogradouro(String ds_tipo_logradouro) {
		super();
		this.ds_tipo_logradouro = ds_tipo_logradouro;
	}

	public int getCd_tipo_logradouro() {
		return cd_tipo_logradouro;
	}

	public void setCd_tipo_logradouro(int cd_tipo_logradouro) {
		this.cd_tipo_logradouro = cd_tipo_logradouro;
	}

	public String getDs_tipo_logradouro() {
		return ds_tipo_logradouro;
	}

	public void setDs_tipo_logradouro(String ds_tipo_logradouro) {
		this.ds_tipo_logradouro = ds_tipo_logradouro;
	}
	
	
	
	
	
}
