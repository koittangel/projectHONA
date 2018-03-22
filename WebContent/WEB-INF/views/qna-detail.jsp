<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>문의글 보기</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		
		<div id="container">
			<h1>문의글 보기</h1>
			<dl>
				<dt>번호</dt><dd>${ qna.qnaNo }</dd>
				<dt>상품</dt><dd>${ qna.product.productNo }</dd>
				<dt>작성자</dt><dd>${ qna.user.userName }(${ qna.user.id })</dd>
				<dt>작성일</dt><dd>${ qna.regDate }</dd>
				<dt>제목</dt><dd>${ qna.qnaTitle }</dd>
				<dt>내용</dt><dd>${ qna.qnaContent }</dd>
				<c:if test="${ !empty filename }">
					<dt>첨부파일</dt>
					<dd><a href="<c:url value='/download.do?filename=${ qna.qnaAttachment }'/>">${ filename }</a></dd>
				</c:if>
				<c:if test="${ !empty imgPath }">
					<img src="${ imgPath }" alt="이미지 파일 출력위치">
				</c:if>
			</dl>
			<a href="<c:url value='/qna/qna-list.do'/>">문의게시판으로 이동</a>
			<a href="<c:url value='/qna/qna-modify.do?qna_no=${ qna.qnaNo }'/>">수정</a>
			<a href="<c:url value='/qna/qna-remove.do?qna_no=${ qna.qnaNo }'/>">삭제</a>
		</div>
	</div>
</body>
</html>