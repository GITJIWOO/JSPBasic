<%@page import="kr.co.ictedu.UsersVO"%>
<%@page import="kr.co.ictedu.UsersDAO"%>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
	
	String upw = request.getParameter("pw");
	String s_id = (String)session.getAttribute("s_id");
	String s_pw = (String)session.getAttribute("s_pw");
	
	// 1. DAO를 생성하고
	UsersDAO dao = UsersDAO.getInstance();
	// 2. UsersVO를 생성하되, spw, sessionId만 setter로 넣어주세요.
	UsersVO user = new UsersVO();
	user.setUid(s_id);
	user.setUpw(s_pw);
	// 3. DAO의 deleteUsers 기능을 호출하면서 파라미터로 적절한 자료를
	// 넘겨주세요.
	int deleteResultNum = dao.usersDelete(user, upw);
	System.out.println(deleteResultNum);
	
	if(deleteResultNum == 0){
		session.invalidate();
		response.sendRedirect("user_logout.jsp");
	} else if(deleteResultNum == 1){
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 탈퇴가 완료되었습니다.</h3>
</body>
</html>