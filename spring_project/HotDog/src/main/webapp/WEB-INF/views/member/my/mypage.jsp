<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main role="main" class="container">

		<div class="my-3 p-3 bg-white rounded shadow-sm ">

			<h3>회원 정보</h3>
			<hr>
			<table class="table">
				<tr>
					<td>이메일</td>
					<td>${member.email}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${member.password}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${member.name}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td><img
						src="${pageContext.request.contextPath}/uploadfile/${member.profile}"
						height="100"></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td>${member.regdate}</td>
				</tr>
			</table>


		</div>

	</main>
</body>
</html>