<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>


<style>
#oldfile {
	height: 100px;
}
</style>


</head>
<body>

	<!-- 해더 시작 -->
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->


	<main role="main" class="container">

		<div class="my-3 p-3 bg-white rounded shadow-sm ">
			<h3>회원 수정</h3>
			<hr>
			<!-- form 경로와 처리 경로가 동일 -> method 로 구분 -->
			<!-- action="reg.do" 생략 가능 -->
			<form method="post" enctype="multipart/form-data">

				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">이메일</label>
					<div class="col-sm-10">
						<input type="hidden" name="memberIdx" value="${member.memberIdx}">
						<input type="email" name="email" id="email"
							value="${member.email}" class="form-control" readonly>
					</div>
				</div>

				<div class="form-group row">
					<label for="petNumber" class="col-sm-2 col-form-label">펫넘버</label>
					<div class="col-sm-10">
						<input type="text" name="petNumber" id="petNumber"
							value="${member.petNumber}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="name" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" name="name" id="name" value="${member.name}"
							class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="address" class="col-sm-2 col-form-label">주소</label>
					<div class="col-sm-10">
						<input type="text" name="address" id="address"
							value="${member.address}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="neutering" class="col-sm-2 col-form-label">중성화
						여부</label>
					<div class="col-sm-10">
						<input type="text" name="neutering" id="neutering"
							value="${member.neutering}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="profile" class="col-sm-2 col-form-label">현재 사진</label>
					<div class="col-sm-10">
						<c:if test="${not empty member.profile}">
							<img id="oldfile"
								src="${pageContext.request.contextPath}/uploadfile/${member.profile}">
							<br>
						</c:if>

						<input type="hidden" name="oldfile" value="${member.profile}">

					</div>
				</div>

				<div class="form-group row">
					<label for="profile" class="col-sm-2 col-form-label">사진</label>
					<div class="col-sm-10">
						<input type="file" name="profile" id="profile"
							class="form-control-plaintext">
					</div>
				</div>

				<input type="submit" value="정보수정" class="btn  btn-primary">
				<input type="reset" class="btn btn-secondary">


			</form>
		</div>

	</main>


	<!-- content 끝 -->


	<!-- Javascript 추가 -->

</body>
</html>