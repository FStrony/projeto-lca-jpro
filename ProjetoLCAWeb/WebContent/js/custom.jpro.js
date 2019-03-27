novo = false;
$(function(){	
	$('#nova').click(function(){
	if(novo == false){
		$(".pack-form").slideDown('slow');
		$('#nova').html('-');
		novo = true;
	}else{
		$(".pack-form").slideUp('slow');
		$('#nova').html('+');
		novo = false;
	}
	})
	$(".calendar").datepicker({
    	dateFormat: 'dd/mm/yy',
    	dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
    	dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
    	dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
    	monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    	monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
    	nextText: 'Próximo',
   	prevText: 'Anterior'
	});
	$(".calendartime").datetimepicker({
    	dateFormat: 'dd/mm/yy',
    	dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado','Domingo'],
    	dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
    	dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
    	monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    	monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
    	nextText: 'Próximo',
   	prevText: 'Anterior',
   	timeText: 'Hora',
	hourText: 'Hora',
	minuteText: 'Minutos',
	secondText: 'Segundos',
	currentText: 'Agora',
	closeText: 'Fechar'
	});

});
$(document).ready(function() {
	$("a#janela").fancybox({
		'height'				: '98%',
		'width'				: '98%',
		'autoScale'			: true,
		'transitionIn'		: 'none',
		'transitionOut'	: 'none',
		'type'				: 'iframe'
	});
});

