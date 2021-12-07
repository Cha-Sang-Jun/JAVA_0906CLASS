<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Jun`s Blog</title>
<style>

    /* 웹폰트 */
    @import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR&display=swap');

    /* 기본설정 */
 * {
    margin : 0;
    padding : 0;
    font-family: 'Noto Sans KR', sans-serif;
}

body {
    background-color: #eee;
}

.font_gray {
    color : #666;
}

.margin_tb_5 {
    margin-top : 5px;
    margin-bottom: 5px;
}

.linehight_180per{
    line-height: 180%;
}

/* 타이틀 폰트 */
.title_font {
    font-family: 'Jua', sans-serif;
}

/* main_wrap 설정 */
#main_wrap {
    background-color: white;

    width : 778px;
    /* height : 300px; */
    border : 1px solid #CCC;
    border-radius: 5px;
    
    margin : 10px auto;
    padding : 10px;

    box-shadow: 3px 3px 10px #CCC;

}

/* header 설정 */
#header {
    padding : 30px;
}

/* 네비게이션 설정 */
#nav {
    border-top : 1px solid #CCC;
    border-bottom : 1px solid #CCC;

    overflow: hidden; 

}

#nav>ul {
    float : left;
    list-style : none;
}

#nav>ul>li {
    float : left;
    padding : 5px 10px;
}

#nav>div {
    float : right;
}

/* 검색영역 */
#nav input {
    border : 1px solid #CCC;
    padding : 3px 20px;
    margin-top : 3px;
}

#nav input[type = text] {
    width : 100px;
    border-radius: 20px 0 0 20px;
}

#nav input[type = button] {
    border-radius: 0 20px 20px 0;
    border-color: palegreen;
    color: rgb(9, 139, 122);

    margin-left : -5px;
    margin-right : 5px;
}

/* Contents 영역 설정 */
#contents_wrap {
    overflow : hidden;
}

#section {
    width : 600px;
    float : left;
}

#aside{
    width : 170px;
    float : right;
}

#section>article {
    padding : 20px;

    border-bottom: 1px solid #CCC;

    /* padding-bottom : 20px;
    margin-bottom : 20px; */
}

#section>article>img {
    width : 500px;
}

/* aside 영역 설정 */
/* #contents_wrap>aside {
    padding-top: 30px;
} */

#aside>h3 {
    margin-top : 30px;
}

#side li {
    list-style : none;
    font-size: small;
    padding-left : 10px;
}

/* Footer 영역 설정 */
#footer {
    height : 50px;
    text-align: center;
    line-height: 30px;
}




</style>

</head>
<body>
	<!-- 전체 레이아웃을 감싸는 블록 : 가운데 정렬, border, shadow -->
	<div id="main_wrap">
		<!-- header 시작 -->
		<%@ include file="header.jsp"%>
		<!-- header 종료 -->
		<!-- 네비게이션 시작 -->
		<%@ include file="nav.jsp"%>
		<!-- 네비게이션 종료 -->

		<!-- Contents 영역 시작 -->
		<div id="contents_wrap">

			<!-- 게시물 영역 시작 -->
			<%@ include file="section.jsp"%>
			<!-- 게시물 영역 종료 -->

			<!-- asdie 시작 -->
			<%@ include file="aside.jsp"%>
			<!-- aside 종료 -->

		</div>
		<!-- Contents 영역 종료 -->

		<!-- footer 영역 시작 -->
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		<!-- footer 영역 종료 -->

	</div>

</body>


</html>