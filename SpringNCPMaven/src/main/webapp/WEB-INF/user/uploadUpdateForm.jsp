<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

img {
	width: 70px;
	height: 70px;
}
</style>
</head>
<body>
	<!-- enctype="application/x-www-form-urlencoded" -->
	<form method="post" enctype="multipart/form-data" action="/mini/user/uploadUpdate">
		<input type="hidden" id="seq" name="seq" value="${seq }" />
		<table border="1">
			<tr>
				<th>상품명</th>
				<td><input type="text" id="imageName" name="imageName"
					size="35"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea id="imageContent" name="imageContent"
						rows="10" cols="50"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="file" name="img" id="img"> 
			</tr>
			<tr>
				<td>
					<div id="updateBeforeImage">
						<input type="hidden" id="beforeFileName" name="beforeFileName">
						<span>수정 전 이미지</span>
					</div>
				</td>

				<td>
					<div id="updateAfterImage">
						<span>수정 후 이미지</span>
						<span id="updateAfterImage"></span>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="목록" onclick="location.href='/mini/user/uploadList'"> 
				<input type="submit" value="이미지 수정" id="uploadUpdateFormBtn"> 
				<input type="reset" value="취소"></td>
			</tr>
		</table>

	</form>





	<script type="text/javascript"
		src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/uploadUpdateForm.js"></script>
	
	<script>
	

		//여러개의 이미지 미리보기
		$('#img').change(function() {
			

			for (var i = 0; i < this.files.length; i++) {
				readURL(this.files[i]);
			}
		});

		function readURL(file) {
			var reader = new FileReader();

			var show;
			reader.onload = function(e) {
				var img = document.createElement('img');
				img.src = e.target.result;
				img.width = 70;
				img.height = 70;
				$('#updateAfterImage').append(img);
			}
			console.log(img);
			reader.readAsDataURL(file);
		}
		
		$('#uploadUpdateFormBtn').click(function(){
			
			if($('#updateAfterImage').text()==''){
				return false;
			}
				
		
		})
		
		
		
	</script>
</body>
</html>


















