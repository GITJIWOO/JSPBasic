<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form action="/MyFirstWeb/userlogin.do" method="post">
		<input type="text" name="uid" placeholder="아이디"/><br>
		<input type="password" name="upw" placeholder="비밀번호"/><br>
		<p><input type="submit" value="로그인"></p>
	</form>
	<form action="/MyFirstWeb/user/user_join_form.jsp" method="post">
		<input type="hidden" name="join">
		<p><input type="submit" value="회원가입"></p>
	</form>
</body>
</html>