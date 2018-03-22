<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>주문 확인 페이지</title>
</head>
<body>
	<h1>주문 확인 페이지</h1>
	<form action="<c:url value='/kakao-pay/ready.do'/> " method="post">
		<div>상품번호: ${ product.productNo }</div>
		<div>상품이름: ${ product.productName }</div>
		<div>상품가격: ${ product.price }</div>
		<div>수량: ${ ea }</div>
		<div>총가격: ${ totalPrice }</div>
		<div>주문자이름: ${ user.userName }</div>
		<div>주소: ${ user.address }</div>
		<div>연락처: ${ user.phone }</div>
		<input type="hidden" name="productNo" value="${ product.productNo } ">
		<input type="hidden" name="ea" value="${ ea } ">
		<input type="hidden" name="productName" value="${ product.productName } ">
		<input type="hidden" name="totalPrice" value="${ totalPrice } ">
		<input type="hidden" name="userName" value="${ user.userName } ">
		<input type="submit" value="결제하기"><br>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>

</body>
</html>