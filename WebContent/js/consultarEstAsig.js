$(document).ready(function(){
	$(".consultarestasig").click(consultarest);
});

function consultarest(event){
	event.preventDefault();
	var dataForm = $('#formConsultaEstAsig').serialize();
	$.ajax({
		type: 'POST',
        url:  "ConsEstAsig",
        data : dataForm,
        success:  function (response) {
        	$("#mainConsultas").html(response);
        },
        error: function(response){
        	$("#mainConsultas").html(response);
        }
	});
}