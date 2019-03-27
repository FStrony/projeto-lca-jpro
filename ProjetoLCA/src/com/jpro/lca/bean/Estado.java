package com.jpro.lca.bean;

import java.io.Serializable;

public class Estado implements Serializable{


	private static final long serialVersionUID = 1L;
	private int cd_estado;
	private String ds_estado;
	private String sg_estado;
	
	public Estado(){}

	public Estado(int cd_estado, String ds_estado, String sg_estado) {
		super();
		this.cd_estado = cd_estado;
		this.ds_estado = ds_estado;
		this.sg_estado = sg_estado;
	}

	public Estado(String ds_estado, String sg_estado) {
		super();
		this.ds_estado = ds_estado;
		this.sg_estado = sg_estado;
	}

	public int getCd_estado() {
		return cd_estado;
	}

	public void setCd_estado(int cd_estado) {
		this.cd_estado = cd_estado;
	}

	public String getDs_estado() {
		return ds_estado;
	}

	public void setDs_estado(String ds_estado) {
		this.ds_estado = ds_estado;
	}

	public String getSg_estado() {
		return sg_estado;
	}

	public void setSg_estado(String sg_estado) {
		this.sg_estado = sg_estado;
	}
	
	
	
	
}
