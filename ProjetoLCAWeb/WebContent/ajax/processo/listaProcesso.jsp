<%@page import="com.jpro.lca.util.ConversaoUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.jpro.lca.bo.AdvocaciaNegocio"%>
<%@page import="com.jpro.lca.bean.AdvogadoProcesso"%>
<%@page import="com.jpro.lca.bean.Processo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

List<Processo> processos = AdvocaciaNegocio.ListarProcessos();

if(processos.size() > 0){
	for (Processo p: processos){
		out.println(
				"<div class=\"formsearch-box\"><a href=\"atualizaProcesso?idPro="+p.getNr_processo()+"#\" id=\"janela\">"+
			    ConversaoUtil.ExibirData(p.getDt_abertura(), "dd/MM/yyyy")+" - "+
			    p.getDs_processo()+
				"</a><p>"+
				p.getDs_processo()+
				"<a href=\"ajax/processo/excluirProcesso.jsp?id="+p.getNr_processo()+"\"><img src=\"images/delete.png\" id=\"delete\" /></a></p></div>"
				);
	}
}else{
	out.println("Nenhum processo encontrado!");
}




//out.println();

/*
dt_abertura

cd_resultado

forum

cliente


tipoCausa

*/



%>