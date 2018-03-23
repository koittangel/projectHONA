<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>TOP</title>
<link rel="stylesheet" href="<c:url value='/css/product-list-css.css'/>">
</head>
<body>

	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="../index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<h1>${ productType }</h1>
				<c:forEach var="item" items="${ typeList }" varStatus="status">
					<a
						href="<c:url value='/product/product-detail.do?product_no=${ item.productNo }'/>"
						class="img-align"> <img src="${ imgPaths[status.index] }"
						width="220" height="300">
					</a>
				</c:forEach>
			</div>
			<div id="footer">
				<span>COMPANY - L&K . CEO CP0 - HONA <br> ADDRESS - 서울시 금천구
					BUSINESS LICENSE : 105-13-44550 <br> ONLINE BUSINESS LICENSE :
					2018-서울금천-0315<br> COPYRIGHT (C) HONA<br>
				</span>
			</div>
		</div>
	</div>
</body>
</html>