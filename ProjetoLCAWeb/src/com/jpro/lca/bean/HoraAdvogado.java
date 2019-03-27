package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class HoraAdvogado implements Serializable{


	private static final long serialVersionUID = 1L;
	private int cd_historico;
	private Advogado advogado;
	private Calendar dt_vigencia;
	private double vl_hora;
	
	public HoraAdvogado(){}

	public HoraAdvogado(int cd_historico, Advogado advogado,
			Calendar dt_vigencia, double vl_hora) {
		super();
		this.cd_historico = cd_historico;
		this.advogado = advogado;
		this.dt_vigencia = dt_vigencia;
		this.vl_hora = vl_hora;
	}

	public HoraAdvogado(Advogado advogado, Calendar dt_vigencia, double vl_hora) {
		super();
		this.advogado = advogado;
		this.dt_vigencia = dt_vigencia;
		this.vl_hora = vl_hora;
	}

	public int getCd_historico() {
		return cd_historico;
	}

	public void setCd_historico(int cd_historico) {
		this.cd_historico = cd_historico;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Calendar getDt_vigencia() {
		return dt_vigencia;
	}

	public void setDt_vigencia(Calendar dt_vigencia) {
		this.dt_vigencia = dt_vigencia;
	}

	public double getVl_hora() {
		return vl_hora;
	}

	public void setVl_hora(double vl_hora) {
		this.vl_hora = vl_hora;
	}
	
	
	
	
}
