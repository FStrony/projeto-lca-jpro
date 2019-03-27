package com.jpro.lca.factory;

import com.jpro.lca.interfaces.IAdvogadoHonorarioDAO;
import com.jpro.lca.interfaces.IAdvogadoProcessoDAO;
import com.jpro.lca.interfaces.IAgendaAudienciaDAO;
import com.jpro.lca.interfaces.IGenericaDAO;
import com.jpro.lca.interfaces.IProcessoDAO;
import com.jpro.lca.interfaces.ITituloDAO;

	public abstract class DAOFactory {
		
	public static DAOFactory oracleDAOFactory;
	
	public static DAOFactory getDAOFactory(DBVendor qualFabrica){
		switch(qualFabrica){
		case ORACLE:
			if(oracleDAOFactory == null){
				oracleDAOFactory = new OracleDAOFactory();
			}
			return oracleDAOFactory;
		default:
			return null;
		}
	}
	
	public abstract IProcessoDAO getProcessoDAO();
	public abstract ITituloDAO getTituloDAO();
	public abstract IAdvogadoProcessoDAO getAdvogadoProcessoDAO();
	public abstract IAgendaAudienciaDAO getAgendaAudienciaDAO();
	public abstract IAdvogadoHonorarioDAO getAdvogadoHonorarioDAO();
	public abstract IGenericaDAO getGenericaDAO();
}
