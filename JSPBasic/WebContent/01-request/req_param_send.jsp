<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form 내부에 input 4개를 만들어주세요
		input 태그의 type 속성은 하나는 text 하나는 password
		name 속성은 하나는 apple 하나는 banana 로 해주세요.
		제출버튼, 리셋버튼도 각각 하나씩 만들어주세요. -->
	<!-- form 태그의 action은 데이터가 전달될 목적지입니다. 
	현재, req_param_getpost로 날릴 예정입니다. -->
	<form action="req_param_getpost.jsp">
		<!-- 가장 기본이 되는 input태그 -->
		<input type="text" name="id">아이디<br>
		<input type="password" name="pw">비밀번호<br>
		<input type="text" name="nick">이름<br>
		
		<!-- 체크박스 -->
		취미 : 
		<input type="checkbox" name="hobby" value="요리">요리&nbsp;
		<input type="checkbox" name="hobby" value="운동">운동&nbsp;
		<br/>
		<!-- 특기 체크박스 추가, 최소 5개 이상 -->
		특기 : 
		<input type="checkbox" name="ability" value="게임">게임&nbsp;
		<input type="checkbox" name="ability" value="노래">노래&nbsp;
		<input type="checkbox" name="ability" value="공부">공부&nbsp;
		<input type="checkbox" name="ability" value="댄스">댄스&nbsp;
		<input type="checkbox" name="ability" value="축구">축구&nbsp;
		<br/>
		<!-- 성볍은 하나만 골라야 하므로 radio를 사용합니다 -->
		성별 : 
		<input type="radio" name="gender" value="male">male&nbsp;
		<input type="radio" name="gender" value="female">female&nbsp;
		<br/>
		<!-- 다른 radio그룹을 하나 더 만들어서 처리합니다. -->
		학년 : 
		<input type="radio" name="School year" value="1학년">1학년&nbsp;
		<input type="radio" name="School year" value="2학년">2학년&nbsp;
		<input type="radio" name="School year" value="3학년">3학년&nbsp;
		<input type="radio" name="School year" value="4학년">4학년&nbsp;
		<input type="radio" name="School year" value="5학년">5학년&nbsp;
		<input type="radio" name="School year" value="6학년">6학년&nbsp;
		<br/>
		<!-- select태그는 선택지를 드롭박스로 줍니다. -->
		<select name="region">
			<option>서울</option>
			<option>경기</option>
			<option>충청</option>
			<option>전라</option>
			<option>경상</option>
			<option>강원</option>
			<option>제주</option>
		</select>
		<br/>
		<input type="submit">
		<input type="reset">
	</form>
</body>
</html>