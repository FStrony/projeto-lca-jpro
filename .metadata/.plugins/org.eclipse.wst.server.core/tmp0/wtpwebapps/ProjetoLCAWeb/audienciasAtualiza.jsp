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
	//alert("inicio "+document.location.search);
	//alert("inicio "+$_GET.idPro);
	
	$('#listaProcesso option').each(function(){
        if($(this).val() == $_GET.idPro){
            $(this).attr('selected',true);
        }
    });
	
	if($_GET.idAud > 0){
		$(".pack-form").slideDown('slow');
		$('#nova').html('-');
	}
    
})(jQuery)
});//]]>  
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
	window.location = "/ProjetoLCAWeb/audiencia?idPro="+document.dados.listaProcesso.value;
	
}
</script>

<style type='text/css'>
.ui-datagrid {width:100%;}
.ui-datagrid thead th
,.ui-datagrid tbody td {text-align:left;padding:0.5em 0.3em;vertical-align:middle;}
#data-grid-local {width:1000px;}

.ui-corner-tl { -moz-border-radius-topleft: 2px; -webkit-border-top-left-radius: 2px; border-top-left-radius: 2px; }
.ui-corner-tr { -moz-border-radius-topright: 2px; -webkit-border-top-right-radius: 2px; border-top-right-radius: 2px; }
.ui-corner-bl { -moz-border-radius-bottomleft: 2px; -webkit-border-bottom-left-radius: 2px; border-bottom-left-radius: 2px; }
.ui-corner-br { -moz-border-radius-bottomright: 2px; -webkit-border-bottom-right-radius: 2px; border-bottom-right-radius: 2px; }
.ui-corner-top { -moz-border-radius-topleft: 2px; -webkit-border-top-left-radius: 2px; border-top-left-radius: 2px; -moz-border-radius-topright: 2px; -webkit-border-top-right-radius: 2px; border-top-right-radius: 2px; }
.ui-corner-bottom { -moz-border-radius-bottomleft: 2px; -webkit-border-bottom-left-radius: 2px; border-bottom-left-radius: 2px; -moz-border-radius-bottomright: 2px; -webkit-border-bottom-right-radius: 2px; border-bottom-right-radius: 2px; }
.ui-corner-right {  -moz-border-radius-topright: 2px; -webkit-border-top-right-radius: 2px; border-top-right-radius: 2px; -moz-border-radius-bottomright: 2px; -webkit-border-bottom-right-radius: 2px; border-bottom-right-radius: 2px; }
.ui-corner-left { -moz-border-radius-topleft: 2px; -webkit-border-top-left-radius: 2px; border-top-left-radius: 2px; -moz-border-radius-bottomleft: 2px; -webkit-border-bottom-left-radius: 2px; border-bottom-left-radius: 2px; }
.ui-corner-all { -moz-border-radius: 2px; -webkit-border-radius: 2px; border-radius: 2px; }
</style>
<%@include file="top.jsp" %>
    
<h3>Gestão de Audiências<span id="nova">+</span></h3>
    
<s:form name="dados" method="post" theme="simple" action="atualizarAgenda">    
    <div class="pack-form">
        <h3>Agendar Audiência</h3>
        	
		<div class="box-form-full">
            <div class="field-left"><label>Processo</label></div>
            <div class="field-right">
			<s:textfield name="proAux.ds_processo" disabled="true"/>
            </div>
        </div>
        
        <s:hidden name="retorno"></s:hidden>
        <s:hidden name="idPro"></s:hidden>
        
        <div class="clear"></div>
            
        <div class="box-form-full"> 
            <div class="field-left"><label>Advogado</label></div>
            <div class="field-right">
			<s:textfield name="advAux.nm_pessoa" disabled="true"/>
            </div>
        </div>
        
        <div class="clear"></div>
        
        <div class="box-form-right">
            <div class="field-left"><label>Sala</label></div>
            <div class="field-right">
            <s:textfield key="sl_forum" name="sala" required="true"/></div>
        </div>
                
        <div class="box-form-left">
                <div class="field-left"><s:label>Data e hora</s:label></div>
            <div class="field-right">
            <s:textfield key="dt_hora_agenda" name="data" cssClass="calendartime"/>
            </div>
        </div>
        
        <!-- <div class="box-form-right">
        <div class="field-right">
        <s:checkbox name="notifica" label="Notificar cliente por e-mail" />
        <label>Notificar cliente por e-mail </label>
        </div>
        </div> -->
        
        <div class="box-form-right">
            <a href="enviaremail"><input type="button" value="Reenviar e-mail" /></a>
        </div>
        
        <div class="clear"></div>
        
        <div class="box-form-full">
        <s:submit value="Atualizar Audiência" />
        </div>
            
     
    </div>
</s:form>
    <div class="data-grid-local"></div>

<%@include file="footer.jsp" %>