package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class HistProcBloqDesbloq implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Processo processo;
	private Calendar dt_bloqueio_desbloq;
	private BloqueioDesbloq bloqueioDesbloq;
	
	public HistProcBloqDesbloq(){}
	
	public HistProcBloqDesbloq(Processo processo, Calendar dt_bloqueio_desbloq,
			BloqueioDesbloq bloqueioDesbloq) {
		super();
		this.processo = processo;
		this.dt_bloqueio_desbloq = dt_bloqueio_desbloq;
		this.bloqueioDesbloq = bloqueioDesbloq;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Calendar getDt_bloqueio_desbloq() {
		return dt_bloqueio_desbloq;
	}

	public void setDt_bloqueio_desbloq(Calendar dt_bloqueio_desbloq) {
		this.dt_bloqueio_desbloq = dt_bloqueio_desbloq;
	}

	public BloqueioDesbloq getBloqueioDesbloq() {
		return bloqueioDesbloq;
	}

	public void setBloqueioDesbloq(BloqueioDesbloq bloqueioDesbloq) {
		this.bloqueioDesbloq = bloqueioDesbloq;
	}
	
	
	
	
}
