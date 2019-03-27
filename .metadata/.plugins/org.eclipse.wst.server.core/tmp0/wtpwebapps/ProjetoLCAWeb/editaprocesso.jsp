<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@include file="header.jsp" %>
<script type='text/javascript'>


$(document).ready(function() {
		$.ajax({
		    url : 'ajax/processo/listaProcesso.jsp',
		    type : 'post',
		    data : {command:$("#campoajax").attr("value")},
		    dataType: 'html',
		    beforeSend: function(){
		    },
		    timeout: 1000,
		    success: function(retorno){
		    	$('.result').append(retorno);
		    },
		    error: function(erro){
		    	console.log(erro);
		    }
		  })
})

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
    
    <h3>Gestão de Processos</h3>
    
    <div class="pack-form" style="display:block !important;">
        <h3>Cadastrar Processo</h3>
        <s:form method="POST"  name="cadastrarProcesso" theme="simple">

    <div class="box-form-full">  
            <div class="field-left"><label>Forum</label></div>
            <div class="field-right">
           <s:select list="listaForum" listKey="cd_pessoa"
           			 listValue="nm_pessoa" headerKey="0" headerValue="Selecione um Forum"
           			 name="cadastraProcesso.forum.cd_pessoa" />
           
            </div>
        </div>
        
        <div class="clear"></div>
            
    <div class="box-form-full">  
            <div class="field-left"><label>Advogados</label></div>
            <div class="field-right">
           <s:select list="listaAdvogado" listKey="cd_pessoa"
                     listValue="nm_pessoa" headerKey="0" headerValue="Selecione um Advogado"
                     name="cadastraProcesso.advogado.cd_pessoa" />
           
            </div>
        </div>
        
        <div class="clear"></div>
            
        <div class="box-form-full"> 
            <div class="field-left"><label>Cliente</label></div>
            <div class="field-right">
            <s:select list="listaCliente" listKey="cd_pessoa"
            			listValue="nm_pessoa" headerKey="0" headerValue="Selecione um Cliente"
            			name="cadastraProcesso.cliente.cd_pessoa" />
            </div>
        </div>
        
        <div class="clear"></div>
        
        <div class="box-form-left">
            <div class="field-left"><label>Causa</label></div>
            <div class="field-right">
            <s:select list="listaCausa" listKey="cd_causa"
            			listValue="ds_causa" headerKey="0" headerValue="Selecione o tipo de causa"
            			name="cadastraProcesso.tipoCausa.cd_causa" />
            </div>
        </div>
        
        <div class="box-form-right">
            <div class="field-left"><label>Cobrança</label></div>
            <div class="field-right">
            <s:select list="listaCobranca" listKey="cd_cobranca"
            			listValue="ds_cobranca" headerKey="0" headerValue="Selecione o tipo de cobrança"
            			name="cadastraProcesso.tipoCobranca.cd_cobranca" />
            </div>
        </div>
        
        <div class="clear"></div>
            
        <div class="box-form-full h100">
            <div class="field-left"><label>Descrição</label></div>
            <div class="field-right">
            <s:textarea name="cadastraProcesso.ds_processo"></s:textarea>
            </div>
        </div>              
            
        <div class="clear"></div>
            
        <div class="box-form-left">
                <div class="field-left"><label>Abertura</label></div>
            <div class="field-right">
			<s:textfield cssClass="calendar"
					name="cadastraProcesso.dt_abertura"
			 /></div>
        </div>
        
        <div class="box-form-right">
            <div class="field-left"><label>Vencimento</label></div>
            <div class="field-right">
            <select>
            	<option></option>
            	<option>1</option>
            	<option>2</option>
            	<option>3</option>
            	<option>4</option>
            	<option>5</option>
            	<option>6</option>
            	<option>7</option>
            	<option>8</option>
            	<option>9</option>
            	<option>10</option>
            	<option>11</option>
            	<option>12</option>
            	<option>13</option>
            	<option>14</option>
            	<option>15</option>
            	<option>16</option>
            	<option>17</option>
            	<option>18</option>
            	<option>19</option>
            	<option>20</option>
            	<option>21</option>
            	<option>22</option>
            	<option>23</option>
            	<option>24</option>
            	<option>25</option>
            	<option>26</option>
            	<option>27</option>
            	<option>28</option>
            	<option>29</option>
            	<option>30</option>
            	<option>31</option>
            	
            </select>
            </div>
        </div>
        
        <div class="clear"></div>
            
        <div class="box-form-full h100">
            <div class="field-left"><label>Observação</label></div>
            <div class="field-right">
            <s:textarea name="cadastraProcesso.ds_observacao"></s:textarea>
            </div>
        </div>          
        
        <div class="clear"></div>
        
        <div class="box-form-full">
            <s:submit value="Cadastrar Processo" action="cadastrarprocesso" />
        </div>
            
        </s:form>
    </div>

    <div class="result"></div>
    
<%@include file="footer.jsp" %>