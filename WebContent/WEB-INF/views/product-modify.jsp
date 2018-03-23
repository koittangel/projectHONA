<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A</title>
		<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
			<form action="<c:url value='/product/product-modify.do'/>" method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<td>제품번호: </td>
						<td>${ product.productNo }</td>
					</tr>
					<tr>
						<td>PASSWORD :</td>
						<td><input type="password" name="password"><td>
					</tr>
					<tr>
						<td>제품 타입 :  </td>
						<td><input type="text" name="productType" value="${ product.productType }"></td>
					</tr>
					<tr>
						<td>제품 이름 : </td>
						<td><input type="text" name="productName" value="${ product.productName }"></td>
					</tr>
					<tr>
						<td>가격 : </td>
						<td><input type="number" name="price" value="${ product.price }"></td>
					</tr>
					<tr>
						<td>재고 : </td>
						<td><input type="number" name="inventory" value="${ product.inventory }"></td>
					</tr>
					<tr>
						<td>제품 설명 : </td>
						<td><textarea name="explaination">${ product.explaination }</textarea></td>
					</tr>
					<tr>
						<td>제품 사진 : </td>
						<td><input type="file" name="attachment"></td>
					</tr>
				</table>

				<input type="hidden" name="productNo" value="${ product.productNo }">
				<input type="submit" value="제품 수정"><br>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>