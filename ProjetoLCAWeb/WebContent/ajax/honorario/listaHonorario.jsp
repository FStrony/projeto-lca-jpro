<%@page import="com.jpro.lca.bean.AdvogadoHonorario"%>
<%@page import="com.jpro.lca.util.ConversaoUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.jpro.lca.bo.AdvocaciaNegocio"%>
<%@page import="com.jpro.lca.bean.AdvogadoProcesso"%>
<%@page import="com.jpro.lca.bean.Processo"%>
<%@page import="com.jpro.lca.bean.Tarefa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//String command = request.getParameter("command");

List<AdvogadoHonorario> honorarios = AdvocaciaNegocio.ListarHonorarios();

if(honorarios.size() > 0){
	for (AdvogadoHonorario h: honorarios){
		out.println(
				"<div class=\"formsearch-box\"><a href=\"atualizaHonorario?idHon="+h.getCd_honorario()
				+"#\" id=\"janela\">"+
			    ConversaoUtil.ExibirData(h.getDt_honorario(), "dd/MM/yyyy")+" - "+
			    h.getProcesso().getDs_processo()+
				"</a><p>"+
				h.getAdvogado().getNm_pessoa()+" - Tarefa: "+h.getTarefa().getDs_tarefa()+
				"<a href=\"ajax/honorario/excluirHonorario.jsp?id="+h.getCd_honorario()+"\"><img src=\"images/delete.png\" id=\"delete\" /></a></p></div>"
				);
	}
}else{
	out.println("Nenhum honorário encontrado!");
}


%>