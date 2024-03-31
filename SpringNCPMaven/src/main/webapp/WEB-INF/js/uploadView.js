$(function(){

	$.ajax({
		type:'post',
		url:'/mini/user/getUploadUser',
		data:{'seq':$('#seq').val()},
		dataType:'json',
		success: function(data){
			$('#imageNameSpan').text(data.imageName);
			$('#imageOriginalNameSpan').text(data.imageOriginalName);
			$('#imageContentSpan').text(data.imageContent);
			
			var img=`<img src="http://smqypeezwqty23292897.cdn.ntruss.com/storage/` 
					+ data.imageFileName 
				    + `" width="100" heigth="100"/>`
						   
			$('#imageSpan').html(img);
			
		},
		error: function(e){
			console.log(e);
		}
	
	})

});