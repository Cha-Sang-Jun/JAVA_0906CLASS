<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  http://localhost:8080/FirstWeb/cookie/member/login.jsp (지금경로)-->
	<!--  /FirstWeb/cookie/member/login.jsp 나중에 경로를 이렇게 써도 된다? -->

	<%-- <%= request.getContextPath() %> --%>
	
	<!-- 경로가 변하더라도 상관없게 -->
	<form action="<%= request.getContextPath() %>/cookie/member/login.jsp" method = "post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit">
				</td>
			</tr>
			<tr>
				<td colspan = "2">
					아이디 저장 <input type = "checkbox" name = "id">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>