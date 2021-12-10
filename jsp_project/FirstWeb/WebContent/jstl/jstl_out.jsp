<%@page import="java.util.ArrayList"%>
<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%  
 // 코어태그를 추가 한 후 속성 값을 사용.
 
	List<Member> members = new ArrayList<Member>();
	members.add(new Member(null, 20));
	members.add(new Member("이강인", 19));
	members.add(new Member("손흥민", 30));
	members.add(new Member(null, 35));
	members.add(new Member("박지성", 40));
	
	request.setAttribute("members", members); 
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.no_name{
		color :red;
	}
	
</style>
</head>
<body>

	<c:out value = "${members[0].name }" escapeXml = "false"> <!-- excapeXml =>  --> 
		<span style = "color : red;"> 입력된 이름 정보가 존재하지 않습니다. (출력값이 null 일 때 기본값) </span>
	</c:out>
	
	<br>
	
	<c:out value = "${members[0].name }" default ="NO NAME" /> 
	
	<br>
	
	<c:out value = "${members[1].name }"> </c:out> 
	<br>
	
	<hr>
	
		이 름   :   나 이 <br>
	<!-- 회원 정보 리스트 출력 -->
	<c:forEach items = "${members}" var ="member">
		
		<c:out value = "${member.name}" escapeXml = "false"> 
			<span class = "no_name"> NO NAME </span>
 		</c:out>
 				
		: ${member.age} <br>
			
	</c:forEach>


	
	
</body>
</html>