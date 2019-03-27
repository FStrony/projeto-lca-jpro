package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;


public class AdvogadoHonorario implements Serializable{

	private static final long serialVersionUID = 1L;
	private int cd_honorario;
	private Processo processo;
	private Advogado advogado;
	private Tarefa tarefa;
	private Calendar dt_honorario;
	private double qt_horas;
	private String ds_observacao;
	
	
	public AdvogadoHonorario(){}


	public AdvogadoHonorario(int cd_honorario, Processo processo,
			Advogado advogado, Tarefa tarefa, Calendar dt_honorario,
			double qt_horas, String ds_observacao) {
		super();
		this.cd_honorario = cd_honorario;
		this.processo = processo;
		this.advogado = advogado;
		this.tarefa = tarefa;
		this.dt_honorario = dt_honorario;
		this.qt_horas = qt_horas;
		this.ds_observacao = ds_observacao;
	}


	public AdvogadoHonorario(Processo processo, Advogado advogado,
			Tarefa tarefa, Calendar dt_honorario, double qt_horas,
			String ds_observacao) {
		super();
		this.processo = processo;
		this.advogado = advogado;
		this.tarefa = tarefa;
		this.dt_honorario = dt_honorario;
		this.qt_horas = qt_horas;
		this.ds_observacao = ds_observacao;
	}


	public int getCd_honorario() {
		return cd_honorario;
	}


	public void setCd_honorario(int cd_honorario) {
		this.cd_honorario = cd_honorario;
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


	public Tarefa getTarefa() {
		return tarefa;
	}


	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}


	public Calendar getDt_honorario() {
		return dt_honorario;
	}


	public void setDt_honorario(Calendar dt_honorario) {
		this.dt_honorario = dt_honorario;
	}


	public double getQt_horas() {
		return qt_horas;
	}


	public void setQt_horas(double qt_horas) {
		this.qt_horas = qt_horas;
	}


	public String getDs_observacao() {
		return ds_observacao;
	}


	public void setDs_observacao(String ds_observacao) {
		this.ds_observacao = ds_observacao;
	}

	
	
}

