<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>제품 삭제 확인화면</title></head>
<body>
	<h1>제품 삭제</h1>
	<p>정말로 ${ productNo }번 제품을 삭제하시겠습니까?</p>
	
	<form action="<c:url value='/product/product-remove.do'/>" method="post">
		<input type="hidden" name="product_no" value="${ productNo }">
		<input type="submit" value="삭제하기">
	</form>
	<a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a>
</body>
</html>