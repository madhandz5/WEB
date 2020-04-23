<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<!-- 
	jsp action tag include 는 include 지시자와 같은 기능을 한다.
	단, include 지시자는 inline 방식인 반면 jsp action tag의 include는
	내부적으로 include 되는 jsp 호출하는 방식이다.
	 -->
	<%-- <jsp:include page="../include/top.jsp" /> --%>
	<h1>회원 가입 성공!</h1>
	<h3>--- 회원 정보 ---</h3>
	<p>
		ID :
		<%=mem.getmId()%><br> 비밀번호 :
		<%=mem.getmPwd()%><br> 전화번호 :
		<%=mem.getPhone()%>
	</p>
	<h1>jsp usebean 액션태그</h1>
	<h3>id, class, scope중 하나라도 다르면 새로운 객체가 생성이 된다.</h3>
	<h3>----회원정보----</h3>
	<jsp:useBean class="com.kh.jspPrac.member.model.vo.Member"
		id="pageMember" scope="page">

		<jsp:setProperty property="mId" value="user1" name="pageMember" />
		<jsp:setProperty property="mPwd" value="pass1" name="pageMember" />
		<jsp:setProperty property="phone" value="010-0000-0000"
			name="pageMember" />
	</jsp:useBean>

	<p>
		ID :
		<jsp:getProperty property="mId" name="pageMember" /><br> 비밀번호 :
		<jsp:getProperty property="mPwd" name="pageMember" /><br> 전화번호 :
		<jsp:getProperty property="phone" name="pageMember" />
	<h3>jsp usebean 액션태그</h3>
	<h3>id 와 class, scope가 모두 같은 객체가 존재하면 그 객체가 useBean 에 담긴다.</h3>
	<h3>---회원정보---</h3>

	<jsp:useBean class="com.kh.jspPrac.member.model.vo.Member" id="member"
		scope="request"></jsp:useBean>

	<p>
		ID :
		<jsp:getProperty property="mId" name="member" /><br> 비밀번호 :
		<jsp:getProperty property="mPwd" name="member" /><br> 전화번호 :
		<jsp:getProperty property="phone" name="member" />

	</p>

	<%-- <jsp:forward page="../01_jspSample.jsp"></jsp:forward> --%>
</body>
</html>