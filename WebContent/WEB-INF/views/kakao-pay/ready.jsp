<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>결제준비</title>
</head>
<body>
	<h1>결제확인</h1>
	
	<form action="<c:url value='/kakao-pay/ready.do'/>" method="post">
		<label>가맹점 주문번호: ${ payment.paymentNo }</label><br>
		<label>가맹점 회원 ID: ${ user.userName }</label><br>
		<label>상품명: ${ product.productName }</label><br>
		<label>상품 수량: ${ ea }</label><br>
		<label>상품 총액: ${ payment.totalPrice }</label><br>
		<label>상품 비과세 금액: 0</label><br>
		<input type="submit" value="결제하기">
	</form>
</body>
</html>