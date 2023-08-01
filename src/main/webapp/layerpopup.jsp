<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div#popup {
	position: absolute;
	top: 100px;
	left: 50px;
	color: yellow;
	width: 270px;
	height: 100px;
	background-color: gray;
}

div#popup>div {
	position: relative;
	background-color: #ffffff;
	top: 0px;
	border: 1px solid gray;
	padding: 10px;
	color: black;
}
</style>
<script src="https://code.jquery.com/jquery-3.7.0.js"
	integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM="
	crossorigin="anonymous"></script>
<script type="text/javascript">
$(function() {
	$('#closeBtn').click(function () {
		$('#popup').hide();
	});
});
</script>
</head>
<body>
	<%
	String popupMode = "on";
	%>
	<h2>팝업 메인 페이지</h2>
	<%
	
		out.print("현재 팝업창은 " + popupMode + "상태입니다.<br>");
	
	if(popupMode.equals("on")){
		%>
		<div id="popup">
		<h2 align="center">공지사항 팝업입니다.</h2>
		<div>
		<form name="popFrm">
		<input type="checkbox" id="inactiveToday" value="1"/>하루동안 열지않음
		<input type="button" value="닫기" id="closeBtn">
		</form>
		</div>
		</div>
		
		<%
	}
	%>
</body>
</html>