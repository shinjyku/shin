/**
 * 
 */
$(function(){

	$('#form1').submit(function() {

    alert("#search");

	});

	$('#form2').submit(function() {

    alert("#insert");

				var msg = "";
			  if($("input[name='bcode']").val() == ""){
			  msg = msg + "-コード";
			  }
			  if($("input[name='bname']").val() == ""){
			  msg = msg + "-名称";
			  }
			  if($("input[name='delflg']").val() == ""){
			  msg = msg + "-削除";
			  }

			  if (msg.length ) {
			     $("#err").val(msg + "-未入力");
				 $('input').first().focus();
			    return false;
			  }else{
				 $("#err").val("");
			    return true;
				}

	});
	
});
