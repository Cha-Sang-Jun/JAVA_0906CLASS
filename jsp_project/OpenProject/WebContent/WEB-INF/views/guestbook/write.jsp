<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result < 1}">
<script>
	alert('글 등록에 실패하였습니다.');
	history.go(-1);
</script>
</c:if>
<c:if test="${result eq 1}">
<script>
	alert('게시글 작성 완료!');
	location.href = '${pageContext.request.contextPath}/guestbook/list.do';
</script>
</c:if>
    