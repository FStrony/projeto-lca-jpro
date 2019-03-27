package com.jpro.lca.bean;

public enum proSatus {

	ANDAMENTO(0), DEFERIDO(1), INDEFERIDO(2), BLOQUEADO(3);

	public int status;
	
	private proSatus(int status){
		this.setStatus(status);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
