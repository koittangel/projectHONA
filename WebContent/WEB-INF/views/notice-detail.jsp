<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
				<div class="board">
					<ul>
						<li class="titlee">${ notice.noticeTitle }</li>
						<li class="content">${ notice.noticeContent }</li>
					</ul>
				</div>
				<sec:authorize access="hasRole('ADMIN')">
					<a
						href="<c:url value='/notice/notice-modify.do?notice_no=${ notice.noticeNo }'/>">수정</a>
					<a
						href="<c:url value='/notice/notice-remove.do?notice_no=${ notice.noticeNo }'/>">삭제</a>
					<br>
				</sec:authorize>
				<a href="<c:url value='/notice/notice-list.do'/>">공지글 목록으로 이동</a>
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