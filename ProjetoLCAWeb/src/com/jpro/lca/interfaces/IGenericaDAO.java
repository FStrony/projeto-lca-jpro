package com.jpro.lca.interfaces;

import java.util.List;

import com.jpro.lca.bean.Advogado;
import com.jpro.lca.bean.Cliente;
import com.jpro.lca.bean.Forum;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Tarefa;
import com.jpro.lca.bean.Telefone;
import com.jpro.lca.bean.TipoCausa;
import com.jpro.lca.bean.TipoCobranca;
import com.jpro.lca.bean.TipoTelefone;

public interface IGenericaDAO {

	public List<TipoCausa> ListarTipoCausa();
	public List<TipoCobranca> ListarTipoCobranca();
	public List<Pessoa> ConsultarClientes();
	public List<Pessoa> ConsultarForuns();
	public List<Pessoa> ConsultarAdvogados();
	public List<Tarefa> ConsultarTarefas();
	public Advogado ConsultarAdvogado(int cd_advogado);
	public Forum ConsultarForum(int cd_forum);
	public Tarefa ConsultarTarefa(int cd_tarefa);
	public TipoCobranca ConsultarTipoCobranca(int cd_cobranca);
	public TipoCausa ConsultarTipoCausa(int cd_causa);
	public Cliente ConsultarCliente(int cd_cliente);
	public List<Telefone> ListarTelefon(int cd_cliente);
	public TipoTelefone ConsultarTipoTelefon(int cd_tipo);
}
