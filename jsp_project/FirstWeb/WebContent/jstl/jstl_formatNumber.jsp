<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="number" value="100000" />
	
	<p>
		<fmt:formatNumber value="100000" />
		<br>
		<fmt:formatNumber value="${number}" />
		<br>
		<fmt:formatNumber value="${number}" groupingUsed="false" /> <!-- 숫자 단위 구분자 표시 안함. -->
		<br>
	    <fmt:formatNumber value="${number}" var = "num" />  <!-- 변수로 처리 : 바로 출력되지 않음. -->
		
		숫자 : ${num} <br>
		퍼센트 : <fmt:formatNumber value = "${number/400000000}" type = "percent" /> <br>
		통화 : <fmt:formatNumber value = "${number}" type = "currency" currencySymbol = "\\" /> <br>
		
		패턴 : <fmt:formatNumber value = "${number*100}" pattern = "000,000.00" /> <!-- 자릿수는 DB에서 설정하고 오는것이 조금 더 편할 수 있다. -->

	</p>
</body>
</html>