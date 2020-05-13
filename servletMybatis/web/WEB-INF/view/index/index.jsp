<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/header.jsp" %>
</head>
<body>
<%@include file="../include/floatDiv.jsp" %>
 <div class="content">
	<section class="middle"> 		
		<div class="siteTitleWrapper">
	 		<div class="siteTitle">
				<div class="sitetitle">U CLASS 도서관 </div>
					<div class="search">
						<form action="/servletBM/book/search.do">
						<div class="searchButton"><p>검색</p></div>			
						<input Type ="text" name="b_title" placeholder="검색어를 입력하세요">
						<button value="" class="searchIcon"><i class="fas fa-search" style="color:black"></i></button>
					</form>
				</div>
	 		</div>
	 	</div>
 	</section> 
	
	<nav class="planShop">
		<div class="planShopMenu">
			<div class="ps-1">
			<a href="/servletBM/notice/noticelist.do"><i class="far fa-clipboard"></i>
			<p>게시판</p></a>
			</div>
		</div>
	</nav>

</div>

<script>
	
	document.querySelectorAll('.productItem').forEach(function(v){
		v.addEventListener('mouseover',function(){
			v.lastElementChild.style.display = 'block';
		})
		
		v.addEventListener('mouseout',function(){
			v.lastElementChild.style.display = 'none';
		})
	})


</script>



</body>
</html>
