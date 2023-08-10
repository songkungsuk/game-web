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
			<input id="uiName" name="uiName" type="text" placeholder="이름"><br>
			<input id="uiId" name="uiId" type="text" placeholder="아이디"><br>
			<input id="uiPwd" name="uiPwd" type="text" placeholder="비밀번호"><br>
			<input id="uiDesc" name="uiDesc" type="text" placeholder="설명"><br>
			<button class="btn btn-primary" onclick="insertUser()">유저 추가</button>
	</div>
	<script>
		function insertUser(){
			user = {
					uiName : document.querySelector('#uiName').value,
					uiId : document.querySelector('#uiId').value,
					uiPwd : document.querySelector('#uiPwd').value,
					uiDesc : document.querySelector('#uiDesc').value
			};
			const xhr = new XMLHttpRequest();
			xhr.open('POST', '/user-info/insert');
			let parseUser = JSON.stringify(user);
			xhr.setRequestHeader('Content-type', 'application/json');
			xhr.onreadystatechange =  function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						if(xhr.responseText == 1){
							alert('complete insert')
							location.href='/views/user-info/list';
						}else{
							alert('error');
						}
					}
				}
			}
			xhr.send(parseUser);
		}
	</script>
</body>
</html>