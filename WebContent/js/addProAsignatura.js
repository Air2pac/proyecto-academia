$(document).ready(function(){
	$(".confirma").click(addAsign);
});

function addAsign(event){
	event.preventDefault();
	var i = $(this).parent().siblings().first().children().first();
	$(i).attr('checked','checked');
	var dataForm = $('#AddProAsign').serialize();
	//alert(i);
	$.ajax({
		type: 'POST',
        url:  "AddProAsign",
        data : dataForm,
        success:  function (response) {
//        	$(i).parentsUntil('tbody').last().css('display','none');
        	$("#mainMantenimiento").html(response);
        },
        error: function(response){
        	alert("ERROR ocurrido");
        }
	});
}