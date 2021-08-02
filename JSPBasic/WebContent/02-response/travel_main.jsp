<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 안내 페이지</title>
</head>
<body>
	<%-- 1. 폼을 만들어주세요. 폼은 travel_check.jsp를 목적지로 가집니다.
		2. post방식으로 데이터를 전송합니다.
		3. radio 버튼으로 관심사에 대한 항목을 나열합니다.
		4. radio를 선택하고 submit을 누르면 각 radio의 value값을 분석해
			travel_check.jsp 내부로직이 travel_도시이름.jsp로
			리다이렉트 해 줍니다.
		5. travel_도시이름.jsp 결과페이지에는 관련도시의 유튜브 동영상을 게시해주시면 됩니다. --%>
	<form action="travel_check.jsp" mathod="get">
		<input type="radio" name="travel" value="canada">캐나다 - 옐로나이프<br/>
		<input type="radio" name="travel" value="iceland">아이슬란드 - 레이캬비크<br/>
		<input type="submit"><br/>
	</form>
</body>
</html>