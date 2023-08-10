<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <input type="text" id="name"> <br>
	나이 : <input type="text" id="age"> <br>
	주소 : <input type="text" id="address"> <br>
	<button onclick="updateObj()">수정</button>
	
	<script>
		function updateObj() {
			const updateVal = {
					name : document.querySelector('#name').value,
					age : document.querySelector('#age').value,
					address : document.querySelector('#address').value,
			}
			console.log(updateVal);
			let json = JSON.stringify(updateVal);
			let xhr = new XMLHttpRequest();
			xhr.open('POST', '/list/update?num=${param.num}');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function () {
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						if(xhr.responseText == 1){
							alert('update');
							location.href='/views/list';
						}else{
							alert('error');
						}
					}
				}
			}
			xhr.send(json);
		}
		
		window.addEventListener('load', function () {
			let xhr = new XMLHttpRequest();
			xhr.open('GET', 'http://localhost/list/one?num=${param.num}');
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						let one = JSON.parse(xhr.responseText);
						document.querySelector('#name').value = one.name;
						document.querySelector('#age').value = one.age;
						document.querySelector('#address').value = one.address;
					}
				}
			}
			xhr.send()
		})
	</script>
</body>
</html>