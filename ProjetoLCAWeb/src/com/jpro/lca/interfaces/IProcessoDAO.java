package com.jpro.lca.interfaces;

import java.util.List;

import com.jpro.lca.bean.AdvogadoHonorario;
import com.jpro.lca.bean.Pessoa;
import com.jpro.lca.bean.Processo;

public interface IProcessoDAO {

	public void CriarProcesso(Processo processo);
	public void AlterarProcesso(int nr_processo);
	public Processo ConsultarProcesso(int nr_processo);
	public List<Processo> ConsultarProcessos();
	public void apagarProcesso(int nr_processo);
	public List<Pessoa> ConsultarAdvogadosProcesso(int nr_processo);
	public List<AdvogadoHonorario> ConsultarHonorariosProcesso(int nr_processo);
}
