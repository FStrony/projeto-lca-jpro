package com.jpro.lca.interfaces;

import java.util.List;

import com.jpro.lca.bean.AdvogadoHonorario;

public interface IAdvogadoHonorarioDAO {
	
	public void LancarHonorario(AdvogadoHonorario advHonorario);
	public void AlterarHonorario(double duracao, String desc, int idHon);
	public AdvogadoHonorario ConsultarHonorario(int cd_honorario);
	public List<AdvogadoHonorario> ConsultarHonorarios();
	public void removerHonorario(int cd_honorario);

}
