<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div>
		<br> <br> <br> <br> <br> <span>아이디 :
			${sessionScope.loginInfo.m_id }</span><br>
		<form action="/servletBM/member/modifypw.do" method="post">
			<span>비밀번호 </span><input type="password" name="newPwd">
			<input type="submit" value="비밀번호 수정"><br>
		</form>
		<span>이메일 : ${sessionScope.loginInfo.m_email }</span><br> <span>전화번호
			: ${sessionScope.loginInfo.m_tell }</span><br> <span>회원등급 :
			${sessionScope.loginInfo.m_grade }</span>
	</div>


</body>
</html>