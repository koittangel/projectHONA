<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>제품 삭제 확인화면</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
<div id="wrap">
	<div id="leftMenu">
	<jsp:include page="index.jsp" flush="false"/>
	</div>
	<div id="container">
		<p>정말로 ${ productNo }번 제품을 삭제하시겠습니까?</p>
		
		<form action="<c:url value='/product/product-remove.do'/>" method="post">
			<input type="hidden" name="productNo" value="${ productNo }">
			<input type="submit" value="삭제하기">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
		</form>
		<a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a>
	</div>
</div>
</body>
</html>