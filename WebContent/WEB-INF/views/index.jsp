<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head><title>홈페이지</title></head>
<body>
	<h1>H O N A</h1>
	<a href="<c:url value='/product/product-list.do'/>">상품 목록으로 이동</a><br>
	<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록</a><br>
	<a href="<c:url value='/admin/users-list.do'/>">회원 목록으로 이동</a><br>
	<a href="<c:url value='/join.do'/>">회원 가입하기</a>
	<a href="<c:url value='/login.do'/>">로그인하기</a>
	<a href="<c:url value='/users-modify.do'/>">회원정보변경</a>
	<a href="<c:url value='/logout.do'/>">로그아웃</a>
</body>
</html>