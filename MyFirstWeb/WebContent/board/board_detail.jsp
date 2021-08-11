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
			<td>${boardDetail.bId }</td>
			<th>조회수</th>
			<td>${boardDetail.bHit }</td>
		</tr>
		<tr>
			<th>쓴 날짜</th>
			<td>${boardDetail.bDate }</td>
		</tr>
		<tr>
			<th>글 쓴이</th>
			<td>${boardDetail.bName }</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td>${boardDetail.bTitle }</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td><textarea rows="10" cols="50" name="content" readonly> ${boardDetail.bContent }</textarea></td>
		</tr>
		<tr>
			<td>
				<a href="/MyFirstWeb/boardselect.do">
					<input type="button" value="목록">
				</a>
				<form action="/MyFirstWeb/boarddelete.do" method="post">
					<input type="hidden" value="${boardDetail.bId }" name="bId" />
					<input type="submit" value="삭제" />
				</form>
				<form action="/MyFirstWeb/boardupdate.do">
					<input type="hidden" value="${boardDetail.bId }" name="bId" />
					<input type="submit" value="수정" />
				</form>
			</td>
		</tr>
	</table>
</body>
</html>