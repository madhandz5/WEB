<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/header.jsp"%>

<link rel="stylesheet" href="/servletBM/resources/css/book.css" />
</head>
<body>

	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="Menu">
		<div class="MenuBox"></div>
	</div>
	<br>
	<br>
	<h1 style="text-align: center;">도서검색결과</h1>
	<hr>
	<section class="recentBook">
		<div class="recentBookWrapper">
			<div class="recentBookBox">
				<div class="recentBookLine">
					<c:forEach items="${data.searchList }" var="list">
						<div class="productItem">
							<div>
								<img
									src="<%=request.getContextPath()%>/resources/image/book/${list.bIsbn }.jpg">
							</div>
							<div class="bookTitle">
								${list.bTitle }<br> ${list.bAuthor }
							</div>
							<div class="bookUse" id="bookUse">
								<div>
									<a href="/servletBM/book/rentbook.do">대출</a>
								</div>
								<div>
									<a href="/servletBM/book/detail.do?b_isbn=${list.bIsbn}">상세보기</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>

	<footer class="bottom"> bottom </footer>
	<script>
		document.querySelectorAll('.productItem').forEach(function(v) {
			v.addEventListener('mouseover', function() {
				v.lastElementChild.style.display = 'block';
			})

			v.addEventListener('mouseout', function() {
				v.lastElementChild.style.display = 'none';
			})
		})
	</script>


</body>
</html>