$(function() {
	
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: false});
	$('.js-cpf').mask('000.000.000-00', {reverse: false});
	$('.js-cnh').mask("00000000000", {reverse: false});
});

