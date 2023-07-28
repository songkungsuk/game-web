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
	<div class="container" align="center">
		<h1>list</h1>
		<table border="1">
			<tr>
				<td>#</td>
				<td>이름</td>
				<td>아이디</td>
				<td>생일</td>
				<td>만든날</td>
			</tr>
			<c:forEach items="${userList}" var="one">
			<tr>
				<td>${one.uiNum}</td>
				<td><a href="/user-info/view?uiNum=${one.uiNum}">${one.uiName}</a></td>
				<td>${one.uiId}</td>
				<td>${one.uiBirth}</td>
				<td>${one.credat}</td>
			</tr>
			</c:forEach>
		</table>
		<button class="btn btn-primary" onclick="location.href='/user-info/insert'">유저 추가</button>
	</div>
</body>
</html>