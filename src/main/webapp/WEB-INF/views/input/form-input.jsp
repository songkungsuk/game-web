<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 :
	<input type="text" id="name">
	<br> 아이디 :
	<input type="text" id="id">
	<br> 비밀번호 :
	<input type="text" id="pw">
	<br> 자기소개 :
	<textarea id="desc"></textarea>
	<br> 성별 :
	<input type="radio" id="trans" value="남">남
	<input type="radio" id="trans" value="여">여
	<br> 직업 :
	<select id="job">
		<option value="">선택</option>
		<option value="개발자">개발자</option>
		<option value="백수">백수</option>
	</select>
	<button onclick="inputProfile()">저장</button>

	<div id="myContent"></div>
	<script>
		function inputProfile() {

			const param = {
				name : document.querySelector('#name').value,
				id : document.querySelector('#id').value,
				pw : document.querySelector('#pw').value,
				desc : document.querySelector('#desc').value,
				trans : document.querySelector('#trans').value,
				job : document.querySelector('#job').value,

			}
			let json = JSON.stringify(param);

			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/input');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						document.querySelector('#myContent').innerHTML = xhr.responseText;
					}
				}
			}
			xhr.send(json);
		}
	</script>
</body>
</html>