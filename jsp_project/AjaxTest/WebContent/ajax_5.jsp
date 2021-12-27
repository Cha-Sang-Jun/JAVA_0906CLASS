<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ajax-5</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	$(document).ready(function() {

		$.getJSON('data.json', function(data){
			// data는 Json 문자열이 아니라 javascript의 객체로 변환된 데이터이다.
			// $.each(data, function(){});
			// $('h1').each(function(){});
			
			$.each(data, function(index, value){
				var html = '제품명 :' + value.name + ', 가격 ' + value.price + '원 <br>';
				$('#list').append(html);
			});
		});
		
	});
	
</script>
</head>
<body>

	<h1>메뉴 표</h1>
	<hr>

	<input type="text" id="pname" placeholder="제품이름 입력">
	<input type="number" id="price" placeholder="제품가격 입력">
	<input type="submit" id='btn'>

	<hr>
	<h3 id="list">
	
	
	</h3>




</body>
</html>