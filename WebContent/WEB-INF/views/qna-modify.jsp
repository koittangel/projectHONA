<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>문의글 수정</title></head>
<body>
	<h1>문의글 수정</h1>
	<form action="<c:url value='/qna/qna-modify.do'/>" method="post" enctype="multipart/form-data">
		<div>번호: ${ qna.qnaNo }</div>
		<div>상품: ${ qna.productNo }</div>
		<div>작성자 번호: ${ qna.userNo }</div>
		<div>
			<label>제목<input type="text" name="title" value="${ qna.qnaTitle }"></label>
		</div>
		<div>
			<label>내용</label>
			<textarea name="content">${ qna.qnaContent }</textarea>
		</div>
		<div>
			<div>첨부파일<input type="file" name="attachment"></div>
		</div>
		<input type="hidden" name="qnaNo" value="${ qna.qnaNo }">
		<input type="hidden" name="productNo" value="${ qna.productNo }">
		<input type="submit" value="수정">
		<input type="reset" value="입력한 내용 지우기">
		<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록으로 이동</a>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>

</body>
</html>