<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr.dd{
	cursor: pointer;
}
tr.dd:hover{
	color: blue;
	cursor: pointer;
}

</style>
</head>
<body>
	<table border="1">
		<tr>
			<td>#</td>
			<td>이름</td>
			<td>나이</td>
			<td>주소</td>
		</tr>
		<tbody id="innerHtml">
		</tbody>
	</table>

	<script>
		function goPage(num) {
			location.href='/views/one?num='+num;
		}
		function myfunc() {
			let xhr = new XMLHttpRequest();
			xhr.open('GET','/list');
			xhr.onreadystatechange = function () {
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						let obj = JSON.parse(xhr.responseText);
						let html = '';
						for(let list of obj){
							html += '<tr class="dd" onclick="goPage('+list.num+')">';
							console.log(list);
							console.log(list.num);
							html += '<td>' + list.num + '</td>';
							html += '<td>' + list.name + '</td>';
							html += '<td>' + list.age + '</td>';
							html += '<td>' + list.address + '</td>';
							html += '</tr>';
						}
						document.querySelector('#innerHtml').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		window.addEventListener('load', myfunc);
	</script>
</body>
</html>