<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="Menu">
		<div class="MenuBox"></div>
	</div>
	<div class="notice">
		<h2>
			<span>*게시판</span>
		</h2>
	</div>

	<form action="/servletBM/notice/upload.do" method="post"
		enctype="multipart/form-data">
		<div class="notice-detail">
			<div class="notice-title">
				제목 : <input type="text" name="noticeTitle" /> 작성자명 : <input
					type="text" name="noticeWriter" /> 비밀번호 : <input type="text"
					name="noticePassword" />
			</div>
			<input type="file" name="file" />
			<div class="text">
				<textarea cols="150" rows="15" name="noticeContent"
					style="resize: none;"></textarea>
			</div>
			<div class="section-button">
				<button>전송</button>
			</div>
		</div>
	</form>

</body>
</html>