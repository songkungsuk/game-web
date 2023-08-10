<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
</head>
<body>
	<div class="container" align="center">
		<h1>view</h1>
		<table border="1">
			<tr>
				<td>#</td>
				<td id="biNum">${param.biNum}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td id="biTitle"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td id="biContent"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td id="uiNum"></td>
			</tr>
			<tr>
				<td>만든날</td>
				<td id="credat"></td>
			</tr>
			<tr>
				<td>만든시간</td>
				<td id="cretim"></td>
			</tr>
			<tr>
				<td>마지막수정일</td>
				<td id="lmodat"></td>
			</tr>
			<tr>
				<td>마지막수정시간</td>
				<td id="lmotim"></td>
			</tr>
		</table>
		<br> <br>
		<button class="btn btn-primary" onclick="location.href='/board-info/update?biNum=${boardOne.biNum}'">수정하기</button>
		<br> <br> <br> <input type="hidden" name="biNum" value="${boardOne.biNum}">
		<button class="btn btn-primary">삭제하기</button>
		<br> <br> <br>
		<button class="btn btn-primary" onclick="location.href='/board-info/list'">돌아가기</button>
	</div>
	<script>
		function loadFunc() {
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/json/one?biNum=${param.biNum}');//jsp EL태그
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						//console.log(xhr.responseText);
						const board = JSON.parse(xhr.responseText);
						//console.log(board);
						for ( let key in board) {
							if (document.querySelector('#' + key)) {
								document.querySelector('#' + key).innerText = board[key];
							}
						}
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', loadFunc);
	</script>
</body>
</html>