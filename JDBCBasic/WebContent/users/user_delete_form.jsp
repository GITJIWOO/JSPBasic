<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idSession = (String)session.getAttribute("s_id");
	if(idSession == null){
		response.sendRedirect("user_login_form.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= idSession %>님의 회원탈퇴를 진행합니다.</h1>
	<h3>비밀번호를 한 번 더 입력해 주세요.</h3>
	<form action="user_delete_ok.jsp" method="post">
		<input type="password" name="pw" placeholder="비밀번호">
		<input type="submit" value="확인">
	</form>
</body>
</html>