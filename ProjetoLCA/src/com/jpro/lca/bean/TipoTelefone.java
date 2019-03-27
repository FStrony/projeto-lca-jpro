package com.jpro.lca.bean;

import java.io.Serializable;

public class TipoTelefone implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_tipo_telefone;
	private String ds_tipo_telefone;
	
	public TipoTelefone(){}

	public TipoTelefone(int cd_tipo_telefone, String ds_tipo_telefone) {
		super();
		this.cd_tipo_telefone = cd_tipo_telefone;
		this.ds_tipo_telefone = ds_tipo_telefone;
	}

	public TipoTelefone(String ds_tipo_telefone) {
		super();
		this.ds_tipo_telefone = ds_tipo_telefone;
	}

	public int getCd_tipo_telefone() {
		return cd_tipo_telefone;
	}

	public void setCd_tipo_telefone(int cd_tipo_telefone) {
		this.cd_tipo_telefone = cd_tipo_telefone;
	}

	public String getDs_tipo_telefone() {
		return ds_tipo_telefone;
	}

	public void setDs_tipo_telefone(String ds_tipo_telefone) {
		this.ds_tipo_telefone = ds_tipo_telefone;
	}
	
	
	
	
}
