<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class="topWrapper">
	<div class="top">
		<div class="topLogo">
			<b>UCLASS <br>HTML
			</b>
		</div>

		<div class="topSearchBar">
			<form action="<%=request.getContextPath()%>/book/booksearch.do">
				<input Type="text" name="searchBook" placeholder="검색어를 입력하세요">
				<button value="" class="">
					<i class="fas fa-search" style="color: black"></i>
				</button>
			</form>
		</div>

		<c:if test="${sessionScope.loginInfo == null }">
			<div class="topLogin">
				<a href="/servletBM/member/login.do">로그인</a> / <a
					href="/servletBM/member/join.do">회원가입</a>
			</div>
		</c:if>
		<c:if test="${sessionScope.loginInfo != null }">
			<div class="topLogin">
				<a href="/servletBM/mypage/mypage.do">${sessionScope.loginInfo.m_id }님
					환영합니다. MyPage</a> / <a href="/servletBM/member/logoutimple.do">Logout</a>
			</div>
		</c:if>
	</div>
	</header>
</body>
</html>