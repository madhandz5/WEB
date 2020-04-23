<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- response.getStatus() -->
	<h1>에러가 발생했군요!</h1>
	<br>
	<%
		int status = response.getStatus();
		String msg = "";
		if (status == 404) {
			msg = "404번 에러입니다. form 의 action, web.xml의 url-mapping, servlet의 forward() 파일이름을 확인하세요.";
		} else if (status == 500) {
			msg = "500번 에러입니다. 콘솔창 확인하세요.";
		}
	%>
	<h3>
		status code가
		<%=status%>입니다.
	</h3>
	<br>
	<%=msg%><br>
	<%
		if (exception != null) {
	%>
	<%=exception.getMessage()%>

	<%
		}
	%>
	<br>
	<img src="/JSPPJ/resources/img/we.jpg" style="width: 300px"
		style="height:500px">


</body>
</html>