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
	<div class="container"  align="center">
		<h1>회원가입</h1>
		<form action="/user-info/insert" method="post">
			<input name="uiName" type="text" placeholder="이름"><br>
			<input name="uiId" type="text" placeholder="아이디"><br>
			<input name="uiPwd" type="text" placeholder="비밀번호"><br>
			<input name="uiDesc" type="text" placeholder="설명"><br>
			<input name="uiBirth" type="text" placeholder="생일"><br>
			<button class="btn btn-primary">유저 추가</button>
		</form>
	</div>
</body>
</html>