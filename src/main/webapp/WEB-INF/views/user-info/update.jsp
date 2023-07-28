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
		<h1>update</h1>
				<form action="/user-info/update" method="post">
			<input name="uiNum" type="hidden" value="${User.uiNum}"> 
			<input name="uiName" type="text" placeholder="이름" value="${User.uiName}">
			<input name="uiId" type="text" placeholder="아이디" value="${User.uiId}">
			<input name="uiPwd" type="text" placeholder="비밀번호" value="${User.uiPwd}">
			<input name="uiDesc" type="text" placeholder="설명" value="${User.uiDesc}">
			<input name="uiBirth" type="text" placeholder="생일" value="${User.uiBirth}">
			<button class="btn btn-primary">유저 수정</button>
		</form>
	</div>
</body>
</html>