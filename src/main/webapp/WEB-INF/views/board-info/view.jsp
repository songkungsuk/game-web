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
		<h1>view</h1>
		<table border="1">
			<tr>
				<td>#</td>
				<td>${boardOne.biNum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${boardOne.biTitle}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${boardOne.biContent}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${boardOne.uiNum}</td>
			</tr>
			<tr>
				<td>만든날</td>
				<td>${boardOne.credat}</td>
			</tr>
			<tr>
				<td>만든시간</td>
				<td>${boardOne.cretim}</td>
			</tr>
			<tr>
				<td>마지막수정일</td>
				<td>${boardOne.lmodat}</td>
			</tr>
			<tr>
				<td>마지막수정시간</td>
				<td>${boardOne.lmotim}</td>
			</tr>
		</table><br><br>
		<c:if test="${user.uiNum == boardOne.uiNum}">
		<button class="btn btn-primary" onclick="location.href='/board-info/update?biNum=${boardOne.biNum}'">수정하기</button> <br><br><br>
		
		<form action="/board-info/delete" method="post">
		<input type="hidden" name="biNum" value="${boardOne.biNum}">
			<button class="btn btn-primary">삭제하기</button>
		</form>
		</c:if>
		<br><br><br>
		<button class="btn btn-primary" onclick="location.href='/board-info/list'">돌아가기</button>
	</div>
</body>
</html>