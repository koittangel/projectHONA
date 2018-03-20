<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head><title>공지글 목록</title></head>
<body>
	<h1>공지글 목록</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="notice">
				<tr>
					<td>${ notice.noticeNo }</td>
					<td><a href="<c:url value='/notice/notice-detail.do?notice_no=${ notice.noticeNo }'/>">${ notice.noticeTitle }</a></td>
					<td>관리자</td>
					<td>${ notice.regDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<sec:authorize access="hasRole('ADMIN')">
		<a href="<c:url value='/notice/notice-add.do'/>">공지 등록</a><br>
	</sec:authorize>
	<a href="<c:url value='/index.do'/>">메인 화면</a>
</body>
</html>