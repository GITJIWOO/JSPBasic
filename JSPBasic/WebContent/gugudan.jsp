<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 예제</title>
</head>
<body>
	<%
	for(int i = 2; i <= 9; i++) {
		if(i % 2 != 0){
			out.println("<h1>구구단" + i +"단</h1><hr/>");
			for(int j = 1; j <= 9; j++) {
				out.println(i + " * " + j + " = " + (j * i) + "<br/>");
			}
		}
	}
	%>
</body>
</html>