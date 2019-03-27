package com.jpro.lca.interfaces;

import com.jpro.lca.bean.AdvogadoProcesso;

public interface IAdvogadoProcessoDAO {

	public void AssociarAdvProc(AdvogadoProcesso advProc);
	public int proximoNume();
	
}
