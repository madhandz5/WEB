<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/common.css" />
<link rel="stylesheet" href="../resources/css/icon/all.css" />
<link rel="stylesheet" media="screen and (min-width: 1100px)"
	href="../resources/css/web.css" />
<title>Document</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="content">
		<div class="Menu">
			<div class="MenuBox"></div>
		</div>

		<h2>
			<span>*공지사항</span>
		</h2>
	</div>
	<div class="notice">
		<div class="notice-detail">
			<div class="notice-title">
				<h4 class="reset">${data.notice.noticeTitle }</h4>
			</div>
			<div class="info">
				<span>${data.notice.noticeDate }</span> <span><a
					href="/servletBM/notice/noticedownload.do">${data.notice.original_filepath }</span></a>
			</div>
			<div class="text">${data.notice.noticeContent }</div>
			<div class="section-button">
				<a href="/servletBM/notice/noticelist.do"><span>목록</span></a>
			</div>
		</div>
	</div>
</body>
</html>