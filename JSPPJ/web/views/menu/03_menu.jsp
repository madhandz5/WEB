<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="../include/top.jsp"%>
	<h2>메뉴 주문 시스템</h2>
	<h3>메뉴를 선택하세요.</h3>
	<form action="<%=request.getContextPath()%>/menuOrder" method="get">
		<select name="menu" multiple="multiple">
			<option value="피자">피자</option>
			<option value="떡볶이">떡볶이</option>
			<option value="치킨">치킨</option>
			<option value="연어">연어</option>
		</select>
		<button type="submit">메뉴 전송</button>
	</form>

</body>
</html>