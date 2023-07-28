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
<form action="/user-info/login" method="post">
	<input name="uiId" type="text" placeholder="아이디"><br>
	<input name="uiPwd" type="password" placeholder="비밀번호"><br>
	<button class="btn btn-primary">로그인</button>
</form>
</body>
</html>