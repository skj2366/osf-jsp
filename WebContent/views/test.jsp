<%@page import="com.osf.test.vo.PhotoBoardVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("str", "테스트");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>In</title>
</head>
<body>
${str}
</body>
</html>