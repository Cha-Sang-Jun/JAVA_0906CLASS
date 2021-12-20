<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

</head>
<body>

	<!-- 헤더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 헤더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div>
		<h3>회원가입</h3>
		<hr>
		<!-- form 경로와 처리 경로가 동일 -> method로 구분 -->
		<!-- action - "reg.do" 생략 가능  => 생략해도 자기 자신으로 가는  것이기 때문에 properties 에서 .do로 처리하였으므로 상관없다. -->
		<form action ="reg.do" method="post">
			<table>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="userid"></td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td colspan=2></td>
					<td><input type ="submit" values = "회원가입하기"> <input type ="reset"> </td>
				</tr>
			</table>
		</form>

	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>