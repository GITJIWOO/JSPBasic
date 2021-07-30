<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String joinId = request.getParameter("id");
	String joinPw = request.getParameter("pw");
%>
<!DOCTYPE html>
<html>
<%
	if(joinId.equals("abcd") && joinPw.equals("1234")){
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 성공!</h2>
</body>
<% } else { %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 또는 비밀번호가 다릅니다.<br/>
	<a href = "req_login_form.jsp">로그인</a><br/>
	<a href = "req_join_form.jsp">회원가입</a><br/> 
</body>
<% } %>
</html>