$(document).ready(function(){
	$( ".btnMantenimiento" ).each(function() {
		$(this).click(action);
	});
//	$(".elminar").click(elminar);
});

function action(id){
	$.ajax({
        url:   $('#'+id).attr('id'),
        success:  function (response) {
           $("#mainMantenimiento").html(response);
        }
	});
}

function eliminar(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#eliminarEstudianteForm').serialize();
	alert(i);
	$.ajax({
		type: 'POST',
        url:  "BorrarEstudiante",
        data : dataForm,
        success:  function (response) {
        	$(i).parentsUntil('tbody').last().css('display','none');
          $('.container').html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}