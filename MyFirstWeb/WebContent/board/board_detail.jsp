<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 확인</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<td>${board.bId }</td>
			<th>조회수</th>
			<td>${board.bHit }</td>
		</tr>
		<tr>
			<th>쓴 날짜</th>
			<td>${board.bDate }</td>
		</tr>
		<tr>
			<th>글 쓴이</th>
			<td>${board.bName }</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td>${board.bTitle }</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td><textarea rows="10" cols="50" name="content" readonly> ${board.bContent }</textarea></td>
		</tr>
		<tr>
			<td>
				<a href="/MyFirstWeb/boardselect.do">
					<input type="button" value="목록">
				</a>
				<form action="/MyFirstWeb/boarddelete.do" method="post">
					<input type="hidden" value="${board.bId }" name="bId" />
					<input type="submit" value="삭제" />
				</form>
				<form action="/MyFirstWeb/boardupdate.do">
					<input type="hidden" value="${board.bId }" name="bId" />
					<input type="submit" value="수정" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>