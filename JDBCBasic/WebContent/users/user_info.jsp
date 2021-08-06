<%@page import="kr.co.ictedu.UsersDAO"%>
<%@page import="kr.co.ictedu.UsersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	
	String s_id = (String)session.getAttribute("s_id");
	if(s_id == null){
		response.sendRedirect("user_login_form.jsp");
	} else {
		
	}
	UsersVO user = new UsersVO();
	UsersDAO dao = UsersDAO.getInstance();
	UsersVO userInfo = dao.getUsersInfo(user);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2><%= userInfo.getUid() %>님의 정보입니다.</h2>
	<h3>비밀번호 : <%= userInfo.getUpw() %></h3>
	<h3>이름 : <%= userInfo.getUname() %></h3>
	<h3>비밀번호 : <%= userInfo.getEmail() %></h3>
</body>
</html>