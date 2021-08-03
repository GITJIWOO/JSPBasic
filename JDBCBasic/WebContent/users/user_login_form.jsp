<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="user_login_ok.jsp" method="post">
		<input type="text" name="uid" placeholder="아이디"><br/>
		<input type="password" name="upw" placeholder="비밀번호"><br/>
		<input type="submit" value="로그인">
	</form>
	<h3><a href="user_join_form.jsp">회원가입 하기</a></h3>
</body>
</html>