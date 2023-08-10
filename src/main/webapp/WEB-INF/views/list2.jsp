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
		<tbody id="name">
		</tbody>
	</table>
	
	<script>
	function mybatis() {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', '/list');
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					let json = JSON.parse(xhr.responseText);
					let html = '';
					for(let list of json){
						html += '<tr>';
						html += '<td>'+list.num+'</td>';
						html += '<td>'+list.name+'</td>';
						html += '<td>'+list.age+'</td>';
						html += '<td>'+list.address+'</td>';
						html += '</tr>';
					}
					document.querySelector('#name').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', mybatis);
	</script>
</body>
</html>