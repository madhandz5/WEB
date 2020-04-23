<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>fmt : formatDate 사용법</h1>
	<hr>
	<h3>fmt:formatDate 태그 : 날짜와 시간에 포맷 적용하는 태그</h3>
	value 속성에는 java.util.Date 객체를 사용해야 합니다.
	<fmt:formatDate value="<%=new Date()%>" />
	<c:set var="current" value="<%=new Date()%>" />

	<ul>
		<li>오늘 날짜 : <fmt:formatDate value="${current }" /></li>
		<li>현재 시간 : <fmt:formatDate value="${current }" type="time" /></li>
		<li>날짜 & 시간 : <fmt:formatDate value="${current }" type="both" /></li>
		<li>[full,short] : <fmt:formatDate value="${current }"
				type="both" dateStyle="full" timeStyle="short" /></li>
		<li>[full,medium] : <fmt:formatDate value="${current }"
				type="both" dateStyle="full" timeStyle="medium" /></li>
		<li>[full,long] : <fmt:formatDate value="${current }" type="both"
				dateStyle="full" timeStyle="long" /></li>

		<li>내 패턴 : <fmt:formatDate value="${current }" type="both"
				pattern="yyyy-MM-dd(E) hh:mm:ss(a)" /></li>
	</ul>

	<h3>
		fmt:setLocals : 지역대 설정하는 태그<br> fmt:timeZone : 시간대 설정하는 태그
	</h3>
	<fmt:timeZone value="Pacific/Oakland">
	오클랜드 현재시간 :<fmt:formatDate value="${current }" type="both" />
	</fmt:timeZone>

	<hr>
	<h3>fmt:formatNumber : 숫자 데이터 포맷 지정태그</h3>
	일반숫자 : 123456
	<br>천단위 구분 :
	<fmt:formatNumber value="123456" groupingUsed="true" />
	<br>금액 :
	<fmt:setLocale value="en_us" />
	<fmt:formatNumber value="10000000" type="currency" />
	<br>금액 :
	<fmt:setLocale value="ja_jp" />
	<fmt:formatNumber value="10000000" type="currency" />
	<br>금액 :
	<fmt:setLocale value="ko_kr" />
	<fmt:formatNumber value="10000000" type="currency" />
	<br>


</body>
</html>