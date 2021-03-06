<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="KO">
<head>
<meta charset="UTF-8">
<!--viewport: 모바일브라우저에서 사용하는 가상의 window
  	데스크탑의 사이트를 모바일에 표시하려고 하면 좁은 모바일 화면에 사이트를 표시하려다 보니
  	요소들의 크기가 작아져 사용자가 사용하기 불편해진다. 확대해서 보든가 해야함...
  	이때 viewport메타태그를 이용하면 너비나 배율을 조정할 수 있다.
  	width: 넓이
  	initial-scale : 배율
  	웹환경에서는 무시되는 태그이다.
    -->
<meta name="viewport" content="width=device-width, initial-scale=2.0">
<link rel="stylesheet" href="/servletBM/resources/css/common.css" />
<!-- 
		orientation:portrait //단말기 세로방향
		orientation:landscape //단말기 가로방향

		min-aspect-ratio : 최소 화면 비율
		max-aspect-ratio : 최대 화면 비율
		
		브라우저화면상에서는 깨져서 나옴 ㅠㅠ 하지마셈
	 -->
<link rel="stylesheet" media="screen and (min-aspect-ratio:4/3) "
	href="/servletBM/resources/css/Web.css" />
<link rel="stylesheet" media="screen and (max-aspect-ratio:4/3)"
	href="/servletBM/resources/css/Mob.css" />
<link rel="stylesheet" href="/servletBM/resources/css/icon/all.css" />

<title>Document</title>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/top.jsp"%>
	<%@include file="../include/floatDiv.jsp"%>
	<div class="content">
		<section class="middle">
			<div class="siteTitleWrapper">
				<div class="siteTitle">
					<div class="sitetitle">U CLASS 도서관</div>
					<div class="search">
						<form action="<%=request.getContextPath()%>/book/booksearch.do">
							<div class="searchButton">
								<p>검색</p>
							</div>
							<input Type="text" name="searchBook" placeholder="검색어를 입력하세요">
							<button value="" class="searchIcon">
								<i class="fas fa-search" style="color: black"></i>
							</button>
						</form>
					</div>
				</div>
			</div>
		</section>

		<nav class="planShop">
			<div class="planShopMenu">
				<div class="ps-1">
					<a href="/servletBM/notice/noticelist.do"> <i
						class="far fa-clipboard"></i>
						<p>공지사항</p>
					</a>
				</div>
				<div class="ps-2">
					<i class="fas fa-search-plus"></i>
					<p>도서검색</p>
				</div>
				<div class="ps-3">
					<i class="far fa-question-circle"></i>
					<p>QnA</p>
				</div>
				<div class="ps-4">
					<i class="fas fa-users"></i>
					<p>AboutUs</p>
				</div>
			</div>
		</nav>

		<section class="product">
			<div class="productWrapper">
				<div class="productBox">
					<div class="issueTitle">
						<span>인기 도서</span>
					</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>

						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>

					</div>
					<div class="issueTitle">스테디셀러</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
					<div class="issueTitle">최근 대출 도서</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
					<div class="issueTitle">최근 입고 도서</div>
					<div class="productLine">
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
						<div class="productItem">
							<div class="bookImg">
								<img src="/servletBM/resources/image/비행운.jpg">
							</div>
							<div class="bookTitle">
								비행운<br>작가:김애란
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<footer class="bottom"> bottom </footer>

	</div>
</body>
</html>
