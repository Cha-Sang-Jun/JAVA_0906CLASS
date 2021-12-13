<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>
		request 객체 속성 값 :
		<%=request.getAttribute("num1")%></h3>

	<h3>
		session 객체 속성 값 :
		<%=request.getAttribute("id")%></h3>

	<h3>
		application 객체 속성 값 :
		<%=application.getAttribute("num2")%></h3>

	<!-- request : 속성 값 안남음  (요청이 한번 된 후 생성되서 한번 응답 후 사라짐)
	     session : 속성 값 한번 넘어옴 (일정 시간 동안 아무 활동하지 않거나 브라우저를 닫거나 invalidate 된 메소드 실행시 사라짐)
		 applicaiton : 속성 값 계속 남아 있음. (시간이 지나도 계속 남아 있음)  -->

</body>
</html>