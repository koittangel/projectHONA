<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>제품 등록 화면</title>
</head>
<body>
	<h1>제품 등록</h1>
	<form action="<c:url value='/product/product-add.do'/>" method="post" enctype="multipart/form-data">
		<div>
			<span>제품 타입<input type="text" name="productType"></span>
		</div>
		<div>
			<span>제품 이름<input type="text" name="productName"></span>
		</div>
		<div>
			<span>가격<input type="number" name="price"></span>
		</div>
		<div>
			<span>재고<input type="number" name="inventory"></span>
		</div>
		<div>
			<label>제품 설명</label>
			<textarea name="explaination"></textarea>
		</div>
		<div>
			<label>제품 사진</label>
			<input multiple="multiple" type="file" name="attachment">

		</div>
		<input type="submit" value="제품 등록"><br>
		<a href="<c:url value='/index.do'/>">MAIN</a>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
</body>
</html>