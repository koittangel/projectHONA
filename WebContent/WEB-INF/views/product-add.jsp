<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>제품 등록 화면</title>
<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<h1>제품 등록</h1>
				<form action="<c:url value='/product/product-add.do'/>"
					method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>제품 타입</td>
							<td><select name="productType">
									<option value="">제품 타입</option>
									<option value="TOP">TOP</option>
									<option value="BOTTOM">BOTTOM</option>
									<option value="SHOES">SHOES</option>
									<option value="BAG">BAG</option>
									<option value="JEWELRY">JEWELRY</option>
							</select></td>
						</tr>
						<tr>
							<td>제품 이름</td>
							<td><input type="text" name="productName">
							<td>
						</tr>
						<tr>
							<td>가격</td>
							<td><input type="number" name="price"></td>
						</tr>
						<tr>
							<td>재고</td>
							<td><input type="number" name="inventory"></td>
						</tr>
						<tr>
							<td>제품설명</td>
							<td><textarea name="explaination"></textarea></td>
						</tr>
						<tr>
							<td>제품사진</td>
							<td><input multiple="multiple" type="file" name="attachment"></td>
						</tr>
					</table>

					<input type="submit" value="제품 등록"><br> <input
						type="hidden" name="${ _csrf.parameterName }"
						value="${ _csrf.token }">
				</form>
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