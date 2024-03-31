$(function(){
	$('#uploadDelete').click(function(){
		
		$.ajax({
		type:'post',
		url:'/mini/user/uploadDeleteAll',
		data:$('#uploadListForm').serialize(),
		success: function(){
			alert('삭제 완료');
			location.href="/mini/user/uploadList";
		
		},
		error: function(e){
		
		console.log(e);
		
		}
		});
});
});