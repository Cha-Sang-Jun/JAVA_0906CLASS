<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// CookieBox 이용해서 ID를 저장 -> 다른 페이지로 이동했을 때 로그인 유무를 판단

	// 사용자 요청 정보 : id, pw를 받아서 쿠키에 저장
	// id와 pw 값이 일치할 때 저장

	// 데이터 받기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	// id / pw 값이 일치할 때 저장 : 로그인 처리
	if (id.equals(pw)) {
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/"));
		// http://localhost:8080/.... -> "/"는 로컬호스트 뒤에 오는 모든 경로를 ~~ 뭐라고?
		// -1은 브라우저가 닫힐 때까지 유지, 닫히면 같이 사라짐
		response.addCookie(CookieBox.createCookie("ID", id, -1, "/"));

	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 로그인 되었습니다. </h1>
	<h3><a href = "/first/cookie/member/mypage.jsp"> mypage</a></h3>
	
</body>
</html>
<% } else { %> <!-- 값을 저장 한 후 if가 바로 끝나면 안되므로 여기서 닫는다. -->
<script> 
	alert('로그인 실패!!');
	history.go(-1);
</script>
<% } %>