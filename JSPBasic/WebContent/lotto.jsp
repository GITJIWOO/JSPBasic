<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Random random = new Random();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int number = 0;
		List<Integer> lotto = new ArrayList<>();
	%>
	<%
		out.println("<h2>로또번호 생성 결과</h2>");
		out.println("<p>이번주 로또는 이 번호다!!!</p>");
		while(lotto.size() < 6){
			number = random.nextInt(45) + 1;
			if (!lotto.contains(number)){
				lotto.add(number);
			}
		}
		Collections.sort(lotto);
		out.println(lotto);
	%>
</body>
</html>