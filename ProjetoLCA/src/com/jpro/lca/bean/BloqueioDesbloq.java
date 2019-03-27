package com.jpro.lca.bean;

import java.io.Serializable;

public class BloqueioDesbloq implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_bloqueio_desbloq;
	private String ds_bloqueio_desbloq;
	
	public BloqueioDesbloq(){}
	
	public BloqueioDesbloq(int cd_bloqueio_desbloq, String ds_bloqueio_desbloq) {
		super();
		this.cd_bloqueio_desbloq = cd_bloqueio_desbloq;
		this.ds_bloqueio_desbloq = ds_bloqueio_desbloq;
	}

	public BloqueioDesbloq(String ds_bloqueio_desbloq) {
		super();
		this.ds_bloqueio_desbloq = ds_bloqueio_desbloq;
	}

	public int getCd_bloqueio_desbloq() {
		return cd_bloqueio_desbloq;
	}

	public void setCd_bloqueio_desbloq(int cd_bloqueio_desbloq) {
		this.cd_bloqueio_desbloq = cd_bloqueio_desbloq;
	}

	public String getDs_bloqueio_desbloq() {
		return ds_bloqueio_desbloq;
	}

	public void setDs_bloqueio_desbloq(String ds_bloqueio_desbloq) {
		this.ds_bloqueio_desbloq = ds_bloqueio_desbloq;
	}
	
	
	
	
	
}
