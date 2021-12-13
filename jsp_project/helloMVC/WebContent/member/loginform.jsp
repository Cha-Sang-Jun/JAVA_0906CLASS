<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform</title>
</head>
<body>

	<h1> This is loginform page </h1>
	<hr>
	
	<form action = "/helloMVC/doLogin" method = "post">
		ID : 
		<input type = "text" name = "id" /> <br>
		<input type = "submit" value = "press" />
		
	</form>

</body>
</html>