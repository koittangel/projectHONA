<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head><title>문의글 목록</title></head>
<body>
	<h1>문의글 목록</h1>
	<a href="<c:url value='/qna/qna-add.do'/>">글쓰기</a>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>상품</th>
				<th>제목</th>
				<th>작성자</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="qna">
				<tr>
					<td>${ qna.qnaNo }</td>
					<td><a href="<c:url value='/qna/qna-detail.do?qnaNo=${ qna.qnaNo }'/>">${ qna.qnaTitle }</a></td>
					<td>${ qna.user.userName }(${ qna.user.id })</td>
					<td>${ qna.regDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>