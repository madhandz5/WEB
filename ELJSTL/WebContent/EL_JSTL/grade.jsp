<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>점수를 입력하시오</h1>

	<form action=<%=request.getContextPath()%>/grade>
		<label>이름 : </label><input type="text" name="name"><br> <label>수학
			점수 : </label> <input type="text" name="math"><br> <label>영어
			점수 : </label> <input type="text" name="eng"><br> <label>국어
			점수 : </label> <input type="text" name="kor"><br> <input
			type="submit" value="내 등급은?">
	</form>
</body>
</html>