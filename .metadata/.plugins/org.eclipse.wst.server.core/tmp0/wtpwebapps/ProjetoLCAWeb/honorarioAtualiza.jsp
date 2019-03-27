<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="header.jsp"%>
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
	
	$('#Processo option').each(function(){
        if($(this).val() == $_GET.idPro){
            $(this).attr('selected',true);
        }
    });
	
	if($_GET.idAud > 0){
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
	var id = document.dados.Processo.value;
	window.location = "/ProjetoLCAWeb/audiencia?idPro="+id;
	
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

<h3>
	Atualização de Honorário
</h3>

<div class="pack-form" style="display: block;">
	<h3>Honorário</h3>
	<s:form theme="simple" method="post" >
		<div class="box-form-full">
			<div class="field-left">
				<label for="Honorario">Honorário</label>
			</div>
			<div class="field-right">
				<s:textfield id="Honorario" disabled="true" name="AdvHonorario.cd_honorario"/>
			</div>
		</div>

		<s:hidden name="retorno"></s:hidden>
        <s:hidden name="idHon"></s:hidden>
        
		<div class="clear"></div>
		<div class="box-form-full">
						<div class="field-left">
				<label for="Processo">Processo</label>
			</div>
			<div class="field-right">
				<s:textfield name="proAux.ds_processo" disabled="true"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="Advogado">Advogado</label>
			</div>
			<div class="field-right">
				<s:textfield name="advAux.nm_pessoa" disabled="true"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="TT">Tipo Tarefa</label>
			</div>
			<div class="field-right">
				<s:textfield name="tarAux.ds_tarefa" disabled="true"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-left">
			<div class="field-left">
				<label for="Data">Data</label>
			</div>
			<div class="field-right">
				<s:textfield id="Data" cssClass="calendar" name="AdvHonorario.dt_honorario" disabled="true"/>
				
			</div>
		</div>

		<div class="box-form-right">
			<div class="field-left">
				<label for="Duracao">Duração (h)</label>
			</div>
			<div class="field-right">
				<s:textfield id="Duracao" name="horas"/>
			</div>
		</div>

		<div class="clear"></div>



		<div class="box-form-full h100">
			<div class="field-left">
				<label for="Descricao">Descrição</label>
			</div>
			<div class="field-right">
				<s:textarea id="Descricao" name="desc"/>
			</div>
		</div>

		<div class="clear"></div>
		<div class="box-form-full">
		
			<s:submit value="Atualizar Honorário" action="atualizarHonorario"/>
		</div>
		<div class="box-form-full">
		
			<a href="honorario"><input type ="button" value="Voltar"/></a>
		</div>

	</s:form>
</div>

<div class="data-grid-local"></div>

<%@include file="footer.jsp"%>