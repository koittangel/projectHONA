<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원정보변경</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		<div id="container">
			<h1>회원정보변경</h1>
			<form action="<c:url value='/user-modify.do'/>" method="post">
			
				<table>
					<tr>
						<td>회원 이름 : </td>
						<td>${ user.userName }</td>
					</tr>
					<tr>
						<td>회원 ID :</td>
						<td>${ user.id }<td>
					</tr>
					<tr>
						<td>기존 비밀번호 </td>
						<td><input type="password" name="oldPassword"></td>
					</tr>
					<tr>
						<td>신규 비밀번호 </td>
						<td><input type="password" name="newPassword"></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>${ user.birth }</td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address" value="${ user.address }"></td>
					</tr>
					<tr>
						<td>연락처</td>
						<td><input type="number" name="phone" value="${ user.phone }"></td>
					</tr>
				</table>
				
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="submit" value="변경완료">
				<a href="<c:url value='/user-delete.do?user_no=${ user.userNo }&user_name=${ user.userName }'/>">회원탈퇴</a><br>
			</form>	
		</div>
	</div>

</body>
</html>