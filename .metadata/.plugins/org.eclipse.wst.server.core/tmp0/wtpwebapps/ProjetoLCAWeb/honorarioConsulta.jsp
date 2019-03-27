<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="header.jsp"%>


<%@include file="top.jsp"%>

<h3>
	Consulta de Honorário
</h3>

<div class="pack-form" style="display: block;">
	<h3>Honorário</h3>
	<s:form theme="simple" action="consultar" method="get">
		<div class="box-form-full">
			<div class="field-left">
				<label for="Honorario">Honorário</label>
			</div>
			<div class="field-right">
				<s:textfield id="Honorario" disabled="true" name="AdvHonorario.cd_honorario"/>
			</div>
		</div>

		<div class="clear"></div>
		<div class="box-form-full">
			<div class="field-left">
				<label for="Processo">Processo</label>
			</div>
			<div class="field-right">
				<s:textfield id="Processo" disabled="true" name="AdvHonorario.processo.nr_processo +espaco+ AdvHonorario.processo.ds_processo" />
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="Advogado">Advogado</label>
			</div>
			<div class="field-right">
				<s:textfield disabled="true" id="Advogado" name="AdvHonorario.advogado.cd_pessoa+espaco+AdvHonorario.advogado.nm_pessoa" />
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
			<div class="field-left">
				<label for="TT">Tipo Tarefa</label>
			</div>
			<div class="field-right">
				<s:textfield id="TT" disabled="true"  name="AdvHonorario.tarefa.ds_tarefa"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-left">
			<div class="field-left">
				<label for="Data">Data</label>
			</div>
			<div class="field-right">
				<s:textfield id="Data" disabled="true" name="data"/>
				
			</div>
		</div>

		<div class="box-form-right">
			<div class="field-left">
				<label for="Duracao">Duração (h)</label>
			</div>
			<div class="field-right">
				<s:textfield id="Duracao" name="AdvHonorario.qt_horas" disabled="true"/>
			</div>
		</div>

		<div class="clear"></div>



		<div class="box-form-full h100">
			<div class="field-left">
				<label for="Descricao">Descrição</label>
			</div>
			<div class="field-right">
				<s:textarea id="Descricao" name="AdvHonorario.ds_observacao" disabled="true"/>
			</div>
		</div>

		<div class="clear"></div>

		<div class="box-form-full">
		
			<a href="honorario"><input type ="button" value="Voltar"/></a>
		</div>

	</s:form>
</div>

<div class="data-grid-local"></div>

<%@include file="footer.jsp"%>