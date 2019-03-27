package com.jpro.lca.interfaces;

import java.util.List;

import com.jpro.lca.bean.Titulo;

public interface ITituloDAO {

	public Titulo ConsultarTitulo(int nr_titulo);
	public List<Titulo> ConsultarTitulosEmAberto(int nr_processo);
	
}
