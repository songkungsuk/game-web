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
	<div class="container" align="center">
		<h1>update</h1>
			<input id="uiName" name="uiName" type="text" placeholder="이름">
			<input id="uiId" name="uiId" type="text" placeholder="아이디">
			<input id="uiPwd" name="uiPwd" type="text" placeholder="비밀번호" >
			<input id="uiDesc" name="uiDesc" type="text" placeholder="설명" >
			<button class="btn btn-primary" onclick="updateUser()">유저 수정</button>

	</div>
	
	<script>
		function updateUser(){
			let user = {
					uiNum : ${param.uiNum},
					uiName : document.querySelector('#uiName').value,
					uiId : document.querySelector('#uiId').value,
					uiPwd : document.querySelector('#uiPwd').value,
					uiDesc : document.querySelector('#uiDesc').value
			};
			const xhr = new XMLHttpRequest();
			xhr.open('POST','/user-info/update');
			xhr.setRequestHeader('Content-Type', 'application/json');
			parseUser = JSON.stringify(user);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						console.log(xhr.responseText);
						if(xhr.responseText == 1){
							alert('complete update');
							location.href='/views/user-info/list';
						}else{
							alert('fail');
						}
					}
				}
			}
			xhr.send(parseUser);
		}
		window.addEventListener('load', function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/user-info/update?uiNum=${param.uiNum}');
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){ //서버가 요청을 받고 응답을 보내고 난후 상태는 4이다
					if(xhr.status == 200){ //페이지가 정상적으로 동작했으면 200
						const obj = JSON.parse(xhr.responseText);
						for(const key in obj){
							if(document.querySelector('#'+key)){
								document.querySelector('#'+key).value = obj[key];	
							}
							
						}
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>