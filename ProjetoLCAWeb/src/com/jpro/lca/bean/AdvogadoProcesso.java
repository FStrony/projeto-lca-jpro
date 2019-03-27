package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class AdvogadoProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private int advogado;
	private int processo;
	private Calendar dt_inicio_participacao;
	
	public AdvogadoProcesso(){}

	public AdvogadoProcesso(int advogado, int processo,
			Calendar dt_inicio_participacao) {
		super();
		this.advogado = advogado;
		this.processo = processo;
		this.dt_inicio_participacao = dt_inicio_participacao;
	}

	public int getAdvogado() {
		return advogado;
	}

	public void setAdvogado(int advogado) {
		this.advogado = advogado;
	}

	public int getProcesso() {
		return processo;
	}

	public void setProcesso(int processo) {
		this.processo = processo;
	}

	public Calendar getDt_inicio_participacao() {
		return dt_inicio_participacao;
	}

	public void setDt_inicio_participacao(Calendar dt_inicio_participacao) {
		this.dt_inicio_participacao = dt_inicio_participacao;
	}

	
	
	
	
}
