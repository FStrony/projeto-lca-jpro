package com.jpro.lca.bean;

public class PessoaEndereco {
	
	private Pessoa pessoa;
	private Endereco endereco;
	private int nr_endereco;
	private String ds_complemento;
	
	public PessoaEndereco(){}

	public PessoaEndereco(Pessoa pessoa, Endereco endereco, int nr_endereco,
			String ds_complemento) {
		super();
		this.pessoa = pessoa;
		this.endereco = endereco;
		this.nr_endereco = nr_endereco;
		this.ds_complemento = ds_complemento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getNr_endereco() {
		return nr_endereco;
	}

	public void setNr_endereco(int nr_endereco) {
		this.nr_endereco = nr_endereco;
	}

	public String getDs_complemento() {
		return ds_complemento;
	}

	public void setDs_complemento(String ds_complemento) {
		this.ds_complemento = ds_complemento;
	}
	
	
	
	
}
