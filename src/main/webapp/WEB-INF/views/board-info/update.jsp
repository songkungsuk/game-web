<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
</head>
<body>
	<div class="container"  align="center">
		<h1>update</h1>
		<form action="/board-info/update" method="post">
			<input name="uiNum" type="hidden" value="${user.uiNum}">
			<input name="biNum" type="hidden" value="${boardOne.biNum}">
			<input name="biTitle" type="text" placeholder="제목" value="${boardOne.biTitle}"> <br><br>
			<textarea name="biContent" cols="25" placeholder="내용">${boardOne.biContent}</textarea> <br> <br>
			<c:if test="${user.uiNum == boardOne.uiNum}">
			<button class="btn btn-primary">게시물 수정하기</button>
			</c:if>
		</form>
		<br>
		<button class="btn btn-primary" onclick="location.href='/board-info/list'">뒤로가기</button>
	</div>
</body>
</html>