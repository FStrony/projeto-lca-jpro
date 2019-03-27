package com.jpro.lca.bean;

import java.io.Serializable;

public class Advogado extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int nr_oab;
	private int nr_cpf;
	private String nr_rg;
	private String ds_email;
	private String ds_password;
	
	public Advogado(){}

	public Advogado(int nr_oab, int nr_cpf, String nr_rg, String ds_email,
			String ds_password) {
		super();
		this.nr_oab = nr_oab;
		this.nr_cpf = nr_cpf;
		this.nr_rg = nr_rg;
		this.ds_email = ds_email;
		this.ds_password = ds_password;
	}

	public int getNr_oab() {
		return nr_oab;
	}

	public void setNr_oab(int nr_oab) {
		this.nr_oab = nr_oab;
	}

	public int getNr_cpf() {
		return nr_cpf;
	}

	public void setNr_cpf(int nr_cpf) {
		this.nr_cpf = nr_cpf;
	}

	public String getNr_rg() {
		return nr_rg;
	}

	public void setNr_rg(String nr_rg) {
		this.nr_rg = nr_rg;
	}

	public String getDs_email() {
		return ds_email;
	}

	public void setDs_email(String ds_email) {
		this.ds_email = ds_email;
	}

	public String getDs_password() {
		return ds_password;
	}

	public void setDs_password(String ds_password) {
		this.ds_password = ds_password;
	}

	
	
	
}
