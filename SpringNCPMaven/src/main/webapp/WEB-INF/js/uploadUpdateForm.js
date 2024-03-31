$(function(){

	$.ajax({
		type:'post',
		url:'/mini/user/getUploadUser',
		data:'seq=' + $('#seq').val(),
		dataType:'json',
		success:function(data){
		
			console.log(JSON.stringify(data));
		
			$('#imageName').val(data.imageName);
			$('#imageContent').text(data.imageContent);
			$('#beforeFileName').val(data.imageFileName);
			var img = `<img src='/mini/storage/`+data.imageOriginalName +`' />`
			
			
			$('#updateBeforeImage').append(img);
		
		},
		error: function(e){
			console.log(e);
		
		}
		
	
	
	}); //ajax



	



});