<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String height = request.getParameter("height");
	String weight = request.getParameter("weight");
	double bmi = Double.parseDouble(weight) / ((Double.parseDouble(height) / 100) * (Double.parseDouble(height) / 100));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>BMI 계산기</h2>
	<hr/>
	키 : <b><%= height %>cm</b><br/>
	체중 : <b><%= weight %>kg</b><br/>
	BMI : <b><%= bmi %></b><br/>
	<%
		if(bmi > 23){
			out.println("당신은 과체중 입니다.");
		} else if (bmi < 18.5){
			out.println("당신은 저체중 입니다.");
		} else {
			out.println("당신은 정상체중 입니다.");
		}
	%>
</body>
</html>