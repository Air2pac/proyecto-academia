$(document).ready(function(){
	$(".consultarAsigcur").click(consultarasigcur);
});

function consultarasigcur(event){
	event.preventDefault();
	var dataForm = $('#formConsultaCurAsigCursos').serialize();
	$.ajax({
		type: 'POST',
        url:  "ConsAsigCur",
        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
}