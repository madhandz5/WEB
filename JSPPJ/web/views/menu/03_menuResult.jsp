<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String[] menu = (String[]) request.getAttribute("menu");
	int price = (int) request.getAttribute("price");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메뉴 주문결과 확인</h1>
	<hr>
	<h3>이용해 주셔서 감사합니다.</h3>

	<%
		for (int i = 0; i < menu.length; i++) {
	%>
	<h5><%=menu[i]%></h5>
	<%
		}
	%>
	<h5>
		의 결제 금액은
		<%=price%>
		원 입니다.
	</h5>

</body>
</html>