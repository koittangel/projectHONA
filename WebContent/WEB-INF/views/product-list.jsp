<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>상품 목록</title>
</head>
<body>
	<h1>상품 목록</h1>
	<table>
		<thead>
			<tr>
				<th>제품번호</th>
				<th>제품종류</th>
				<th>제품이름</th>
				<th>제품가격</th>
				<th>주문개수</th>
				<th>제품재고</th>
				<th>제품설명</th>
				<th>제품사진</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="product">
				<tr>
					<td>${ product.productNo }</td>
					<td>${ product.productType }</td>
					<td>${ product.productName }</td>
					<td>${ product.price }</td>
					<td>${ product.EA }</td>
					<td>${ product.inventory }</td>
					<td>${ product.explaination }</td>
					<td>${ product.attachment }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>