$(document).ready(function(){
	$(".consultarpro").click(consultarpro);
});

function consultarpro(event){
	event.preventDefault();
	var dataForm = $('#formConsultaProfesor').serialize();
	$.ajax({
		type: 'POST',
        url:  "ConsultarProf",
        data : dataForm,
        success:  function (response) {
        	$("#cuerpoConsPro").html(response);
        },
        error: function(response){
        	$("#mainMantenimiento").html(response);
        }
	});
}