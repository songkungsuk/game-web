<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호 : <span id="num">${param.num}</span> <br>
이름 : <span id="name"></span> <br>
나이 : <span id="age"></span> <br>
주소 : <span id="address"></span> <br>
<button onclick="goPage('/views/update?num=${param.num}')">수정</button> <button onclick="deleteObj()">삭제</button>
<script>
	function goPage(text) {
		location.href = text;
	}
	function deleteObj() {
		let xhr = new XMLHttpRequest();
		xhr.open('POST', '/list/delete?num=${param.num}');
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					if(xhr.responseText == 1){
						alert('delete');
						location.href='/views/list';
					}else{
						alert('error');
					}
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', function(){
		let xhr = new XMLHttpRequest();
		xhr.open('GET', 'http://localhost/list/one?num=${param.num}');
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					let one = JSON.parse(xhr.responseText);
					document.querySelector('#num').innerHTML = one.num;
					document.querySelector('#name').innerHTML = one.name;
					document.querySelector('#age').innerHTML = one.age;
					document.querySelector('#address').innerHTML = one.address;
				}
			}
		}
		xhr.send();
	});
</script>
</body>
</html>