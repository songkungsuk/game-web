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
	<h1>안녕하세요</h1>
	<c:if test="${user != null} ">
		<a>내정보</a>
		<a>게시판</a>
		<button>로그인</button>
	</c:if>
	<c:if test="${user == null}">
		<button>로그인</button>
	</c:if>

</body>
</html>