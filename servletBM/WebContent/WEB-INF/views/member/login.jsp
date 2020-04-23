<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/servletBM/resources/css/common.css" />
<link rel="stylesheet" href="/servletBM/resources/css/icon/all.css" />
</head>
<link rel="stylesheet" href="/servletBM/resources/css/web.css" />
<body>


	<div class="wrap">
		<div class="memberBox">
			<div class="login">
				<form action="<%=request.getContextPath()%>/member/loginimple.do"
					method="POST">
					<p>사용자이름</p>
					<input class="loginText" type="text" name="id" /> <span
						id="checkMsg" class="checkMsg"></span>
					<p>비밀번호</p>
					<input class="loginText" type="password" name="pw" /> <span
						class="btn">
						<button>LogIn</button>
					</span>
				</form>
			</div>
		</div>
	</div>
	<script>
		<c:if test="${data.reCheck == true}">
		document.querySelector("#checkMsg").textContent = "아이디 혹은 비밀번호를 확인하세요";
		</c:if>
	</script>

</body>
</html>