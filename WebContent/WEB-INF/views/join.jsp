<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A 회원가입</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
			<form action="<c:url value='/join.do'/>" method="post" enctype="multipart/form-data">
				
				<table>
					<tr>
						<td>ID : </td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td>PASSWORD :</td>
						<td><input type="password" name="password"><td>
					</tr>
					<tr>
						<td>이름 :  </td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>생년월일 : </td>
						<td><input type="date" name="birth"></td>
					</tr>
					<tr>
						<td>연락처 : </td>
						<td><input type="number" name="phone"></td>
					</tr>
					<tr>
						<td>주소 : </td>
						<td><input type="text" name="address"></td>
					</tr>

				</table>
				
				<input type="submit" value="회원가입"><br>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
		</div>
	</div>
</body>
</html>