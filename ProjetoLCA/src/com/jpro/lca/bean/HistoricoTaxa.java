package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class HistoricoTaxa implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int cd_taxa;
	private TipoCobranca tipoCobranca;
	private Calendar dt_vigencia;
	private double vl_taxa;
	
	public HistoricoTaxa(){}

	public HistoricoTaxa(int cd_taxa, TipoCobranca tipoCobranca,
			Calendar dt_vigencia, double vl_taxa) {
		super();
		this.cd_taxa = cd_taxa;
		this.tipoCobranca = tipoCobranca;
		this.dt_vigencia = dt_vigencia;
		this.vl_taxa = vl_taxa;
	}

	public HistoricoTaxa(TipoCobranca tipoCobranca, Calendar dt_vigencia,
			double vl_taxa) {
		super();
		this.tipoCobranca = tipoCobranca;
		this.dt_vigencia = dt_vigencia;
		this.vl_taxa = vl_taxa;
	}

	public int getCd_taxa() {
		return cd_taxa;
	}

	public void setCd_taxa(int cd_taxa) {
		this.cd_taxa = cd_taxa;
	}

	public TipoCobranca getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(TipoCobranca tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public Calendar getDt_vigencia() {
		return dt_vigencia;
	}

	public void setDt_vigencia(Calendar dt_vigencia) {
		this.dt_vigencia = dt_vigencia;
	}

	public double getVl_taxa() {
		return vl_taxa;
	}

	public void setVl_taxa(double vl_taxa) {
		this.vl_taxa = vl_taxa;
	}
	
	
	
	
	
	
}
