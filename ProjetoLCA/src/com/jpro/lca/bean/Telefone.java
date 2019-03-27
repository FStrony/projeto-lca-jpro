package com.jpro.lca.bean;

import java.io.Serializable;

public class Telefone implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_telefone;
	private Pessoa pessoa;
	private TipoTelefone tipotelefone;
	private int nr_ddd;
	private int nr_telefone;
	
	
	public Telefone(){}


	public Telefone(int cd_telefone, Pessoa pessoa, TipoTelefone tipotelefone,
			int nr_ddd, int nr_telefone) {
		super();
		this.cd_telefone = cd_telefone;
		this.pessoa = pessoa;
		this.tipotelefone = tipotelefone;
		this.nr_ddd = nr_ddd;
		this.nr_telefone = nr_telefone;
	}


	public Telefone(Pessoa pessoa, TipoTelefone tipotelefone, int nr_ddd,
			int nr_telefone) {
		super();
		this.pessoa = pessoa;
		this.tipotelefone = tipotelefone;
		this.nr_ddd = nr_ddd;
		this.nr_telefone = nr_telefone;
	}


	public int getCd_telefone() {
		return cd_telefone;
	}


	public void setCd_telefone(int cd_telefone) {
		this.cd_telefone = cd_telefone;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public TipoTelefone getTipotelefone() {
		return tipotelefone;
	}


	public void setTipotelefone(TipoTelefone tipotelefone) {
		this.tipotelefone = tipotelefone;
	}


	public int getNr_ddd() {
		return nr_ddd;
	}


	public void setNr_ddd(int nr_ddd) {
		this.nr_ddd = nr_ddd;
	}


	public int getNr_telefone() {
		return nr_telefone;
	}


	public void setNr_telefone(int nr_telefone) {
		this.nr_telefone = nr_telefone;
	}
	
	
	
}
