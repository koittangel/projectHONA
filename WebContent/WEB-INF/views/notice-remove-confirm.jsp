<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>공지 삭제 확인</title></head>
<body>
	<h1>공지 삭제 확인</h1>
	<p>정말로 ${ noticeNo }번 공지를 삭제하시겠습니까?</p>
	<form action="<c:url value='/notice/notice-remove.do'/>" method="post">
		<input type="hidden" name="noticeNo" value="${ noticeNo }">
		<input type="submit" value="삭제하기">
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
	<a href="<c:url value='/notice/notice-list.do'/>">글 목록으로 이동</a>
</body>
</html>