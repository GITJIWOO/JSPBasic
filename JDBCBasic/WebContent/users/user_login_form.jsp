<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션이 존재하면 바로 user_login_ok.jsp로 보내주는 로직을 작성해주세요.
	String idSession = (String)session.getAttribute("s_id");

	if(idSession != null){
		response.sendRedirect("user_logout.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 창</h1>
	<form action="user_login_ok.jsp" method="post">
		<input type="text" name="uid" placeholder="아이디"><br/>
		<input type="password" name="upw" placeholder="비밀번호"><br/>
		<input type="submit" value="로그인">
	</form>
	<h3><a href="user_join_form.jsp">회원가입 하기</a></h3>
</body>
</html>