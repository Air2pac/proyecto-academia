$(document).ready(function(){
	$(".consultarproasig").click(consultarpro);
});

function consultarpro(event){
	event.preventDefault();
	var dataForm = $('#formConsultaProfAsig').serialize();
	$.ajax({
		type: 'POST',
        url:  "ConsProfAsig",
        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
}