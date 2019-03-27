package com.jpro.lca.bean;

import java.io.Serializable;

public class Forum extends Pessoa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String ds_forum;
	
	public Forum(){}

	public Forum(String ds_forum) {
		super();
		this.ds_forum = ds_forum;
	}

	public String getDs_forum() {
		return ds_forum;
	}

	public void setDs_forum(String ds_forum) {
		this.ds_forum = ds_forum;
	}
	
	
}
