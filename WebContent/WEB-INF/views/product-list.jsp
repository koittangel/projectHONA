<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table border="1">
		<tr>
			<th>제품번호</th>
			<th>제품이름</th>
			<th>제품가격</th>
			<th>제품이미지</th>
		</tr>
		<c:forEach items="${ list }" var="product">
			<tr>
				<td>${ product.productNo }</td>
				<td><a
					href="<c:url value='/product/product-detail.do?product_no=${ product.productNo }'/>">${ product.productName }</a></td>
				<td>${ product.price }</td>
				<td>
					<c:if test="${ !empty imgPaths }">
					<img src="${ imgPaths }" width="200" height="200">
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>