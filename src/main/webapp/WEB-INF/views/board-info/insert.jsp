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
		<h1>insert</h1>
				<form action="/board-info/insert" method="post">
			<input name="uiNum" type="hidden" value="${user.uiNum}">
			<input name="biTitle" type="text" placeholder="제목"> <br><br><br>
			<textarea name="biContent" rows="25" cols="50" placeholder="내용"></textarea><br>
			<button class="btn btn-primary">게시물 추가</button>
		</form>
	</div>
</body>
</html>