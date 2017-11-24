$(document).ready(function(){
	$( "button" ).each(function() {
		$(this).click(mostrar);
	});
});

function mostrar(){
	estilos($(this));	
	$('main').load('jsp/'+ $(this).attr('id') + '.jsp' );
}//mostrar

function estilos(boton){
	$( "button" ).each(function() {
		if($(this).attr('id') == $(boton).attr('id')){
			$(this).addClass('pulsado');
		}else{
			$(this).removeClass('pulsado');
		}//if-else
	});
}//estilos