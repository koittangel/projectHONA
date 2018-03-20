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
		<c:forEach var="item" items="${ list }" varStatus="status">
			<tr>
				<td>${ item.productNo }</td>
				<td><a
					href="<c:url value='/product/product-detail.do?product_no=${ item.productNo }'/>">${ item.productName }</a></td>
				<td>${ item.price }</td>
				<td>
					<img src="${ imgPaths[status.index] }" width="200" height="200">
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>