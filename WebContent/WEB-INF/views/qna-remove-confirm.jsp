<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>문의글 삭제 확인</title></head>
<body>
	<h1>문의글 삭제</h1>
	<p> ${ qnaNo }번 글을 삭제하시겠습니까?</p>
	
	<form action="<c:url value='/qna/qna-remove.do'/>" method="post">
		<input type="hidden" name="qnaNo" value="${ qnaNo }">
		<input type="submit" value="삭제">
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
	<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록으로 이동</a>
</body>
</html>