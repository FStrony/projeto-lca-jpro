package com.jpro.lca.bean;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	private String nm_razao_social;
	private int nr_cnpj;
	private int nr_insc_estadual;
	private String ds_email;
	private String ds_password;
	
	public Cliente(){}

	public Cliente(String nm_razao_social, int nr_cnpj, int nr_insc_estadual,
			String ds_email, String ds_password) {
		super();
		this.nm_razao_social = nm_razao_social;
		this.nr_cnpj = nr_cnpj;
		this.nr_insc_estadual = nr_insc_estadual;
		this.ds_email = ds_email;
		this.ds_password = ds_password;
	}

	public String getNm_razao_social() {
		return nm_razao_social;
	}

	public void setNm_razao_social(String nm_razao_social) {
		this.nm_razao_social = nm_razao_social;
	}

	public int getNr_cnpj() {
		return nr_cnpj;
	}

	public void setNr_cnpj(int nr_cnpj) {
		this.nr_cnpj = nr_cnpj;
	}

	public int getNr_insc_estadual() {
		return nr_insc_estadual;
	}

	public void setNr_insc_estadual(int nr_insc_estadual) {
		this.nr_insc_estadual = nr_insc_estadual;
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
