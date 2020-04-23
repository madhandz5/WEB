<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/common.css" />
<link rel="stylesheet" href="resources/css/icon/all.css" />
<link rel="stylesheet" media="screen and (min-width: 1100px)"
	href="resources/css/Web.css" />
<title>Document</title>
<%@ include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="content">
		<div class="notice">
			<h2>
				<span>*공지사항</span>
			</h2>

		</div>
		<div class="search-box">
			<table class="noticelist">
				<caption></caption>
				<thead>
					<tr>
						<th style="width: 10%; height: 20%;"><span>번호</span></th>
						<th style="width: 80%;"><span>제목</span></th>
						<th style="width: 10%;"><span>등록일</span></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data.nData }" var="notice">
						<tr>
							<td class="num"><strong class="warning">${notice.noticeNo }</strong></td>
							<td class="subject"><a
								href="/servletBM/notice/noticedetail.do?noticeNo=${notice.noticeNo }">${notice.noticeTitle }
							</a></td>
							<td class="date">${notice.noticeDate }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="paging">
				<!-- section pagination -->
				<!-- section pagination -->
				<a href="/servletBM/notice/noticelist.do" class="nav first"> <i
					class="fas fa-angle-double-left"></i></a> <a
					href="/servletBM/notice/noticelist.do?cPage=${data.paging.blockStart - 1}"
					class="nav prev"><i class="fas fa-angle-left"></i></a>

				<c:forEach begin="${data.paging.blockStart }"
					end="${data.paging.blockEnd }" var="page">
					<a href="/servletBM/notice/noticelist.do?cPage=${page}"
						class="num active"><span>${page}</span></a>
				</c:forEach>

				<a
					href="/servletBM/notice/noticelist.do?cPage=${data.paging.blockEnd + 1}"
					class="nav next"><i class="fas fa-angle-right"></i></a> <a
					href="/servletBM/notice/noticelist.do?cPage=${data.paging.lastPage}"
					class="nav last"><i class="fas fa-angle-double-right"></i></a>
			</div>
			<!-- // section pagination -->

		</div>

	</div>
</body>
</html>