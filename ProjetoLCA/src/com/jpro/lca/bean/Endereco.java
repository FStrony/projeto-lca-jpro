package com.jpro.lca.bean;

import java.io.Serializable;

public class Endereco implements Serializable{


	private static final long serialVersionUID = 1L;
	private int cd_endereco;
	private TipoLogradouro tipoLogradouro;
	private Bairro bairro;
	private String nm_logradouro;
	private int nr_cep;
	
	public Endereco(){}

	public Endereco(int cd_endereco, TipoLogradouro tipoLogradouro,
			Bairro bairro, String nm_logradouro, int nr_cep) {
		super();
		this.cd_endereco = cd_endereco;
		this.tipoLogradouro = tipoLogradouro;
		this.bairro = bairro;
		this.nm_logradouro = nm_logradouro;
		this.nr_cep = nr_cep;
	}

	public Endereco(TipoLogradouro tipoLogradouro, Bairro bairro,
			String nm_logradouro, int nr_cep) {
		super();
		this.tipoLogradouro = tipoLogradouro;
		this.bairro = bairro;
		this.nm_logradouro = nm_logradouro;
		this.nr_cep = nr_cep;
	}

	public int getCd_endereco() {
		return cd_endereco;
	}

	public void setCd_endereco(int cd_endereco) {
		this.cd_endereco = cd_endereco;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public String getNm_logradouro() {
		return nm_logradouro;
	}

	public void setNm_logradouro(String nm_logradouro) {
		this.nm_logradouro = nm_logradouro;
	}

	public int getNr_cep() {
		return nr_cep;
	}

	public void setNr_cep(int nr_cep) {
		this.nr_cep = nr_cep;
	}
	
	
}
