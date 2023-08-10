<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<style>
* {
	margin: 50px;
}
</style>
</head>
<body>
	<div class="container" align="center">
		<h1>list</h1>
		<table border="1">
			<tr>
				<td>#</td>
				<td>이름</td>
				<td>아이디</td>
				<td>생일</td>
				<td>만든날</td>
			</tr>
			<tbody id="content">
			</tbody>
		</table>
		<select id="searchType">
			<option value="1">이름
			<option value="2">아이디
		</select> <input type="text" id="searchStr">
		<button onclick="loadFunc()">검색</button>
		<br>
		<button class="btn btn-primary"
			onclick="location.href='/views/user-info/insert'">유저 추가</button>
	</div>
	<script>
		window.addEventListener('load', function(){
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/user-info/list')
			xhr.onreadystatechange = function (){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						const obj = JSON.parse(xhr.responseText);
						let html = '';
						for(let key of obj){
							html += '<tr>';
							html += '<td>'+key.uiNum+'</td>';
							html += '<td><a href="/views/user-info/view?uiNum='+key.uiNum+'">'+key.uiName+'</a></td>';
							html += '<td>'+key.uiId+'</td>';
							html += '<td>'+key.uiPwd+'</td>';
							html += '<td>'+key.credat+'</td>';
							html += '</tr>';
						}
						document.querySelector('#content').innerHTML = html;
					}
				}
			}
			xhr.send();
		});
	</script>
</body>
</html>