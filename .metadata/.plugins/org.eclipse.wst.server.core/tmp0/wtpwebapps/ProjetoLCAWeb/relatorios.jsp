<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="header.jsp" %>
<script type='text/javascript'>

function relatorio(){
	
	$.ajax({
	    url : 'ajax/relatorio/listaRelatorio.jsp',
	    type : 'post',
	    data : {id:$("#processos_nr_processo").attr("value")},
	    dataType: 'html',
	    beforeSend: function(){
	    	$('.result').html("<img src=\"images/loading.gif\" />");
	    },
	    timeout: 0,
	    success: function(retorno){
	    	$('.result').html("");
	    	$('.result').append(retorno);
	    },
	    error: function(erro){
	    	console.log(erro);
	    }
	  })
	
}
</script>


<%@include file="top.jsp" %>
    
    <h3>Relatório de Pagamentos em Atraso por Processo</h3>
    
    <s:select list="processos" listKey="nr_processo"
    			listValue="ds_processo" headerKey="0" headerValue="Selecione o processo"
    			name="processos.nr_processo" onchange="relatorio()"
     />
    
    

    <div class="result" style="margin-top:20px;"></div>
    
    
<%@include file="footer.jsp" %>