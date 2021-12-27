<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ajax-3</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	$(document).ready(function() {

/* 		$.get('data.html', function(data) {
			$('#list').html(data);
		}) */
		
		$.post('data.html', function(data) {
			$('#list').html(data);
		})
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
	<h3 id="list"></h3>




</body>
</html>