<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>작성시간</th>
	</tr>
<c:forEach var="pBoard" items="${pBoardList}">
	<tr>
		<td>${pBoard.pbNum}</td><!-- get 메서드의 이름을 따라간당.~ -->
		<td><img title="${pBoard.pbFilePath}" 
		width="30" src="${pBoard.pbRealPath}"
		alt="${pBoard.pbFilePath}">
		${pBoard.pbTitle}</td>
		<td>${pBoard.pbCredat}</td>
		<td>${pBoard.pbCretim}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>