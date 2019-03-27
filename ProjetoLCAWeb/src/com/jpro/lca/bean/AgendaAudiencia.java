package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class AgendaAudiencia implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_agenda;
	private Processo processo;
	private Advogado advogado;
	private Calendar dt_hora_agenda;
	private String sl_forum;
	
	public AgendaAudiencia(){}

	public AgendaAudiencia(int cd_agenda, Processo processo, Advogado advogado,
			Calendar dt_hora_agenda, String sl_forum) {
		super();
		this.cd_agenda = cd_agenda;
		this.processo = processo;
		this.advogado = advogado;
		this.dt_hora_agenda = dt_hora_agenda;
		this.sl_forum = sl_forum;
	}

	public AgendaAudiencia(Processo processo, Advogado advogado,
			Calendar dt_hora_agenda, String sl_forum) {
		super();
		this.processo = processo;
		this.advogado = advogado;
		this.dt_hora_agenda = dt_hora_agenda;
		this.sl_forum = sl_forum;
	}

	public int getCd_agenda() {
		return cd_agenda;
	}

	public void setCd_agenda(int cd_agenda) {
		this.cd_agenda = cd_agenda;
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

	public Calendar getDt_hora_agenda() {
		return dt_hora_agenda;
	}

	public void setDt_hora_agenda(Calendar dt_hora_agenda) {
		this.dt_hora_agenda = dt_hora_agenda;
	}

	public String getSl_forum() {
		return sl_forum;
	}

	public void setSl_forum(String sl_forum) {
		this.sl_forum = sl_forum;
	}
	
	
	
	
}
