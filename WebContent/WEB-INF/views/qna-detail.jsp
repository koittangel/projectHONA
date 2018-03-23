<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
		<div class="board">		
			<ul>
				<li class="writer">${ qna.user.userName }(${ qna.user.id })</li>
				<li class="writer">${ qna.regDate }</li>
				<li class="titlee">${ qna.qnaTitle }</li>
				<li class="content">${ qna.qnaContent }</li>
				<c:if test="${ !empty filename }">
					<dt>첨부파일</dt>
					<li><a href="<c:url value='/download.do?filename=${ qna.qnaAttachment }'/>">${ filename }</a></li>
				</c:if>
				<c:if test="${ !empty imgPath }">
					<img src="${ imgPath }" alt="이미지 파일 출력위치">
				</c:if>
			</ul>
			</div>
			<a href="<c:url value='/qna/qna-list.do'/>">문의게시판으로 이동</a>
			<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
				<a href="<c:url value='/qna/qna-modify.do?qna_no=${ qna.qnaNo }'/>">수정</a>
				
			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN')">
				<a href="<c:url value='/qna/qna-remove.do?qna_no=${ qna.qnaNo }'/>">삭제</a><br>
			</sec:authorize>
		</div>
</div>
</body>
</html>