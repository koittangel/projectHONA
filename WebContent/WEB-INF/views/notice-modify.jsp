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
		</div>
	</div>
</body>
</html>