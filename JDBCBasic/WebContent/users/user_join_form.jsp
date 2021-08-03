<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<!-- 아이디, 비밀번호, 이름, 이메일 4개 요소를 users_join.jsp
		로 보여주는 form을 작성해주세요. post 방식으로 전달합니다.
		보내는 input태그의 name속성은 컬럼명과 일치시켜주세요. -->
	<h1>회원가입</h1>
	<form action="user_join.jsp" method="post">
		<input type="text" name="uid" placeholder="아이디"><br/>
		<input type="password" name="upw" placeholder="비밀번호"><br/>
		<input type="text" name="uname" placeholder="이름"><br/>
		<input type="email" name="email" placeholder="이메일"><br/>
		<input type="submit" value="가입">
	</form>
</body>
</html>