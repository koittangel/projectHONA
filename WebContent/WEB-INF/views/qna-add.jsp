<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>문의글 작성</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
			<h1>문의글 작성</h1>
			<form action="<c:url value='/qna/qna-add.do'/>" method="post" enctype="multipart/form-data">
				<div>
					<span>작성자: </span>
					<span>${ user.userName }(${ user.id })</span>
				</div>
				<div>
					<label>제목<input type="text" name="qnaTitle"></label>
				</div>
				<div>
					<label>내용</label>
					<textarea name="qnaContent"></textarea>
				</div>
				<div>
					<label>첨부파일 <input multiple="multiple" type="file" name="qnaAttachment"></label>
				</div>
				<input type="submit" value="등록">
				<input type="reset" value="입력한 내용 지우기">
				<a href="<c:url value='/qna/qna-list.do'/>">문의게시판으로 이동</a>
				<input type="hidden" name="userNo" value="${ user.userNo }">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>	
	</div>
</body>
</html>