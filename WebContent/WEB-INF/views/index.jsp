<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

	<title>H O N A</title>
	
	<link rel="stylesheet" href="css/index-css.css">
	
</head>
<body>
	<a href="<c:url value='index.do'/>" style="text-decoration: none;">
		<img src="<c:url value='/img/hona.png'/>"/>
	</a>
	
	<br>
	
	<ul>
	<sec:authorize access="hasRole('ADMIN')">
		<h3>관리자 페이지 입니다.</h3>
		<li><a href="<c:url value='/product/product-add.do'/>">제품 등록</a><br></li>
		<li><a href="<c:url value='/user-list.do'/>">회원 목록으로 이동</a><br></li>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		<li><a href="<c:url value='/user-modify.do'/>">회원정보변경</a><br></li>
		<li><a href="<c:url value='/logout.do'/>">로그아웃</a><br></li>
		<li><a href="<c:url value='/qna/qna-add.do'/>">문의글 등록</a><br></li>
	</sec:authorize>
	
	<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
		<li><a href="<c:url value='/join.do'/>">회원 가입하기 </a></li>
		<li><a href="<c:url value='/login.do'/>">로그인하기</a><br></li>
	</sec:authorize>
	
		<li><a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a><br></li>
		<li><a href="<c:url value='/qna/qna-list.do'/>">문의글 목록</a><br></li>
		<li><a href="<c:url value='/notice/notice-list.do'/>">공지글 목록</a><br></li>
	
	</ul>
</body>
</html>