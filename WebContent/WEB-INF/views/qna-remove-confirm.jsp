<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
			<p> ${ qnaNo }번 글을 삭제하시겠습니까?</p>
			
			<form action="<c:url value='/qna/qna-remove.do'/>" method="post">
				<input type="hidden" name="qnaNo" value="${ qnaNo }">
				<input type="submit" value="삭제">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
			<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록으로 이동</a>
		</div>
	</div>
</body>
</html>