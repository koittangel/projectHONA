<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>H O N A 회원 탈퇴</title>
</head>
<body>
	<h1>회원 탈퇴 화면입니다.</h1>
	<h3> 안녕하세요 ${ userName } 님.</h3>
	<h3>기존에 입력되어있던 모든 내역들이 삭제됩니다.</h3>
	<form action="<c:url value='/user-delete.do'/>" method="post">
		<input type="hidden" name="userNo" value="${ userNo }">
		<input type="submit" value="회원탈퇴">
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>
</body>
</html>