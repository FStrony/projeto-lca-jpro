package com.jpro.lca.interfaces;

import java.util.List;


import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;

public interface IGenericaDAO {

	public List<TipoCausa> ListarTipoCausa();
	public List<TipoCobranca> ListarTipoCobranca();
	public List<Pessoa> ConsultarClientes();
	public List<Pessoa> ConsultarForuns();
	public List<Pessoa> ConsultarAdvogados();
	public List<Tarefa> ConsultarTarefas();
	
}
