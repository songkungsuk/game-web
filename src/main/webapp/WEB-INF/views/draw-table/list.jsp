<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<td>설명</td>
		</tr>
		<tbody id="content">
		</tbody>
	</table>
	
	<script>
	function start() {
		const xhr = new XMLHttpRequest();
		xhr.open('GET','/draw-table/list');
		xhr.onreadystatechange = function () {
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					obj = JSON.parse(xhr.responseText);
					console.log(obj);
					let html = '';
					for(let i=0; i<obj.length; i++){
						let draw = obj[i];
						html += '<tr>';
						html += '<td>'+ draw.drNum +'</td>';
						html += '<td>'+ draw.drName +'</td>';
						html += '<td>'+ draw.drDesc +'</td>';
						html += '</tr>';
					}
					document.querySelector('#content').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
	window.addEventListener('load', start);
	</script>
</body>
</html>