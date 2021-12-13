<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
/* DB에서 설정한 date값을 자바에서 받아올 때는 java.sql.Date or java.sql.Time.Stamp 
   -> fmt에서 java.util.Date로 변환시킨 후 value값에 넣어줘야한다. */
   
	request.setAttribute("now", new java.util.Date()); // 다른 servlet 페이지에서 view를 받아왔다고 가정하에
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 전체 TimeZone 바꾸기 -->
	<fmt:timeZone value = "Hongkong">
	
	<h3> ${now} </h3>
		
	<hr>
	
	<h3> 날짜 </h3>
	<fmt:formatDate value = "${now}" /> <br>
	<fmt:formatDate value = "${now}" type = "date" /> <br>  <!-- default 값이 "date" 라는 것을 알 수 있다. -->
	<fmt:formatDate value = "${now}" dateStyle = "full" /> <br>
 	<fmt:formatDate value = "${now}" dateStyle = "short" /> <br>
 	
 	<hr>
 		
 	<h3> 시간 </h3>
	<fmt:formatDate value = "${now}" type = "time" /> <br>
	<fmt:formatDate value = "${now}" type = "time" timeStyle = "full" /> <br> 
	<fmt:formatDate value = "${now}" type = "time" timeStyle = "short" /> <br>
	<fmt:formatDate value = "${now}" type = "time" timeStyle = "full" timeZone = "US"/> <br> 
	
	<hr>
	
	<h3> both </h3>
	<fmt:formatDate value = "${now}" type = "both" /> <br>
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "full" timeStyle = "full" timeZone = "USA"/> <br>
	 
	<hr>
	
	<h3> pattern </h3>
	<fmt:formatDate value = "${now}" pattern = "z a h:mm" /> <br>
	<fmt:formatDate value = "${now}" pattern = "hh:mm:ss" /> <br>
	<fmt:formatDate value = "${now}" pattern = "yyyy-MM-dd" /> <br>
	<fmt:formatDate value = "${now}" pattern = "yy.MM.dd. a hh:mm" timeZone = "London" /> <br>
	 
	</fmt:timeZone>

</body>
</html>