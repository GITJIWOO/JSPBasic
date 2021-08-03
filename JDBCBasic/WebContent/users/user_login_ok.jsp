<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	
	if(uid.equals("asd1234") && upw.equals("qwe1234")) {
	} else {
		response.sendRedirect("user_login_fail.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인을 완료하였습니다.</h3>
</body>
</html>