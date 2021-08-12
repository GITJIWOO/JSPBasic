<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>게시글 목록</h1>
	<!-- 테이블 형태로 작성해보겠습니다.
		출력할 자료들은
		글번호, 글제목, 글쓴이, 글쓴날짜, 조회수 순으로 테이블에 출력해주시면됩니다.
		JSTL의 forEach구문을 쓰시되, items속성에 "${boardList}"를 넣어주시면 됩니다. -->
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>글쓴이</th>
			<th>글쓴 날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${boardList}">
			<tr>
				<td>${list.bId}</td>
				<td><a href="/MyFirstWeb/boarddetail.do?bId=${list.bId }">${list.bTitle}</a></td>
				<td>${list.bName}</td>
				<td>${list.bDate}</td>
				<td>${list.bHit}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<form action="/MyFirstWeb/board/board_write_form.jsp" method="post">
		<input type="hidden" name="logout">
		<input type="submit" value="글쓰기">
	</form>
	<br/>
	<form action="/MyFirstWeb/userlogout.do" method="post">
		<input type="hidden" name="logout">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>