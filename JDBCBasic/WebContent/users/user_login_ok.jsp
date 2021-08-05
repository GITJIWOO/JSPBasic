<%@page import="kr.co.ictedu.UsersVO"%>
<%@page import="kr.co.ictedu.UsersDAO"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");

	String uid = request.getParameter("uid");
	String upw = request.getParameter("upw");
	String uname = request.getParameter("uname");
	String email = request.getParameter("email");
	
	
	
	// if~else문으로 try~catch~finally를 감싸서
	// 세션이 존재할 때는 DB에서 데이터를 가져오는 로직을 생각해주세요.
	String idSession = (String)session.getAttribute("s_id");
			

	if(idSession != null){
		uid = idSession;
	} else {
		UsersDAO dao = UsersDAO.getInstance();
		
		UsersVO user = new UsersVO();
		user.setUid(uid);
		user.setUpw(upw);
		
		int loginResultNum = dao.usersLogin(user);
		
		if(loginResultNum == 0) {
			response.sendRedirect("user_login_fail.jsp");
		} else if(loginResultNum == 1) {
			session.setAttribute("s_id", uid);
			session.setAttribute("s_pw", upw);
			session.setAttribute("s_name", uname);
			session.setAttribute("s_email", email);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<p><%= uid %>님 환영합니다.</p>
	<h3>로그인을 완료하였습니다.</h3>
	<h3><a href="user_logout.jsp">로그아웃</a></h3>
	<h3><a href="user_update_form.jsp">회원수정하기</a></h3>
	<h3><a href="user_delete_form.jsp">회원탈퇴</a></h3>
</body>
</html>