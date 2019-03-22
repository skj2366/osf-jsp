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
		<td>${pBoard.pb_num}</td>
		<td><img title="${pBoard.pb_file_path}"
		width="30" src="${pBoard.pb_real_path}"
		alt="${pBoard.pb_file_path}">
		${pBoard.pb_title}</td>
		<td>${pBoard.pb_credat}</td>
		<td>${pBoard.pb_cretim}</td>
	</tr>
</table>
</body>
</html>