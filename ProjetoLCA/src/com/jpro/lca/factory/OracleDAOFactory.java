package com.jpro.lca.factory;

import com.jpro.lca.dao.AdvogadoHonorarioDAO;
import com.jpro.lca.dao.AdvogadoProcessoDAO;
import com.jpro.lca.dao.AgendaAudienciaDAO;
import com.jpro.lca.dao.GenericaDAO;
import com.jpro.lca.dao.ProcessoDAO;
import com.jpro.lca.dao.TituloDAO;
import com.jpro.lca.interfaces.IAdvogadoHonorarioDAO;
import com.jpro.lca.interfaces.IAdvogadoProcessoDAO;
import com.jpro.lca.interfaces.IAgendaAudienciaDAO;
import com.jpro.lca.interfaces.IGenericaDAO;
import com.jpro.lca.interfaces.IProcessoDAO;
import com.jpro.lca.interfaces.ITituloDAO;


public class OracleDAOFactory extends DAOFactory{

	
	public IProcessoDAO getProcessoDAO() {
		return new ProcessoDAO();
	}

	
	public ITituloDAO getTituloDAO() {
		return new TituloDAO();
	}

	public IAdvogadoProcessoDAO getAdvogadoProcessoDAO() {
		return new AdvogadoProcessoDAO();
	}


	public IAgendaAudienciaDAO getAgendaAudienciaDAO() {
		return new AgendaAudienciaDAO();
	}

	public IAdvogadoHonorarioDAO getAdvogadoHonorarioDAO() {
		return new AdvogadoHonorarioDAO();
	}
	
	public IGenericaDAO getGenericaDAO() {
		return new GenericaDAO();
	}



}
