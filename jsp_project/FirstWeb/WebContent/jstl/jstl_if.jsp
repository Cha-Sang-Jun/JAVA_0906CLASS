<%@page import="member.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Member member = new Member("손흥민", 30);
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${false}">
		<!-- {} 안에 비교연산/논리연산 처리 가능 -->
		true 일 때 보여집니다. <br>
	 </c:if>

	<c:if test= "${member.age > 19}">
		${member.name} (${member.age})
	</c:if>
	
	<br>
	
	<!--  var 로 변수를 설정하여 session에 정보를 저장 => valueCheck에서 확인가능. -->
	<c:if test= "${member.age >= 20}" var = "chk" scope = "session"/>

</body>
</html>