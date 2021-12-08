<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	

	// 다른 페이지의 결과 데이터를 특정 페이지(객체)로 전달 할 수 있다
	// getAttribute, setAttribute
	
	// application 객체의 속성 값을 가져온다! -> Object 타입
	String strcnt = (String) application.getAttribute("cnt");

	int cnt = strcnt == null ? 0 : Integer.parseInt(strcnt);
	
	// application 객체의 속성 값 저장!
	application.setAttribute("cnt", String.valueOf(++cnt));
	// 방문자수 먼저 증가 시키고 (++cnt)
	// 객체에 넣는다.
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 방문자 수 <%= cnt %></h1>

</body>
</html>