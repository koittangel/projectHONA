<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>H O N A 회원목록</title>
</head>
<body>
	<h1>회원목록 조회</h1>
	<h6>관리자용 페이지 입니다.</h6>
	
	<table>
		<thaed>
			<tr>
				<th>회원 No</th>
				<th>회원 ID</th>
				<th>회원 이름</th>
				<th>회원 주소</th>
				<th>회원 전화번호</th>
			</tr>
		</thaed>
		<tbody>
			<c:forEach items="${ list }" var="user">
				<tr>
					<td>${ user.userNo }</td>
					<td>${ user.id }</td>
					<td>${ user.userName }</td>
					<td>${ user.address }</td>
					<td>${ user.phone }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="<c:url value='index.do'/>">메인 화면</a>
</body>
</html>