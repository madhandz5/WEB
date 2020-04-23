<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL PAGE</h1>

	<table border="1">
		<tr>
			<th colspan="2">${score.name}</th>
		</tr>
		<tr>
			<th>국어</th>
			<td>${garde.kor}</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>${garde.eng}</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>${garde.math}</td>
		</tr>
		<tr>
			<th>평균</th>
			<td>${garde.avg}</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${garde.grade}</td>
		</tr>
	</table>
</body>
</html>