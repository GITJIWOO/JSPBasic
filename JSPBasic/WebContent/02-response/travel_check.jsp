<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String travel = request.getParameter("travel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(travel.equals("canada")){
			response.sendRedirect("travel_canada.jsp");
		} else if(travel.equals("iceland")){
			response.sendRedirect("travel_iceland.jsp");
		}
	%>
</body>
</html>