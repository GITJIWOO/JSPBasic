<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>수정 창</h1>
	<form action="http://localhost:8181/MyFirstWeb/boardupdateok.do" method="post">
		<input type="hidden" value="${boardDetail.bId }" name="bId" />
		<input type="hidden" value="${boardDetail.bHit }" name="bHit" />
		<input type="hidden" value="${boardDetail.bDate }" name="bDate" />
		<input type="hidden" value="${boardDetail.bName }" name="bName" />
		<!-- hidden 태그를 이용해 나머지 요소들도 다 첨부해주세요. -->
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
				<td><input type="text" name="bTitle" value="${boardDetail.bTitle }"></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea rows="10" cols="50" name="bContent">${boardDetail.bContent }</textarea></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정" />
					<input type="reset" />
					<a href="/MyFirstWeb/boarddetail.do?bId=${boardDetail.bId }"><input type="button" value="돌아가기"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>