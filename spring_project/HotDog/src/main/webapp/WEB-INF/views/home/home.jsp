<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Weather</title>
	<%@ include file="/WEB-INF/views/frame/pageSet.jsp"%>
</head>

<body>
	<nav class="nav">
	
		<div class="nav_logoAndSearch">
			<div>로그 넣는 곳</div>
			<div>
				<form method="get" action=>
					<input type="text" id="allSearch" name="allSearch" placeholder="원하시는 내용은 무엇인가요~?">				
					<button type="submit">서치이미지 넣을 것</button>
				</form>
			</div>
		</div>
		
		<div class="nav_container">
			<div>
				<a href="#">커뮤니티</a>
			</div>
			<div>
				<a href="#">이벤트</a>
			</div>
			<div>
				<a href="place/list">추천장소</a>
			</div>
		</div>
		
		<div class="nav_user-container">
			<div>로그인 유저정보 넣기</div>
			<div>마이페이지</div>
			<div>로그아웃</div>
		</div>
	</nav>
	
	<hr>
	
	<div class="weather">
	    <h1>Weather API</h1>
	    <h2> 날씨 정보</h2>
	    <div class="cicon"> </div>
	    <div class="local"> 현재 위치 : </div>
	    <div class="ctemp">현재 온도 : </div>
<!-- 	    <div class="clowtemp">최저 온도 : </div> -->
<!-- 	    <div class="chightemp">최고 온도 : </div> -->
	    <div class="recomm"> </div>
	</div>
	<div>
		<div></div>
	
	</div>
</body>

<script>

	// $API_KEY = "f25a266c07e9c4b842b6386b1068e10a";
	
	const COORDS = "coords";
	
	function getWeather(lat, lon) {
	    fetch("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=f25a266c07e9c4b842b6386b1068e10a&units=metric")
	        .then(res => res.json())
	        .then(data => {
	            console.log(data);
	            const now = new Date($.now());
	            const temp = data.main.temp;
	            const minTemp = data.main.temp_min;
	            const maxTemp = data.main.temp_max;
	            const wIcon = data.weather[0].icon;
	            const date = now.getFullYear() + '/' + (now.getMonth() + 1) + '/' + now.getDate() + '/' + now.getHours() + ' ';
	            const weathers = data.weather[data.weather.length - 1];
	            const city = data.name;
	            const description = weathers.main;
	            
	            // console.log(data.weather[0].main);
	            // console.log(weathers.main);
	
	            $('.local').append(city);
	            // $('.clowtemp').append(minTemp);
	            $('.ctemp').append(temp);
	            // $('.chightemp').append(maxTemp);
	            $('h2').prepend(date);
	            $('.cicon').append('<img src="http://openweathermap.org/img/w/' + wIcon + '.png" />')
	            
	            if(description == "Clear" || description == "Clouds") {
	                $('.recomm').append("산책하기에 좋은 날씨에요");
	            } else {
	                $('.recomm').append("산책하기엔 안좋은 날씨에요");
	            }
	
	        });
	}
	
	function saveCoords(coordsObj) {
	    localStorage.setItem(COORDS, JSON.stringify(coordsObj));
	}
	
	function handleGeoSucc(pos) {
	    const latitude = pos.coords.latitude;
	    const longitude = pos.coords.longitude;
	    const coordsObj = {
	        latitude,
	        longitude
	    };
	    
	    saveCoords(coordsObj);
	    getWeather(latitude, longitude);
	}
	
	function handleGeoErr(err) {
	    console.log("에러! : 위치정보를 확인할 수 없습니다" + err)
	}
	
	function requestCoords() {
	    navigator.geolocation.getCurrentPosition(handleGeoSucc, handleGeoErr);
	}
	
	function loadCoords() {
	    const loadedCoords = localStorage.getItem(COORDS);
	    if (loadedCoords == null) {
	        requestCoords();
	    } else {
	        const parseCoords = JSON.parse(loadedCoords);
	        getWeather(parseCoords.latitude, parseCoords.longitude);
	    }
	}
	
	function init() {
	    loadCoords();
	}
	
	init();
</script>
</html>