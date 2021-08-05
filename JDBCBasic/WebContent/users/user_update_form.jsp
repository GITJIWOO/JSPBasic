<%@page import="kr.co.ictedu.UsersVO"%>
<%@page import="kr.co.ictedu.UsersDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idSession = (String)session.getAttribute("s_id");
	if(idSession == null){
		response.sendRedirect("user_login_form.jsp");
	}
	
	// 1. 세션을 통해 아이디를 가져옵니다.
	//    만약 로그인 상태가 아니면 로그인창으로 리다리렉트합니다.
	String s_id = (String)session.getAttribute("s_id");
	// 2. dao를 통해서 UsersVO를 가지고 와야 합니다.
	UsersDAO dao = UsersDAO.getInstance();
	UsersVO user = new UsersVO();
	user.setUid(s_id);
	// 3. 들고온 UsersVO를 이용해 아래 html태그의 value속성에 표현식을 이용해
	//    UsersVO의 아이디, 이름, 이메일을 기입히게 만들어줍니다.
	UsersVO resultSet = dao.getUsersInfo(user);
	System.out.println(resultSet);
	
	if(resultSet.getUid() == null){
		session.invalidate();
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
	<h1><%= resultSet.getUname() %>님의 계정 정보 수정</h1>
	<form action="user_update_ok.jsp" method="post">
		<input type="text" name="chanId" value="<%= resultSet.getUid() %>" placeholder="아이디" readonly><br/>
		<input type="password" name="chanPw" placeholder="비밀번호"><br/>
		<input type="text" name="chanName" value="<%= resultSet.getUname() %>" placeholder="이름"><br/>
		<input type="text" name="chanEmail" value="<%= resultSet.getEmail() %>" placeholder="이메일"><br/>
		<input type="submit" value="변경하기">
	</form>
</body>
</html>