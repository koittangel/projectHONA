<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>제품 상세 정보</title>
</head>
<body>
	<h1>제품 상세정보</h1>
	<dl>
		<dt>제품번호</dt><dd>${ product.productNo }</dd>
		<dt>제품타입</dt><dd>${ product.productType }</dd>
		<dt>제품이름</dt><dd>${ product.productName }</dd>
		<dt>가격</dt><dd>${ product.price }</dd>
		<dt>개수</dt><dd>${ product.EA }</dd>
		<dt>재고</dt><dd>${ product.inventory }</dd>
		<dt>제품설명</dt><dd>${ product.explaination }</dd>
		<dt>제품사진</dt><dd>${ product.attachment }</dd>
	</dl>
	<a href="<c:url value='/product/product-modify.do?product_no=${ product.productNo }'/>">수정</a>
	<a href="<c:url value='/product/product-remove.do?product_no=${ product.productNo }'/>">삭제</a><br>
	<a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a>
	
</body>
</html>