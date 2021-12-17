<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 파일업로드 </h1>
	<hr>
	<form method = "post" enctype="multipart/form-data">
		
		이름 <input type = "text" name = "username"> <br>
		제목  <input type = "text" name = "title"> <br>
		파일 <input type = "file" name = "userfile"> <br>
		<input type = "submit">
	
	</form>

</body>
</html>