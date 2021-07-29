<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	int total = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		total++;
		out.println("페이지 누적 요청 수 : " + total + "<br/>");
		out.println("매 <b>10</b>번째 방문자에게는 기프티콘을 드립니다.<br/>");
		if(total % 10 == 0){
			out.println("당첨되셧습니다!!<br/>");
		}
		out.println("<hr/>");
		
		int ranNum = (int)((Math.random() * 8) + 2);
		
		out.println("<h2>랜덤 구구단(" + ranNum + "단)</h2>");
		out.println("이번에 나온 구구단은 " + ranNum + "단 입니다.<br/>");
		
		for(int j = 1; j <= 9; j++){
			out.println(ranNum + " X " + j + " = " + (ranNum * j) + "<br/>");
		}
	%>
</body>
</html>