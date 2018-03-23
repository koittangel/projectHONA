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
		<div id ="container">
			<h1>공지글 작성</h1>
			<form action="<c:url value='/notice/notice-add.do'/>" method="post">
		
				<table>
					<tr>
						<td>제목</td>
						<td><input type="text" name="noticeTitle"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="noticeContent"></textarea></td>
					</tr>
				</table>
				
				<input type="submit" value="등록">
				<input type="reset" value="입력한 내용 지우기">
				<a href="<c:url value='/notice/notice-list.do'/>">공지글 목록으로 이동</a>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>