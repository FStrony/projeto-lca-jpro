package com.jpro.lca.bean;

import java.io.Serializable;

public class AdvogadoTipoCausa implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cd_causa;
	private Advogado advogado;
	
	public AdvogadoTipoCausa(){}
	
	public AdvogadoTipoCausa(int cd_causa, Advogado advogado) {
		super();
		this.cd_causa = cd_causa;
		this.advogado = advogado;
	}

	public AdvogadoTipoCausa(Advogado advogado) {
		super();
		this.advogado = advogado;
	}

	public int getCd_causa() {
		return cd_causa;
	}

	public void setCd_causa(int cd_causa) {
		this.cd_causa = cd_causa;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}
	
	
	
}
