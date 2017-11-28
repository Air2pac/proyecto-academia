$(document).ready(function(){
	$( ".btnMantenimiento" ).each(function() {
		$(this).click(action);
	});
//	$(".elminar").click(elminar);
});

function action(id){
	$.ajax({
        url: $('#'+id).attr('id'),
        success:  function (response) {
           $("#mainMantenimiento").html(response);
        }
		, error: function(respone){
			alert("error" + response);
		}
	});
}
