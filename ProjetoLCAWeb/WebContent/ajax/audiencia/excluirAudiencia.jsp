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
String id = request.getParameter("id");
AdvocaciaNegocio.excluirAudiencia(Integer.parseInt(id));
out.println("<script>alert('Audiência excluída com sucesso!')</script>");
out.println("<script>location.href=\"/ProjetoLCAWeb/audiencia\"</script>");
%>