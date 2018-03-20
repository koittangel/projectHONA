<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head><title>홈페이지</title></head>
<body>

	<img src="./img/hona.png "alt="로고"  />
	<h1>H O N A</h1>
	
	<sec:authorize access="hasRole('ADMIN')">
		<h3>관리자 페이지 입니다.</h3>
		<a href="<c:url value='/product/product-add.do'/>">제품 등록</a><br>
		<a href="<c:url value='/user-list.do'/>">회원 목록으로 이동</a><br>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		<a href="<c:url value='/user-modify.do'/>">회원정보변경</a><br>
		<a href="<c:url value='/logout.do'/>">로그아웃</a><br>
	</sec:authorize>
	
	<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
		<a href="<c:url value='/join.do'/>">회원 가입하기</a><br>
		<a href="<c:url value='/login.do'/>">로그인하기</a><br>
	</sec:authorize>
	
	<a href="<c:url value='/product/product-list.do'/>">제품 목록으로 이동</a><br>
	<a href="<c:url value='/qna/qna-list.do'/>">문의글 목록</a><br>
		
</body>
</html>