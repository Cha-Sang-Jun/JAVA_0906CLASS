<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Signup JSP 변환</title>
<style>
</style>
</head>
<body>

	<h1>회원가입</h1>

	<%
		request.setCharacterEncoding("utf-8");

		String[] interests = request.getParameterValues("interest");
	%>


	아이디 :
	<%=request.getParameter("userid")%>
	<br> 비밀번호 :
	<%=request.getParameter("pw")%>
	<br> 이름 :
	<%=request.getParameter("username")%>
	<br> 자기소개 :
	<%=request.getParameter("comment")%>
	<br> 성별 :
	<%=request.getParameter("gender")%>
	<br> 관심사 :
	<%
		if (interests != null) {
			for (int i = 0; i < interests.length; i++) {
	%>
	interest :
	<%=interests[i]%>
	<br>
	<%
		}
		} else {
	%>
	interest : 선택된 관심사가 없습니다.
	<br>
	<%
		}
	%>
	<br> 생년 :
	<%=request.getParameter("byear")%>
	<br>

</body>
</html>