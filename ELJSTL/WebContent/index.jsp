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
	<a href="EL_JSTL/testCore.jsp?no=123">testCore 페이지로 이동</a>
	<c:url var="tc" value="EL_JSTL/testCore.jsp">
		<c:param name="no" value="54321" />
	</c:url>
	<br>
	<a href="${tc }">testCore페이지 이동</a>

</body>
</html>