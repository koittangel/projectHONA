<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>공지글 작성</title></head>
<body>
	<h1>공지글 작성</h1>
	<form action="<c:url value='/notice/notice-add.do'/>" method="post" enctype="multipart/form-data">
		<div>
			<label>제목<input type="text" name="noticeTitle"></label>
		</div>
		<div>
			<label>내용</label>
			<textarea name="noticeContent"></textarea>
		</div>
		<input type="submit" value="등록">
		<input type="reset" value="입력한 내용 지우기">
		<a href="<c:url value='/notice/notice-list.do'/>">공지글 목록으로 이동</a>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
</body>
</html>