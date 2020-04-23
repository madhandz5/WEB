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
	<h1>EL(Expression Language) 사용해보기</h1>
	<table BORDER="1">
		<thead>
			<tr>
				<td><b>EL Expression</b></td>
				<td><b>Result</b></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>\${1 }</td>
				<td>${1 }</td>
			</tr>
			<tr>
				<td>\${1+2 }</td>
				<td>${1+2 }</td>
			</tr>
			<tr>
				<td>\${1.2+2.3 }</td>
				<td>${1.2+2.3 }</td>
			</tr>
			<tr>
				<td>\${3-2 }</td>
				<td>${3-2 }</td>
			</tr>
			<%--<tr>
				<td>\${ 3 div 1}</td>
				<td>${3 div 1 }</td>
			</tr>--%>
			<tr>
				<td>\${3/0 }</td>
				<td>${3/0 }</td>
			</tr>
			<tr>
				<td>\${1 %2 }</td>
				<td>${1 %2 }</td>
			</tr>
			<tr>
				<td>\${1 mod 2 }</td>
				<td>${1 mod 2 }</td>
			</tr>
			<tr>
				<td>\${(1==2)?3:4 }</td>
				<td>${(1==2)?3:4 }</td>
			</tr>
		</tbody>
	</table>



</body>
</html>