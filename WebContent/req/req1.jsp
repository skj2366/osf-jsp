<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setAttribute("종인","commit");//1개의 http까지()
pageContext.setAttribute("난","누구?"); // 한 페이지.
session.setAttribute("backend","뒤끝"); // 한 브라우저. 
application.setAttribute("왜웃어","같이웃자"); // 한 어플리케이션.
RequestDispatcher rd = request.getRequestDispatcher("/req/req2.jsp");
// 디스패처, 전달자 . 셋팅한 값을 req2로 전달해준다.
rd.forward(request, response);
%>
