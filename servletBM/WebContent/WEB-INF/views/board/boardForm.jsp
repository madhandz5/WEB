<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 완벽해 이부분 -->
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="Menu">
		<div class="MenuBox"></div>
	</div>

	<div class="notice">
		<h2>
			<span>*공지사항</span>
		</h2>
	</div>

	<form action="/servletBM/notice/upload.do" method="post"
		enctype="multipart/form-data">
		<div class="notice-detail">
			<div class="notice-title">
				제목 : <input type="text" name="noticeTitle" />
			</div>
			<input type="file" name="noticeFile" />
			<div class="text">
				<textarea cols="50" rows="10" name="noticeContent"></textarea>
			</div>
			<div class="section-button">
				<input type="submit" value="전송" />
			</div>
		</div>
	</form>
</body>
</html>