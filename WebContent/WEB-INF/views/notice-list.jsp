<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>H O N A</title>
<link rel="stylesheet" href="<c:url value='/css/table-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<div>
					<img src="<c:url value='/img/notice.jpg'/>" />
				</div>
				<table>
					<thead>
						<tr>
							<th style="width: 10%;">번호</th>
							<th style="width: 40%;">제목</th>
							<th style="width: 20%;">작성자</th>
							<th style="width: 20%;">작성일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ list }" var="notice">
							<tr>
								<td>${ notice.noticeNo }</td>
								<td><a
									href="<c:url value='/notice/notice-detail.do?notice_no=${ notice.noticeNo }'/>">${ notice.noticeTitle }</a></td>
								<td>관리자</td>
								<td><fmt:formatDate value="${notice.regDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<sec:authorize access="hasRole('ADMIN')">
					<a href="<c:url value='/notice/notice-add.do'/>">공지 등록</a>
					<br>
				</sec:authorize>
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