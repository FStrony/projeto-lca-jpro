package com.jpro.lca.bean;

import java.io.Serializable;

public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int cd_tarefa;
	private String ds_tarefa;
	
	
	public Tarefa(){}


	public Tarefa(int cd_tarefa, String ds_tarefa) {
		super();
		this.cd_tarefa = cd_tarefa;
		this.ds_tarefa = ds_tarefa;
	}


	public Tarefa(String ds_tarefa) {
		super();
		this.ds_tarefa = ds_tarefa;
	}


	public int getCd_tarefa() {
		return cd_tarefa;
	}


	public void setCd_tarefa(int cd_tarefa) {
		this.cd_tarefa = cd_tarefa;
	}


	public String getDs_tarefa() {
		return ds_tarefa;
	}


	public void setDs_tarefa(String ds_tarefa) {
		this.ds_tarefa = ds_tarefa;
	}

	
	
	
}
