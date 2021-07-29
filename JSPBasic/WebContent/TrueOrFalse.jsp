<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%!
			boolean TrueOrFalse(int num1, int num2){
				if(num1 >= num2){
					return true;
				} else {
					return false;
				}
			}
		%>
		<% out.println("스크립트릿으로 출력된 값 : <b>" + TrueOrFalse(1, 2) + "</b><br/>"); %>
		표현식으로 출력한 값 : <b><%= TrueOrFalse(1, 2) %></b><br/>
	</body>
</html>