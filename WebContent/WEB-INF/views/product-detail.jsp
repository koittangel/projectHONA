<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>제품 상세 정보</title>
</head>
<body>
	<h1>제품 상세정보</h1>
	<table border="1">
		<tr>
			<td><c:if test="${ !empty imgPath }">
					<img src="${ imgPath }" width="200" height="200">
				</c:if></td>
			<td>
				<table border="1" style="height: 300px; width: 1000px;">
					<tr align="center">
						<td>제품이름</td>
						<td>${ product.productName }</td>
					</tr>
					<tr align="center">
						<td>가격</td>
						<td>${ product.price }</td>
					</tr>
					<tr align="center">
						<td>제품설명</td>
						<td>${ product.explaination }</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<form action="<c:url value='/kakao-pay/payment.do'/>"
								method="get">
								<select name="ea">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								</select>개 
								<input type="hidden" name="productNo" value="${ product.productNo }"> 
								<input type="submit" value="결제하기">
							</form>
						</td>
					</tr>
				</table>
			</td>
	</table>
	<sec:authorize access="hasRole('ADMIN')">
		<a
			href="<c:url value='/product/product-modify.do?product_no=${ product.productNo }'/>">수정</a>
		<a
			href="<c:url value='/product/product-remove.do?product_no=${ product.productNo }'/>">삭제</a>
		<br>
	</sec:authorize>
	<a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a>

</body>
</html>