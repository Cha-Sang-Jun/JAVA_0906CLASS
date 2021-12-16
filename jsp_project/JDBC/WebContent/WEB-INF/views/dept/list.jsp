<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title> 부서관리 프로그램 </title>
<link rel = "stylesheet" href = "${pageContext.request.contextPath}/css/default.css">
<style>
	#content {
		padding : 20px;
	}
	
	#content>hr{
		border : 0px;
		border-top: 1px solid #aaa;
		margin : 10px 0;
	}
	
	#content>table{
		border: 0px;
		border-collapse : collapse;
		
		width : 700px;
	}
	
	#content>table td, #content>table th {
		border : 1px solid #aaa;
		text-align : center;
	}
	
</style>

<script>

	function deleteDept(deptno){
		
		if(confirm('삭제하시겠습니까?')){
		// 삭제 처리할 수 있는 URL로 이동
		// http://localhost:8080/JDBC/dept/delete.do?deptno=?
		alert(deptno + "삭제");
		location.href = '${pageContext.request.contextPath}/dept/delete.do?deptno='+deptno;
		
	 }
 }

</script>

</head>
<body>

	<%@ include file = "/WEB-INF/views/frame/header.jsp" %>

	<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>
	
	<div id = "content">
	
		<h3> 부서리스트 </h3>
		<hr>
		
		<table border=1>
			<tr>
				<th> 부서번호 </th>	
				<th> 부서이름 </th>	
				<th> 부서위치 </th>	
				<th> 관리 </th>			
			</tr>
			
			<c:if test = "${not empty deptList}">  <!-- deptList 요소가 null 일 때 -->
			
			<c:forEach items = "${deptList}" var = "dept">
			<tr>
				<td>${dept.deptno}</td>
				<td>${dept.dname}</td>
				<td>${dept.loc}</td>
				<td>
					<a href = "${pageContext.request.contextPath}/dept/edit.do?deptno=${dept.deptno}"> 수정 </a> 
						| 
					<a href = "javascript:deleteDept(${dept.deptno})"> 삭제 </a> </td>
			</tr>
			</c:forEach>
			</c:if>
			
			<c:if test = "${not empty deptList}">
			<tr>
				<td colspan = "4">등록된 부서정보가 없습니다.</td>
			</tr>
			</c:if>
		</table>
	</div>
	
</body>
</html>