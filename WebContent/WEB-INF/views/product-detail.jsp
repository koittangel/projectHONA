<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>H O N A</title>
<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<td><c:if test="${ !empty imgPath }">
								<img src="${ imgPath }">
							</c:if></td>
						<td>
							<table style="height: 300px; width: 500px;">
								<tr>
									<td align="center" width="100px">제품이름</td>
									<td>${ product.productName }</td>
								</tr>
								<tr>
									<td align="center">가격</td>
									<td>${ product.price }</td>
								</tr>
								<tr>
									<td align="center">제품설명</td>
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
											</select>개 <input type="hidden" name="productNo"
												value="${ product.productNo }"> <input type="submit"
												value="결제하기">
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
			</div>
			<div id="footer">
				<span>COMPANY - L&K . CEO CP0 - HONA <br> ADDRESS - 서울시
					금천구 BUSINESS LICENSE : 105-13-44550 <br> ONLINE BUSINESS
					LICENSE : 2018-서울금천-0315<br> COPYRIGHT (C) HONA<br>
				</span>
			</div>
		</div>
	</div>
</body>
</html>