<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<td>이름</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>설명</td>
				<td>생일</td>
				<td>만든날</td>
				<td>수정일</td>
			</tr>
			<tr id="view">

			</tr>
		</table>
		<button onclick="location.href='/views/user-info/update?uiNum=${param.uiNum}'">유저수정</button>
		<button onclick="deleteUser()">유저삭제</button>

	</div>
	<script>
	function deleteUser(){
		let xhr = new XMLHttpRequest();
		xhr.open('POST', '/user-info/delete');
		xhr.setRequestHeader('Content-Type', 'application/json');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					if(xhr.responseText ==1){
						alert('delete complete');
						location.href='/views/user-info/list';
					}else{
						alert('error');
					}
				}
			}
		}
		xhr.send(${param.uiNum});
	}
		window.addEventListener('load', function() {
			let xhr = new XMLHttpRequest();
			xhr.open('GET', '/user-info/view?uiNum=${param.uiNum}');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						const obj = JSON.parse(xhr.responseText);
						let html = '';
						html += '<td>' + obj.uiNum + '</td>';
						html += '<td>' + obj.uiName + '</td>';
						html += '<td>' + obj.uiId + '</td>';
						html += '<td>' + obj.uiPwd + '</td>';
						html += '<td>' + obj.uiDesc + '</td>';
						html += '<td>' + obj.uiBirth + '</td>';
						html += '<td>' + obj.credat + '</td>';
						html += '<td>' + obj.lmodat + '</td>';

						document.querySelector('#view').innerHTML = html;
					}

				}
			}
			xhr.send();
		})
	</script>
</body>
</html>