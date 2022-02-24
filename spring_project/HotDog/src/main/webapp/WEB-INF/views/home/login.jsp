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
	<div class="container">
		<div id="loginByEmail">이메일로 로그인</div>
		<form class="form-signin" method="post" id="loginForm" action="login">
	       
	       <label for="inputEmail" class="sr-only">Email address</label>
	       <input type="email" id="email" name="email" class="form-control" placeholder="email을 입력해주세요." required autofocus>
	       
	       <label for="inputPassword" class="sr-only">Password</label>
	       <input type="password" id="password" name="password" class="form-control" placeholder="password를 입력해주세요." required>
	       
	       <div class="checkbox">
		        <label>
					<input type="checkbox" name="saveEmail"><span>로그인 상태 유지</span> 
		        </label>
	        </div>
	    	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	    </form>
		<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=43759419ecbf05fbee7b1064e2ea3094&redirect_uri=http://localhost:8080/hgs/oauth/kakao">카카오 계정으로 로그인</a><br>
		<a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=5aNOGrdJbdtyJSOIZFn3&state=STATE_STRING&redirect_uri=http://localhost:8080/hgs/oauth/naver">네이버 계정으로 로그인</a><br>
	
		<div>
			<span>아이디 찾기</span> | <span>비밀번호 찾기</span>
		</div>
		<div>아직 회원이 아니신가요?<a href="joinType">회원가입하기</a></div>
   </div> <!-- /container -->
	
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
