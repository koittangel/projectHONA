<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>H O N A 로그인 페이지</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<form action="<c:url value='/login-processing'/>" method="post">
		<input type="id" name="id" placeholder="아이디 를 입력해주세요" required>
		<input type="password" name="password" placeholder="비밀번호를 입력해주세요." required>
		<input type="submit" value="로그인">
	</form>
	
</body>
</html>