<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="header.jsp"%>

<%@include file="top.jsp"%>

<script type="text/javascript">

function DoPrinting(){

document.getElementById('imprimir').style.display = "none";
document.getElementById('voltar').style.display = "none";
self.print();
document.getElementById('imprimir').style.display = "block";
document.getElementById('voltar').style.display = "block";
}


</script>


<h3>Consulta de Pagamento em Aberto</h3>

<div class="pack-form" style="display: block;">
	<h3>Pagamento em aberto</h3>
	<s:form theme="simple" method="get" action="gerarRelatorio"/>
	
	<div class="box-form-full">
		<div class="field-left">
			<s:label>Número do processo:</s:label>
		</div>
		<div class="field-right">
			<s:property value="processo.nr_processo" />
		</div>
	</div>

	<div class="clear"></div>
	
	<div class="box-form-full">
		<div class="field-left">
			<s:label>Descrição: </s:label>
		</div>
		<div class="field-full">
			<s:property value="processo.ds_processo" />
		</div>
	</div>

	<div class="clear"></div>
	
	<div class="box-form-full">
		<div class="field-left">
			<s:label>Cliente:</s:label>
		</div>
		<div class="field-full">
			<s:property value="processo.cliente.nm_razao_social" />
		</div>
	</div>

	<div class="clear"></div>

	<div class="box-form-full">
		<div class="field-left">
			<s:label>Telefone: </s:label>
		</div>
		<div class="field-full">
			<s:property value="tele"/>
		</div>
	</div>
	
	<div class="clear"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div class="box-form-full">
		<div class="field-left">
			<s:label>Nº Documento</s:label>
		</div>
		<div class="field-right">
			<s:property value="titulo.nr_titulo"/>
		</div>
	</div>

	<div class="clear"></div>
	
	<div class="box-form-left">
		<div class="field-left">
			<s:label>Data Vencimento</s:label>
		</div>
		<div class="field-right">
			<s:property value="data"/>
		</div>
	</div>

	<div class="box-form-right">
		<div class="field-left">
			<s:label>Valor do Documento:</s:label>
		</div>
		<div class="field-right">
			<s:property value="valor"/>
		</div>
	</div>
	
	<div class="clear"></div>
		<div class="box-form-left">
		<div class="field-left">
			<s:label>Dias em atraso: </s:label>
		</div>
		<div class="field-right">
			<s:property value="dias"/>
		</div>
	</div>

	<div class="box-form-right">
		<div class="field-left">
			<s:label>Valor de Juros</s:label>
		</div>
		<div class="field-right">
			<s:property value="juros"/>
		</div>
	</div>
	
	<div class="clear"></div>
	
	<div class="box-form-full">
		<div class="field-left">
			<s:label>Multa</s:label>
		</div>
		<div class="field-right">
			<s:property value="valorMultar"/>
		</div>
	</div>
	<div class="clear"></div>
	
	
	<div class="box-form-full">
	
	
			<input type="button" name="imprimir" id="imprimir" value="Imprimir" onclick="DoPrinting()">
			<a href="relatorios.jsp"><input name="voltar" id="voltar"  type ="button" value="Voltar"/></a>
	</div>

</div>
</body>
</html>