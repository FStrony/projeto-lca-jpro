<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="header.jsp" %>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>	
<s:head />
<script type='text/javascript'>

$(document).ready(function() {
	$.ajax({
	    url : 'ajax/honorario/listaHonorario.jsp',
	    type : 'post',
	    data : {command:$("#campoajax").attr("value")},
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
	  });
});

$(window).load(function(){
(function($){
	
	var $_GET = getQueryParams(document.location.search);
	
	$('#Processo option').each(function(){
        if($(this).val() == $_GET.idPro){
            $(this).attr('selected',true);
        }
    });
	
	if($_GET.idPro > 0){
		$(".pack-form").slideDown('slow');
		$('#nova').html('-');
	}
	
});
});



function getQueryParams(qs) {
    qs = qs.split("+").join(" ");
    var params = {},
        tokens,
        re = /[?&]?([^=]+)=([^&]*)/g;

    while (tokens = re.exec(qs)) {
        params[decodeURIComponent(tokens[1])]
            = decodeURIComponent(tokens[2]);
    }

    return params;
}

function loadAdv(){
	var id = document.dados.Processo.value;
	window.location = "/ProjetoLCAWeb/honorario?idPro="+id;
	
}




</script>

<%@include file="top.jsp"%>

<h3>
	Gestão de Honorários<span id="nova">+</span>
</h3>

<div class="pack-form">
	<h3>Lançar Honorário</h3>
	<s:form theme="simple" method="post" name="dados" >
		<div class="box-form-full">
			<div class="field-left">
				<label for="Processo">Processo</label>
			</div>
			<div class="field-right">
				<s:select list="listaProcesso" listKey="nr_processo" name="lancaHonorario.processo.nr_processo"
					listValue="nr_processo + espaco + ds_processo" headerKey="0" headerValue="Selecione um Processo"
					id="Processo" onchange="loadAdv();"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="Advogado">Advogado</label>
			</div>
			<div class="field-right">
				<s:select list="listaAdvogado" listKey="cd_pessoa" name="lancaHonorario.advogado.cd_pessoa"
					listValue="nm_pessoa" headerKey="0" headerValue="Selecione um Advogado"
					id="Advogado"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="TT">Tipo Tarefa</label>
			</div>
			<div class="field-right">
				<s:select list="listaTarefa" listKey="cd_tarefa" name="lancaHonorario.tarefa.cd_tarefa"
					listValue="ds_tarefa" headerKey="0" headerValue="Selecione uma Tarefa" 
					id="TT"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-left">
			<div class="field-left">
				<label for="Data">Data</label>
			</div>
			<div class="field-right">
				<s:textfield id="Data" cssClass="calendar" name="lancaHonorario.dt_honorario"/>
				
			</div>
		</div>

		<div class="box-form-right">
			<div class="field-left">
				<label for="Duracao">Duração (h)</label>
			</div>
			<div class="field-right">
				<s:textfield id="Duracao" name="lancaHonorario.qt_horas"/>
			</div>
		</div>

		<div class="clear"></div>



		<div class="box-form-full h100">
			<div class="field-left">
				<label for="Descricao">Descrição</label>
			</div>
			<div class="field-right">
				<s:textarea id="Descricao" name="lancaHonorario.ds_observacao"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<s:submit value="Lançar Honorário" action="lancar" />
			
		</div>

	</s:form>
</div>

<div class="result"></div>

<%@include file="footer.jsp"%>