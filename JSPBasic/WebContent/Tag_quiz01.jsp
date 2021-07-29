<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%!
Random random = new Random();
int cumulative = 0;

int reQuest(){
	return cumulative += 1;
}

int luckNumber(){
	int luckNum = random.nextInt(10) + 1;
	return luckNum;
}

String luckColor(){
	double randomNum = random.nextDouble();
	if(randomNum >= 0.66){
		return "빨강";
	} else if (randomNum >= 0.33){
		return "노랑";
	} else{
		return "파랑";
	}
}
%>
<%
	// Scriptlet
	// 지역 변수 및 메서드 내부의 코드를 작석하는 태그
	// 페이지 요청이 발생할 때 마다 실행할 로직을 작성.
	int individual = 0;
	cumulative++;
	individual++;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		
		<%
		out.println("<h1>Web프로그래밍</h1>");
		out.println("페이지 누적 요청수 : " + reQuest() + ", 페이지 개별 요청수 : " + individual);
		%>
		<h2>오늘의 행운의 숫자와 행운의 색깔</h2>
		행운의 숫자 : <b><%= luckNumber() %></b><br/>
		행운의 색깔 : <b><%= luckColor() %></b><br/>
	</body>
</html>