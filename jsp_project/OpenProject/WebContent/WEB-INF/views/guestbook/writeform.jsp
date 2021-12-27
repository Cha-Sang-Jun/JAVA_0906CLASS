<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 작성 글 등록 폼 </title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#content>form>table td {
	padding: 5px;
}
#content>form input {
	padding: 5px;
}

</style>


</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id="content">
		<h3> 게시글 작성 </h3>
		<hr>
		
		<form method="post">
		<input type="hidden" name="memberidx" value="${loginInfo.idx}">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject" value= "${write.subject}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content" rowspan = "5" colspan = "10" value = "${write.content}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type = "submit" value = "등록"><input type = "reset"></td>
				</tr>
			</table>
		
		</form>
	
	</div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>