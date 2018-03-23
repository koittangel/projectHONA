<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>H O N A 로그인 페이지</title>
	<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">						
</head>
<body>
	<div id="wrap">
		<div id="leftMenu">
		<jsp:include page="index.jsp" flush="false"/>
		</div>
		
		<div id="container"> 
		
			<h1>로그인 페이지</h1>
			<form action="<c:url value='/login-processing'/>" method="post">
				<table>
				<tr>
					<td>아이디</td>
					<td><input type="id" name="id" placeholder="아이디 를 입력해주세요" required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" placeholder="비밀번호를 입력해주세요." required></td>
				</tr>
				</table>
				<br>
				<input type="submit" value="로그인">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
			</form>
			
			<a href="<c:url value='/join.do'/>">회원가입</a>
			<c:if test="${ param.error == 'login' }">
				<p style="color:#FF0000">ID 혹은 비밀번호를 잘못 입력하셨습니다.</p>
			</c:if>
			<c:if test="${ param.logout == 'true' }">
				<p style="color:#FF0000">로그아웃 하였습니다.</p>
			</c:if>
		</div>
	</div>
</body>
</html>