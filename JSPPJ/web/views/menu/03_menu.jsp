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
	<h2>�޴� �ֹ� �ý���</h2>
	<h3>�޴��� �����ϼ���.</h3>
	<form action="<%=request.getContextPath()%>/menuOrder" method="get">
		<select name="menu" multiple="multiple">
			<option value="����">����</option>
			<option value="������">������</option>
			<option value="ġŲ">ġŲ</option>
			<option value="����">����</option>
		</select>
		<button type="submit">�޴� ����</button>
	</form>

</body>
</html>