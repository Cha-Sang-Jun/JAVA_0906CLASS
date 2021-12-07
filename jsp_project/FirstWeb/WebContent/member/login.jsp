<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Login Form Data</h1>
	<!-- test -->  <!-- 이 주석은 들어가지 않음, 스크립트릿 영역안 Java 주석은 들어감. -->

	<%
		// 스크립트릿 영역 : Java 문법 코드 작성
		String uid = request.getParameter("userid");
		// request : 내장객체 (변수의 별도 선언이 없고, 객체의 생성도 없다)
		// -> jsp가 서블릿으로 변환되는 과정에서 바로 실행 되는것이 아니라 변환이 되서 실행되기 때문에
		//  서블렛에서 이미 만들어져서 실행되기 때문에 별도 선언이 필요가없다
	%>
	아이디 :
	<%=uid%>
	<br> 비밀번호:
	<%=request.getParameter("pw")%>

	<br>
	<%=new Date()%>


</body>
</html>