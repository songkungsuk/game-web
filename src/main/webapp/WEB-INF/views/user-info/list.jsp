<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
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
				<td>${one.uiName}</td>
				<td>${one.uiId}</td>
				<td>${one.uiBirth}</td>
				<td>${one.credat}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>