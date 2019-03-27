package com.jpro.lca.interfaces;

import java.util.List;

import com.jpro.lca.bean.AgendaAudiencia;

public interface IAgendaAudienciaDAO {

	public void InserirAudiencia(AgendaAudiencia agendaAudiencia);
	public void AlterarAudiencia(int cd_agenda);
	public AgendaAudiencia ConsultarAudiencia(int cd_agenda);
	public List<AgendaAudiencia> ConsultarAudiencias();
	public void apagarAudiencia(int cd_agenda);
	
}
