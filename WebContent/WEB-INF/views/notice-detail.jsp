<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
		
				<dl>
					<dt>번호</dt><dd>${ notice.noticeNo }</dd>
					<dt>작성일</dt><dd>${ notice.regDate }</dd>
					<dt>제목</dt><dd>${ notice.noticeTitle }</dd>
					<dt>내용</dt><dd>${ notice.noticeContent }</dd>
				</dl>
				
			<sec:authorize access="hasRole('ADMIN')">
				<a href="<c:url value='/notice/notice-modify.do?notice_no=${ notice.noticeNo }'/>">수정</a>
				<a href="<c:url value='/notice/notice-remove.do?notice_no=${ notice.noticeNo }'/>">삭제</a><br>
			</sec:authorize>	
			<a href="<c:url value='/notice/notice-list.do'/>">공지글 목록으로 이동</a>
		</div>
	</div>
</body>
</html>