<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b831cb9231e82dc116c15d613033258a&libraries=services"></script>
<title>Insert title here</title>
<style>
.rating .rate_radio {
	width: 30px;
	height: 30px;
	background-color: #fff;
	cursor: pointer;
	display: none;
}

.rating .rate_radio + label {
    display: inline-block;
    width: 30px;
    height: 30px;
    background-image: url('../images/starrate.png');
    background-repeat: no-repeat;
    background-size: 30px 30px;
    cursor: pointer;
    background-color: #F0F0F0;
}
.rating .rate_radio:checked + label {
    background-color: #FFBB00;
}
</style>

</head>
<body>

	<!-- 해더 시작 -->

	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->

	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->

	<table class="table">
		<tr>
			<td>${pageView.fileName}</td>
		</tr>
		<tr>
			<td>장소명</td>
			<td>${pageView.title}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${pageView.oldAddress}</td>
		</tr>
		<tr>
			<td>신주소</td>
			<td>${pageView.newAddress}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${pageView.phone}</td>
		</tr>
		<tr>
			<td>지역</td>
			<td>${pageView.affiliation}</td>
		</tr>
		<tr>
			<td>홈페이지</td>
			<td><a href="${pageView.homepage}" target="_blank">${pageView.homepage}</a></td>
			
		</tr>
		
	</table>
	
	<!-- 지도 보기 영역 -->
	<div id="map" style="width:100%;height:350px;"></div>
		<!-- 후기 리스트 -->
		<div id="relplyList">
			<h3>후기</h3>
			<c:if test="${empty replyList}">
				<tr>
					<td><h3>등록된 후기가 없습니다.</h3></td>
				</tr>
			</c:if>
		
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
				
				<div id="reply">
				
					<p>
						${reply.content}
					</p>
					
					<div onclick="deleteReply($replys.placeReplyIdx)">X</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	
	<!-- 후기 작성 영역-->
	<div class="col-md-8">
		
		<form id="replyWriteForm" class="text-right" method="POST">
			
			<div class="replyRating">
				<div class="rating">
					<input type="checkbox" name="rating" id="rating1" value="1" class="rate_radio" title="1점">
                <label for="rating1"></label>
                <input type="checkbox" name="rating" id="rating2" value="2" class="rate_radio" title="2점">
                <label for="rating2"></label>
                <input type="checkbox" name="rating" id="rating3" value="3" class="rate_radio" title="3점" >
                <label for="rating3"></label>
                <input type="checkbox" name="rating" id="rating4" value="4" class="rate_radio" title="4점">
                <label for="rating4"></label>
                <input type="checkbox" name="rating" id="rating5" value="5" class="rate_radio" title="5점">
                <label for="rating5"></label>
				</div>
			</div>
			<textarea name="content" id="content" rows="5" cols="70%" required>
			</textarea>
			
			<input type="hidden" name="PlaceIdx" value="${pageView.placeIdx}">
				
			<br> 
			
			<input type="submit" value="작성" >
		</form>
	</div>
	 
	
	<a href="list">목록으로</a>
	
	<script>
		var mapContainer = document.getElementById('map'); // 지도를 표시할 div 
    	
		mapOption = {
	        'center': new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        'level': 3 // 지도의 확대 레벨
	    };  

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
	
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
	
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${pageView.oldAddress}', function(result, status) {
	
		    // 정상적으로 검색이 완료됐으면 
	    	if (status === kakao.maps.services.Status.OK) {
	
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
	      		});
	
	        	// 인포윈도우로 장소에 대한 설명을 표시합니다
	        	var infowindow = new kakao.maps.InfoWindow({
	         	   content: '<div style="width:150px;text-align:center;padding:6px 0;">${pageView.title}</div>'
	        	});
	        	
	        	infowindow.open(map, marker);
	
	        	// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        	map.setCenter(coords);
	    	} 
		});    
	console.log($('#replyWriteForm'))
	$('#replyWriteForm').submit(function() {

		replyWriteForm
		
	});
		
</script>
	
	
</body>
</html>