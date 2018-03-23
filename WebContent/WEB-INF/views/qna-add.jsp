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

			<form action="<c:url value='/qna/qna-add.do'/>" method="post" enctype="multipart/form-data">
			
				<table>
					<tr>
						<td>작성자</td>
						<td>${ user.userName }(${ user.id })</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="qnaTitle"><td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="qnaContent"></textarea></td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input multiple="multiple" type="file" name="qnaAttachment"></td>
					</tr>
				</table>
				
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