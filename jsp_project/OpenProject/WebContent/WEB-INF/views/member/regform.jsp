<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>

#content>form>table td {
	padding : 5px;
}

#content>form input {
	padding : 5px;
}
</style>

</head>
<body>

	<!-- 헤더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 헤더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	<div id = "content">
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
					<td><input type="password" name = "password"></td>
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
					<td></td>
					<td><input type ="submit" value = "회원가입"> <input type ="reset"> </td>
				</tr>
			</table>
		</form>

	</div>
	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>


Statement 클래스 :
 - SQL 구문을 실행하는 역할을 하며 스스로는 SQL 구문을 이해하지 못하고(구문해석X) 전달하는 역할만 한다.
 - Statement는 기본 객체이며 텍스트로 SQL을 호출한다. PreparedStatement는 객체의 기능을 향상 시킨 것이며 인자와 관       
   련된 작업이 특화되어있다.

Connection :
 - Connection은 데이터베이스와 연결하는 객체이다.
 - DriverManager.getConnection(연결문자열, DB_ID, DB_PW) 로 Connection 객체를 생성한다.
 - DriverManager 클래스는 JDBC 드라이버를 통하여 Connection을 만드는 역할을 한다.

executeUpdate :
 - DB에서 데이터를 추가,삭제,수정하는 SQL문을 실행한다. 메서드의 반환 값은 해당 SQL 문 실행에 영향을 받는 
   행 수를 반환한다.
 
 executeQuery : 
 - DB에서 데이터를 가져와 결과 집합을 반환한다. 이 메소드는 Select문에서만 실행하는 특징이 있다.
 - 즉, ResultSet이 나오는 select에 executeQuery()를 사용하는 것이다.

Resultset :
 - executeQuery로 명령하면 ResultSet이라는 객체를 돌려준다( 명령에 대한 반환값).
 - ResultSet 타입으로 반환한 결과 값을 저장할 수 있다. 저장된 값을 한 행 단위로 불러 올 수 있다.