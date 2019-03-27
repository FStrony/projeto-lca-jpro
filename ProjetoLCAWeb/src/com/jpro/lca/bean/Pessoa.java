package com.jpro.lca.bean;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cd_pessoa;
	private String nm_pessoa;
	
	public Pessoa(){
		
	}
	
	public Pessoa(int cd_pessoa, String nm_pessoa) {
		this.cd_pessoa = cd_pessoa;
		this.nm_pessoa = nm_pessoa;
	}
	
	public Pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}

	public int getCd_pessoa() {
		return cd_pessoa;
	}

	public void setCd_pessoa(int cd_pessoa) {
		this.cd_pessoa = cd_pessoa;
	}

	public String getNm_pessoa() {
		return nm_pessoa;
	}

	public void setNm_pessoa(String nm_pessoa) {
		this.nm_pessoa = nm_pessoa;
	}
	
}
