<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지입니다!</h1>

	<form action="<%=request.getContextPath()%>/uclass/memberjoin"
		method="post">
		<span>아이디 : </span><input type="text" name="userId"><br>
		<span>비밀번호 : </span><input type="password" name="userPwd"><br>
		<select name="gender">
			<option value="male">남자</option>
			<option value="female">여자</option>
		</select> <br> <input type="submit" value="가입"><input type="reset"
			value="리셋">
	</form>
</body>
</html>