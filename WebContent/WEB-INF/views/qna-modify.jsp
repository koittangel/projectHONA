<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>H O N A</title>
<link rel="stylesheet" href="<c:url value='/css/index-css.css'/>">
</head>

<body>
	<div id="wrap">
		<div id="leftMenu">
			<jsp:include page="index.jsp" flush="false" />
		</div>
		<div id="container">
			<div id="content">
				<form action="<c:url value='/qna/qna-modify.do'/>" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>번호:</td>
							<td>${ qna.qnaNo }</td>
						</tr>
						<tr>
							<td>상품 :</td>
							<td>${ qna.productNo }
							<td>
						</tr>
						<tr>
							<td>작성자 :</td>
							<td>${ qna.user.userName }(${ qna.user.id })</td>
						</tr>
						<tr>
							<td>제목 :</td>
							<td><input type="text" name="qnaTitle"
								value="${ qna.qnaTitle }"></td>
						</tr>
						<tr>
							<td>가격 :</td>
							<td><input type="number" name="price"
								value="${ product.price }"></td>
						</tr>
						<tr>
							<td>내용 :</td>
							<td><textarea name="qnaContent">${ qna.qnaContent }</textarea></td>
						</tr>
						<tr>
							<td>첨부파일 :</td>
							<td><input type="file" name="qnaAttachment"></td>
						</tr>
					</table>

					<input type="hidden" name="qnaNo" value="${ qna.qnaNo }"> <input
						type="hidden" name="productNo" value="${ qna.productNo }">
					<input type="submit" value="수정"> <input type="reset"
						value="입력한 내용 지우기"> <br> <a
						href="<c:url value='/qna/qna-list.do'/>">문의글 목록으로 이동</a> <input
						type="hidden" name="${ _csrf.parameterName }"
						value="${ _csrf.token }">
				</form>
			</div>
			<div id="footer">
				<span>COMPANY - L&K . CEO CP0 - HONA <br> ADDRESS - 서울시
					금천구 BUSINESS LICENSE : 105-13-44550 <br> ONLINE BUSINESS
					LICENSE : 2018-서울금천-0315<br> COPYRIGHT (C) HONA<br>
				</span>
			</div>
		</div>
	</div>
</body>
</html>