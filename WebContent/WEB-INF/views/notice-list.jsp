<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A</title>
	<link rel="stylesheet" href="<c:url value='/css/table-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
		<div><img src="<c:url value='/img/notice.jpg'/>" /></div>
			<table>
				<thead>
					<tr>
						<th style="width:10%;">번호</th>
						<th style="width:40%;">제목</th>
						<th style="width:20%;">작성자</th>
						<th style="width:20%;">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="notice">
						<tr>
							<td>${ notice.noticeNo }</td>
							<td><a href="<c:url value='/notice/notice-detail.do?notice_no=${ notice.noticeNo }'/>">${ notice.noticeTitle }</a></td>
							<td>관리자</td>
							<td><fmt:formatDate value="${notice.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<sec:authorize access="hasRole('ADMIN')">
				<a href="<c:url value='/notice/notice-add.do'/>">공지 등록</a><br>
			</sec:authorize>
		</div>
	</div>
</body>
</html>