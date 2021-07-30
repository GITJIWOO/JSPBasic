<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%!
	// 선언부에 작성한 변수들은 단 한 번만 선언됩니다.
	// 선언부에 작성한 변수들은 전역변수로 취급되어 외부 어디서건 호출이 가능합니다.
	Random random = new Random();
	List<String> roles = new ArrayList<>();
	String job;
%>
<%
	if(roles.size() >= 10){
		roles.clear();
	}
	int role = random.nextInt(5) + 1;
	switch(role){
	case 1:
		job = "전사";
		roles.add("전사");
		break;
	case 2:
		job = "마법사";
		roles.add("마법사");
		break;
	case 3:
		job = "도적";
		roles.add("도적");
		break;
	case 4:
		job = "사제";
		roles.add("사제");
		break;
	case 5:
		job = "사냥꾼";
		roles.add("사냥꾼");
		break;
	}
	// 파티에 같은 직업이 몇 명있는지 찾는 작업.
	int samePlayers = Collections.frequency(roles, roles.get(roles.size() - 1));
	int count = 0;
	for(String player : roles){
		if(job.equals(player)){
			count++;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>당신의 역할</h1>
	<p>
		당신에게 부여된 역할은 <b>[ <%= roles.get(roles.size() - 1) %> ]</b>입니다.<br>+-/ 
		현재 파티에 당신과 같은 역할을 가진 플레이어는 <%= samePlayers %>, <%= count %>명 입니다.<br>
		현재 파티 구성<br>
		<%= roles %>(<%= roles.size() %>명 참가중)<br>
	</p>
</body>
</html>