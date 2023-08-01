<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
</head>
<body>
	<div class="container" align="center">
		<h1>list</h1>
		<form action="/board-info/list" method="get">
			<select name="searchType">
				<option value="1">제목</option>
				<option value="2">작성자</option>
				<option value="3">내용</option>
				<option value="4">제목+내용</option>
				<option value="5">작성자+내용</option>
				<option value="6">제목+작성자</option>
				<option value="7">제목+작성자+내용</option>
			</select>
			<input type="text" name="searchStr" placeholder="검색어">
			<button>검색</button>
		</form>
		<table border="1">
			<tr>
				<td>#</td>
				<td>제목</td>
				<td>만든이</td>
				<td>만든날</td>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.biNum}</td>
					<td><a href="/board-info/view?biNum=${board.biNum}">${board.biTitle}</a></td>
					<td>${board.uiName}</td>
					<td>${board.credat}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<button class="btn btn-primary"
			onclick="location.href='/board-info/insert'">게시물 추가</button>
		<br> <br>
		<button class="btn btn-primary" onclick="location.href='/'">메인화면으로돌아가기</button>
	</div>
</body>
</html>