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
	
	title : ${title} <br>
	userName : ${userName} <br>
	contentType : ${contentType} <br>
	fileName : ${fileName} <br>
	fileSize : ${fileSize} <br>
	
	<img src = "${pageContext.request.contextPath}/uploadfile/${fileName}" width = "200">

</body>
</html>