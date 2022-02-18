<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>핫핫!! 핫한 개들의 수다</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp" %>

	<style>
		#loginForm {
			display : none;
		}
	</style>
</head>
<body>
	<div id="loginByEmail">이메일로 로그인</div>
	<form method="post" id="loginForm" action="login">
		<input type="text" id="email" name="email"  placeholder="email을 입력해주세요." ><br>
		<input type="password" id="password" name="password"  placeholder="password를 입력해주세요." ><br>
		<input type="checkbox" name="saveEmail"><span>로그인 상태 유지</span> 
		<input type="submit" value="Login">
	</form>
	<div>네이버 로그인</div>
	<div>구글 로그인</div>
	<div>카카오톡 로그인</div>
	<div>
		<span>아이디 찾기</span> | <span>비밀번호 찾기</span>
	</div>
	<div>아직 회원이 아니신가요?<a href="joinType">회원가입하기</a></div>

</body>
<script>

	// 이메일로 로그인을 클릭시, 폼을 보여주거나 없앤다
	$("#loginByEmail").on("click",function(){
		$("#loginForm").css("display",function(){
			return $("#loginForm").css("display") === "none" ? "block" : "none";
		})
	});
	
// 	$("#loginForm").on("submit",function(event){
// 		event.preventDefault();	// 새로고침 방지
// 	})
	
		
	
</script>
</html>
