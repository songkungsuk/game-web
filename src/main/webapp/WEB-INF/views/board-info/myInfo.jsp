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
<h1>내정보</h1> <br> <br> <br>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">이름</th>
      <th scope="col">아이디</th>
      <th scope="col">비밀번호</th>
      <th scope="col">생일</th>
      <th scope="col">만든날</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${user.uiNum}</th>
      <td>${user.uiName}</td>
      <td>${user.uiId}</td>
      <td>${user.uiPwd}</td>
      <td>${user.uiBirth}</td>
      <td>${user.credat}</td>
    </tr>
  </tbody>
</table>
<button class="btn btn-primary btn-lg btn-block" onclick="location.href='/'">돌아가기</button>
</div>
</body>
</html>