<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>환영합니다!</h1>

	<form action="<%=request.getContextPath()%>/uclass/login" method="post">
		<span>아이디 : </span><input type="text" name="userId"
			placeholder="아이디를 입력하세요"><br> <span>비밀번호 : </span><input
			type="password" name="userPwd"><br> <input type="submit"
			value="로그인">
	</form>
	<BUTTON onclick="location.href='memberJoin.jsp'">회원가입</BUTTON>
</body>
</html>