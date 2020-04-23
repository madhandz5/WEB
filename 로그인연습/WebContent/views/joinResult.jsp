<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.prac.login.model.vo.Member"%>

<%
	String result = (String) request.getAttribute("isSuccess");
	Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=result%></h1>
	<h1><%=member.getmNo() %></h1>
	<h1><%=member.getmId() %></h1>
	<h1><%=member.getmGender() %></h1>
	

</body>
</html>