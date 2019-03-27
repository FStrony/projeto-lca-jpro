package com.jpro.lca.bean;

import java.io.Serializable;
import java.util.Calendar;

public class TituloPago implements Serializable{

	private static final long serialVersionUID = 1L;
	private Titulo titulo;
	private Calendar dt_pagamento;
	private double vl_pago;
	
	
	public TituloPago() {}


	public TituloPago(Titulo titulo, Calendar dt_pagamento, double vl_pago) {
		super();
		this.titulo = titulo;
		this.dt_pagamento = dt_pagamento;
		this.vl_pago = vl_pago;
	}


	public Titulo getTitulo() {
		return titulo;
	}


	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}


	public Calendar getDt_pagamento() {
		return dt_pagamento;
	}


	public void setDt_pagamento(Calendar dt_pagamento) {
		this.dt_pagamento = dt_pagamento;
	}


	public double getVl_pago() {
		return vl_pago;
	}


	public void setVl_pago(double vl_pago) {
		this.vl_pago = vl_pago;
	}

	
	
	

	
	
	
}
