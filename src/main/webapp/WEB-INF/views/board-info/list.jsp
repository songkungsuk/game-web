<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
</head>
<body>
	<div class="container" align="center">
		<h1>list</h1>
			<select name="searchType" id="searchType">
				<option value="1">제목</option>
				<option value="2">작성자</option>
				<option value="3">내용</option>
				<option value="4">제목+내용</option>
				<option value="5">작성자+내용</option>
				<option value="6">제목+작성자</option>
				<option value="7">제목+작성자+내용</option>
			</select>
			<input type="text" name="searchStr" placeholder="검색어" id="searchStr">
			<button onclick="loadFunc()">검색</button>
	
		<table border="1">
			<tr>
				<td>#</td>
				<td>제목</td>
				<td>만든이</td>
				<td>만든날</td>
			</tr>
			<tbody id="content">
			</tbody>
		</table>
		<br>
		<button class="btn btn-primary"
			onclick="location.href='/board-info/insert'">게시물 추가</button>
		<br> <br>
		<button class="btn btn-primary" onclick="location.href='/'">메인화면으로돌아가기</button>
	</div>
	<script>
		const loadFunc = function(){
			const xhr = new XMLHttpRequest();
			const searchStr = document.querySelector('#searchStr');
			const searchType = document.querySelector('#searchType');
			let url = '/json/list?'
			if(searchStr.value!==''){
				url += 'searchType=' + searchType.value + '&searchStr=' + searchStr.value;
			}
			
			xhr.open('GET', url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4){
					if(xhr.status == 200){
						console.log(xhr.responseText);
						const obj = JSON.parse(xhr.responseText);
						console.log(obj);
						let html = '';
						
						for(let i=0; i<obj.length; i++){
							const board = obj[i];
							console.log(board);
							html += '<tr>';
	                        html += '<td>'+ board.biNum +'</td>';
	                        html += '<td><a href="/views/board-info/view?biNum='+ board.biNum +'">'+ board.biTitle +'</a></td>';
	                        html += '<td>'+ board.uiName +'</td>';
	                        html += '<td>'+ board.credat +'</td>';
							html += '</tr>';
						}
						
						document.querySelector('#content').innerHTML = html;
					}
				}
			}
			xhr.send();
		}
		
		window.addEventListener('load',loadFunc);
		
	</script>
</body>
</html>