<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>TOP</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>

<div id="wrap">
	<div id="leftMenu">
		<jsp:include page="../index.jsp" flush="false"/>
	</div>
	<div id="container">
		<h1>TOP</h1>
		<c:forEach var="item" items="${ list }" varStatus="status">
			<a href=
				"<c:url value='/product/product-detail.do?product_no=${ item.productNo }'/>"
						class="img-align">
				<img src="${ imgPaths[status.index] }" width="200" height="200">
			</a>
		</c:forEach>
	</div>
</div>
	
</body>
</html>