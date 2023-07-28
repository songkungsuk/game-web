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
	<h1>집에가고싶다</h1>
	<br><br><br><br>
	<c:if test="${user.uiId != null}">
		<h1><a href="/board-info/myInfo">내정보</a></h1>
		<br>
		<h1><a href="/board-info/list">게시판</a></h1>
		<br>
		<button onclick="location.href='/user-info/logout'">로그아웃</button><br>
	</c:if>
	<c:if test="${user == null}">
		<button onclick="location.href='/user-info/login'" class="btn btn-primary btn-lg btn-block">로그인</button>
		<button onclick="location.href='/user-info/insert'" class="btn btn-primary btn-lg btn-block">회원만들기</button>
	</c:if>
</div>
</body>
</html>