<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Random random = new Random();
	int number = 0;
%>
<%
	List<Integer> lotto = new ArrayList<>();
	while(lotto.size() < 6){
		number = random.nextInt(45) + 1;
		if (!lotto.contains(number)){
			lotto.add(number);
		}
	}
	Collections.sort(lotto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로또번호 생성 결과</h2>
	<p>이번주 로또번호는 이 번호다!!!<p>
	<% 
		for(Integer num : lotto) {
			out.println(num + "&nbsp;");
			Thread.sleep(700); // CPU를 잠시 멈추는 메서드.
			out.flush(); // 브라우저의 출력 버퍼를 비우는 메서드.
		}
	%>
</body>
</html>