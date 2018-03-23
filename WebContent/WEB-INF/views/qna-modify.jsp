<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<form action="<c:url value='/qna/qna-modify.do'/>" method="post" enctype="multipart/form-data">
				<div>번호: ${ qna.qnaNo }</div>
				<div>상품: ${ qna.productNo }</div>
				<div>작성자: ${ qna.user.userName }(${ qna.user.id })</div>
				<div>
					<label>제목<input type="text" name="qnaTitle" value="${ qna.qnaTitle }"></label>
				</div>
				<div>
					<label>내용</label>
					<textarea name="qnaContent">${ qna.qnaContent }</textarea>
				</div>
				<div>
					<div>첨부파일<input type="file" name="qnaAttachment"></div>
				</div>
				<input type="hidden" name="qnaNo" value="${ qna.qnaNo }">
				<input type="hidden" name="productNo" value="${ qna.productNo }">
				<input type="submit" value="수정">
				<input type="reset" value="입력한 내용 지우기">
				<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록으로 이동</a>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>

</body>
</html>