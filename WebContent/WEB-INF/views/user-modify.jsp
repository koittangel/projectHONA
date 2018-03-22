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
				<div>회원 이름 : ${ user.userName }</div>
				<div>회원 ID : ${ user.id }</div>
				<label>기존 비밀번호 <input type="password" name="oldPassword"></label><br>
				<label>신규 비밀번호 <input type="password" name="newPassword"></label><br>
				<div>생년월일 : ${ user.birth }</div>
				<label>주소 : <input type="text" name="address" value="${ user.address }"></label><br>
				<label>연락처 : <input type="number" name="phone" value="${ user.phone }"></label><br>
				
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="submit" value="변경완료">
				<a href="<c:url value='/user-delete.do?user_no=${ user.userNo }&user_name=${ user.userName }'/>">회원탈퇴</a><br>
			</form>	
		</div>
	</div>

</body>
</html>