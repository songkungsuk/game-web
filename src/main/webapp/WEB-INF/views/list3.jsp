<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>#</td>
			<td>이름</td>
			<td>나이</td>
			<td>주소</td>
		</tr>
		<tbody id="mac">
		
		</tbody>
	</table>
	<script>
		function readyfunc(){
			let xhr = new XMLHttpRequest();
			xhr.open('GET', '/list');
			xhr.onreadystatechange = function (){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						let obj = JSON.parse(xhr.responseText);
						let html = '';
						for(let list of obj){
							html += '<tr>';
							html += '<td>'+list.num+'</td>';
							html += '<td>'+list.name+'</td>';
							html += '<td>'+list.age+'</td>';
							html += '<td>'+list.address+'</td>';
							html += '</tr>';
						}
						document.querySelector('#mac').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', readyfunc);
	</script>
</body>
</html>