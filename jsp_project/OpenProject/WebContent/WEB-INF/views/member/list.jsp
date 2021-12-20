<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title> 회원 정보 목록 </title>

<%@ include file = "/WEB-INF/views/frame/pageset.jsp" %>

</head>
<body>

	<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
	
	<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>
	
		<div id = "content">
	
		<h3> 회원 정보 리스트 </h3>
		<hr>
		
		<table border=1>
			<tr>
				<th> 회원아이디 </th>	
				<th> 회원 이름</th>	
				<th> 관리 </th>			
			</tr>
			
			<c:if test = "${not empty memberList}">
			
			<c:forEach items = "${memberList}" var = "member">
			<tr>
				<td>${member.userid}</td>
				<td>${member.username}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/views/member/reg.do?userid=${member.userid}"> </a>
			</tr>
			</c:forEach>
			</c:if>
			
			<c:if test = "${empty memberList}">
			<tr>
				<td colspan = "4">등록된 회원정보가가 없습니다.</td>
			</tr>
			</c:if>
		</table>
	</div>
</body>
</html>