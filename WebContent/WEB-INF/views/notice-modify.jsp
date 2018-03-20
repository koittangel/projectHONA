<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>공지글 수정</title></head>
<body>
	<h1>공지글 수정</h1>
	<form action="notice-modify.do" method="post">
		<div>번호: ${ notice.noticeNo }</div>
		<div>
			<label>제목<input type="text" name="noticeTitle" value="${ notice.noticeTitle }"></label>
		</div>
		<div>
			<label>내용</label>
			<textarea name="noticeContent">${ notice.noticeContent }</textarea>
		</div>
		<input type="hidden" name="noticeNo" value="${ notice.noticeNo }">
		<input type="submit" value="수정">
		<input type="reset" value="입력한 내용 지우기">
		<a href="notice-list.do">글 목록으로 이동</a>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
</body>
</html>