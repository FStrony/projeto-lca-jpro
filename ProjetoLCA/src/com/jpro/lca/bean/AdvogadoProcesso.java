package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class AdvogadoProcesso implements Serializable{

	private static final long serialVersionUID = 1L;
	private Processo processo;
	private Advogado advogado;
	private Calendar dt_inicio_participacao;
	
	public AdvogadoProcesso(){}

	public AdvogadoProcesso(Processo processo, Advogado advogado,
			Calendar dt_inicio_participacao) {
		super();
		this.processo = processo;
		this.advogado = advogado;
		this.dt_inicio_participacao = dt_inicio_participacao;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Calendar getDt_inicio_participacao() {
		return dt_inicio_participacao;
	}

	public void setDt_inicio_participacao(Calendar dt_inicio_participacao) {
		this.dt_inicio_participacao = dt_inicio_participacao;
	}
	
	
	
	
}
