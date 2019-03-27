<%@page import="com.jpro.lca.bean.AgendaAudiencia"%>
<%@page import="com.jpro.lca.bean.AdvogadoHonorario"%>
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
//String command = request.getParameter("command");

List<AgendaAudiencia> audiencias = AdvocaciaNegocio.ListarAudiencias();

if(audiencias.size() > 0){
	for (AgendaAudiencia a: audiencias){
		out.println(
				"<div class=\"formsearch-box\"><a href=\"atualizaAudiencia?idAud="+a.getCd_agenda()
				+"#\" id=\"janela\">"+
			    ConversaoUtil.ExibirData(a.getDt_hora_agenda() , "dd/MM/yyyy HH:mm")+" - Processo:"+
			    a.getProcesso().getDs_processo()+
				"</a><p>Advogado: "+
				a.getAdvogado().getNm_pessoa()+" - Sala: "+
				a.getSl_forum()+
				"<a href=\"ajax/audiencia/excluirAudiencia.jsp?id="+a.getCd_agenda()
				+"\"><img src=\"images/delete.png\" id=\"delete\" /></a> </p></div>"
				);
	}
}else{
	out.println("Nenhuma audiência encontrada!");
}

%>