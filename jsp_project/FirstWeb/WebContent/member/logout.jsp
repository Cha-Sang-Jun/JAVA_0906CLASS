<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// 로그아웃 : session 객체를 소멸! -> 속성 값도 함께 소멸
    	session.invalidate();
    %>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 로그아웃 되었습니다. </h1>
	<h3><a href = "mypage.jsp"> mypage 이동 </a></h3>

</body>
</html>