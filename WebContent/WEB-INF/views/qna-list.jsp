<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A</title>
	<link rel="stylesheet" href="<c:url value='/css/table-css.css'/>">
</head>
	
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>	
		
		<div id="container">	
			<div class="title"><img src="<c:url value='/img/qna.jpg'/>" /></div>
			<a href="<c:url value='/qna/qna-add.do'/>">글쓰기</a>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ list }" var="qna">
						<tr>
							<td>${ qna.qnaNo }</td>
							<td><a href="<c:url value='/qna/qna-detail.do?qna_no=${ qna.qnaNo }'/>">${ qna.qnaTitle }</a></td>
							<td>${ qna.user.userName }(${ qna.user.id })</td>
							<td><fmt:formatDate value="${qna.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>