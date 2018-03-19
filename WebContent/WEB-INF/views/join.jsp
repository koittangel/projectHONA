<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>H O N A 회원가입</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="<c:url value='/join.do'/>" method="post" enctype="multipart/form-data">
		<label>ID : <input type="text" name="id"></label><br>
		<label>PASSWORD : <input type="password" name="password"></label><br>
		<label>이름 : <input type="text" name="userName"></label><br>
		<label>생년월일 : <input type="date" name="birth"></label><br>
		<label>연락처 : <input type="number" name="phone"></label><br>
		<label>주소 : <input type="text" name="address"></label><br>
		<input type="submit" value="회원가입"><br>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
	</form>

</body>
</html>