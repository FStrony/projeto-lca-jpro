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
$(window).load(function(){
	(function($){
		
		var $_GET = getQueryParams(document.location.search);
		
		$('#listaProcesso option').each(function(){
	        if($(this).val() == $_GET.idPro){
	            $(this).attr('selected',true);
	        }
	    });
		
		if($_GET.idPro > 0){
			$(".pack-form").slideDown('slow');
			$('#nova').html('-');
		}
		
	    var $dgLocal = $('.data-grid-local')
	    
	    $dgLocal.datagrid({
	        jsonStore: {
	            data: {"rows":[
	                {"id":"1","nome":"Fulano de Tal","empresa":"Empresa 1"}
	                ,{"id":"2","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"3","nome":"Beltrano da Silva","empresa":"Empresa do tal"}
	                ,{"id":"4","nome":"Beltrano da Silva","empresa":"Empresa 123122"}
	                ,{"id":"5","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"6","nome":"Beltrano da Silva","empresa":"Empresa 3312"}
	                ,{"id":"7","nome":"Beltrano da Silva","empresa":"Empresa 312"}
	                ,{"id":"8","nome":"Beltrano da Silva","empresa":"Empresa 3123122"}
	                ,{"id":"9","nome":"Fulano de Tal","empresa":"Empresa 221"}
	                ,{"id":"10","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"11","nome":"Beltrano da Silva","empresa":"Empresa 3123122"}
	                ,{"id":"12","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"13","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"14","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"15","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"16","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"17","nome":"Fulano de Tal","empresa":"Empresa 2"}
	                ,{"id":"18","nome":"Beltrano da Silva","empresa":"Empresa 1232"}
	                ,{"id":"18","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"20","nome":"Fulano de Tal","empresa":"Empresa 2"}
	                ,{"id":"21","nome":"Beltrano da Silva","empresa":"Empresa23 2"}
	                ,{"id":"22","nome":"Beltrano da Silva","empresa":"Empresa 2"}
	                ,{"id":"23","nome":"Fulano de Tal","empresa":"Empresa 1233332"}
	            ]}
	        }
	        ,pagination:true
	        ,mapper:[{
	            name: 'id',alias:'Código',css:{width:50,textAlign:'center'}
	        },{
	            name: 'nome',alias:'Nome',css:{width:300,textAlign:'left'}
	        },{
	            name: 'empresa',alias:'Empresa',css:{textAlign:'left'}
	        }]
	    })
	    
	})(jQuery)
	});//]]>  


$(document).ready(function() {
	$.ajax({
	    url : 'ajax/audiencia/listaAudiencia.jsp',
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
	  })
	  
	var $_GET = getQueryParams(document.location.search);
	
	$('#listaProcesso option').each(function(){
        if($(this).val() == $_GET.idPro){
            $(this).attr('selected',true);
        }
    });
	
	if($_GET.idPro > 0){
		$(".pack-form").slideDown('slow');
		$('#nova').html('-');
	}
})
</script>

<script>
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
	var id = document.dados.listaProcesso.value;
	window.location = "/ProjetoLCAWeb/audiencia?idPro="+id;
	
}
</script>


<%@include file="top.jsp" %>
    
<h3>Gestão de Audiências<span id="nova">+</span></h3>
    
<s:form name="dados" method="post" theme="simple" action="agendar">    
    <div class="pack-form">
        <h3>Agendar Audiência</h3>
        	
		<div class="box-form-full">
            <div class="field-left"><label>Processo</label></div>
            <div class="field-right">
            <s:select id="listaProcesso" list="listaProcesso" listKey="nr_processo" name="agendaAudiencia.processo.nr_processo"
					listValue="nr_processo + espaco + ds_processo" headerKey="0" headerValue="Selecione um Processo"
					onchange="loadAdv();"/>
            </div>
        </div>
        
        <s:hidden name="retorno"></s:hidden>
        
        <div class="clear"></div>
            
        <div class="box-form-full"> 
            <div class="field-left"><label>Advogado</label></div>
            <div class="field-right">
            <s:select list="listaAdvogado" listKey="cd_pessoa" name="agendaAudiencia.advogado.cd_pessoa"
					listValue="nm_pessoa" headerKey="0" headerValue="Selecione um Advogado"
					/>
            </div>
        </div>
        
        <div class="clear"></div>
        
        <div class="box-form-right">
            <div class="field-left"><label>Sala</label></div>
            <div class="field-right">
            <s:textfield key="sl_forum" name="agendaAudiencia.sl_forum" required="true"/></div>
        </div>
                
        <div class="box-form-left">
                <div class="field-left"><s:label>Data e hora</s:label></div>
            <div class="field-right">
            <s:textfield key="dt_hora_agenda" name="datahora" cssClass="calendartime"/>
            </div>
        </div>
        
        <!-- <div class="box-form-right">
        <div class="field-right">
        <s:checkbox name="notifica" label="Notificar cliente por e-mail" />
        <label>Notificar cliente por e-mail </label>
        </div>
        </div>
        
        <div class="box-form-right">
            <input type="button" value="Reenviar e-mail" />
        </div>-->
        
        <div class="clear"></div>
        
        <div class="box-form-full">
        <s:submit value="Agendar Audiência" />
        </div>
            
     
    </div>
</s:form>
    <div class="result"></div>

<%@include file="footer.jsp" %>