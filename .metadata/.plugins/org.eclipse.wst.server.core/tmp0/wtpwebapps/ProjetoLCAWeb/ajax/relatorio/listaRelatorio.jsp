<%@page import="com.jpro.lca.util.ConversaoUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.jpro.lca.bo.AdvocaciaNegocio"%>
<%@page import="com.jpro.lca.bean.AdvogadoProcesso"%>
<%@page import="com.jpro.lca.bean.Titulo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String id = request.getParameter("id");

List<Titulo> titulos = AdvocaciaNegocio.ListarTitulosEmAberto(Integer.parseInt(id));

if(titulos.size() > 0){
	for (Titulo t: titulos){
		out.println(
				"<div class=\"formsearch-box\"><a href=\"#\" id=\"janela\">"+
			    ConversaoUtil.ExibirData(t.getDt_documento(), "dd/MM/yyyy")+", Vencimento em "+
			    ConversaoUtil.ExibirData(t.getDt_vencimento(), "dd/MM/yyyy")+" - "+
			    t.getProcesso().getDs_processo()+
				"</a><p>"+
				"Nro Agência: "+t.getNr_agencia_cedente()+" - Valor: "+t.getVl_documento()+
				"</p></div>"
				);
	}
}else{
	out.println("Nenhum relatório encontrado!");
}

%>