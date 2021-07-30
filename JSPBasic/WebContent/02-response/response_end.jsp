<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// response.sendRedirect("주소")
		// 는 해당 코드가 실행될 경우 바로
		// 파라미터로 입력된 주소로 보내버립니다.
		// 50%확률로 네이버로 보내는 코드를 작성해주세요.
		// 안 넘머갈 때는 화면에 "<h1>안 넘어갔습니다<h1>"이 출력되게 해 주세요.
		int random = (int)(Math.random() * 2);
		switch(random){
		case 0:
		response.sendRedirect("http://www.naver.com");
		break;
		case 1:
		out.println("<h1>안 넘어갔습니다.</h1>");
		break;
		}
	%>
</body>
</html>