<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>
</head>
<body>
	<div class="container" align="center">
		<h1>view</h1>
		<table border="1">
			<tr>
				<td>#</td>
				<td>이름</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>설명</td>
				<td>생일</td>
				<td>만든날</td>
				<td>수정일</td>
			</tr>
			<tr>
				<td>${User.uiNum}</td>
				<td>${User.uiName}</td>
				<td>${User.uiId}</td>
				<td>${User.uiPwd}</td>
				<td>${User.uiDesc}</td>
				<td>${User.uiBirth}</td>
				<td>${User.credat}</td>
				<td>${User.lmodat}</td>
			</tr>
		</table>
		<button onclick="location.href='/user-info/update?uiNum=${User.uiNum}'">유저수정</button>
		<form action="/user-info/delete" method="post">
		<input type="hidden" name="uiNum" value="${User.uiNum}">
		<button class="btn btn-primary">유저삭제</button>
		</form>
	</div>
</body>
</html>