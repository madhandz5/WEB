<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP �⺻ ���</h1>

	<%
		int total = 0;
		for (int i = 1; i < 11; i++) {
			total += i;
	%>

	<h5><%=total%></h5>

	<%
		}
	%>


	<%
		int a = 1;
		int b = 10;
		int sum = 0;
		for (int i = 0; i <= b; i++) {
			sum += i;
		}
	%>
	<h3><%=a%>����<%=b%>������ ����<span style="color: blue"><%=sum%></span>
	</h3>

	<%
		for (int i = 0; i <= b; i++) {
			sum += i;
	%>

	<h3><%=i + sum%>
		<span style="color: blue"> =<%=sum%>�Դϴ�.
		</span>
	</h3>

	<%
		}
	%>


</body>
</html>