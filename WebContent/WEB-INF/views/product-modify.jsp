<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>제품 수정 화면</title>
</head>
<body>
	<h1>제품 수정</h1>
	<form action="<c:url value='/product/product-modify.do'/>" method="post" enctype="multipart/form-data">
		<div>제품번호: ${ product.productNo }</div>
		<div>
			<label>제품 타입<input type="text" name="productType" value="${ product.productType }"></label>
		</div>
		<div>
			<label>제품 이름<input type="text" name="productName" value="${ product.productName }"></label>
		</div>
		<div>
			<label>가격<input type="number" name="price" value="${ product.price }"></label>
		</div>
		<div>
			<label>재고<input type="number" name="inventory" value="${ product.inventory }"></label>
		</div>
		<div>
			<label>제품 설명</label>
			<textarea name="explaination">${ product.explaination }</textarea>
		</div>
		<div>
			<label>제품 사진<input type="file" name="attachment"></label>
		</div>
		<input type="hidden" name="productNo" value="${ product.productNo }">
		<input type="submit" value="제품 수정"><br>
		<a href="<c:url value='/product/product-list.do'/>">product list</a>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
</body>
</html>