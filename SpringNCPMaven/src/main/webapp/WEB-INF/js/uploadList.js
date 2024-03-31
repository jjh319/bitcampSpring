$(function(){
	$.ajax({
		type: 'post',
		url: '/mini/user/getUploadList',
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$.each(data, function(index, items){
			
				/*
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.seq
					
				})).append($('<td/>', {
					align: 'center',
					}).append($('<img/>', {
						src: '../storage/' + items.imageOriginalName,
						style: 'width: 70px; height: 70px;'
					}))
					
				).append($('<td/>', {
					align: 'center',
					text: items.imageName
					
				})).appendTo($('#uploadListTable'));
				*/
				
				/*
				var result = `<tr>`
						   + `<td align="center">` + items.seq + `</td>`
						   + `<td align="center"><img src="../storage/` + items.imageOriginalName + `" style="width: 70px; height: 70px;"/></td>`
						   + `<td align="center">` + items.imageName + `</td>`
						   + `</tr>`;
				$('#uploadListTable').append(result);
				*/
				
								 
				var result = `<tr>`
						   + `<td align="center">`
						   + `<input type="checkbox" name="check" id="check" value="`
						   + items.seq
						   +`">` 
						   + items.seq 
						   
						   + `</td>`
						   + `<td align="center"><img src="http://smqypeezwqty23292897.cdn.ntruss.com/storage/` 
						   
						   + items.imageFileName 
						   
						   + `" style="width: 70px; height: 70px;"/></td>`
						   + `<td align="center">` + items.imageName + `</td>`
						   + `<td align="center"><input type="button" id="uploadUpdateBtn" value="수정" onclick="uploadUpdate(` +items.seq + `)"/></td>`
						   + `<td align="center"><input type="button" id="uploadDeleteBtn" value="삭제" onclick="uploadDelete(` +items.seq + `)"/></td>`
						   + `</tr>`;
				
									
									
				
								 
				
				$('#uploadListTable').append(result);
				
				
				
				
				
			});//$.each
			
			//전체 선택 / 전체 해제
			
			$('#all').click(function(){
				if($(this).prop('checked')){
					$('input[name="check"]').prop('checked',true);
						
				}else{
					$('input[name="check"]').prop('checked',false);
				
				
				}		
				
		});
			//전체 선택 한 후 
			$('input[name="check"]').click(function(){
			$('#all').prop('checked', $('input[name="check"]').length == $('input[name="check"]:checked').length);
			});
		},
		error: function(e){
			console.log(e);
		}
	});//$.ajax
});


function uploadUpdate(seq){
	console.log(seq)
	location.href="/mini/user/uploadView?seq="+seq;
}


function uploadDelete(seq){
	
	$.ajax({
		type:'post',
		url:'/mini/user/uploadDelete',
		data:'seq='+seq,
		success: function(){
			alert('삭제 완료');
			location.href="/mini/user/uploadList";
		
		},
		error: function(e){
		
		console.log(e);
		
	
	
	}
	})
	
}









