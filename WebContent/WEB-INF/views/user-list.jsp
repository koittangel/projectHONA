<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>H O N A 회원목록</title>
<link rel="stylesheet" href="<c:url value='/css/table-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<h6>관리자용 페이지 입니다.</h6>

				<table>
					<thead>
					<tr>
						<th>회원 No</th>
						<th>회원 ID</th>
						<th>회원 이름</th>
						<th>회원 주소</th>
						<th>회원 전화번호</th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${ list }" var="user">
							<tr>
								<td>${ user.userNo }</td>
								<td>${ user.id }</td>
								<td>${ user.userName }</td>
								<td>${ user.address }</td>
								<td>${ user.phone }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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