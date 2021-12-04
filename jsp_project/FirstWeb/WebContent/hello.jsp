<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%   // --> 출력 (모니터에 출력하는게 아니라 명령어 객체를 toString 텍스트로 출력)
		// java 코드를 작성
		// java.util.Date now1 = new java.util.Date();
		Date now1 = new Date();
	%>

	<%=now1%>
	<h1>
		<%=LocalDateTime.now()%>
	</h1>
	<h1>처음 작성한 JSP 파일</h1>
</body>
</html>