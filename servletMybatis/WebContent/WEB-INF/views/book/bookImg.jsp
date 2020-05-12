<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="bm.book.model.vo.Book"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<%
	List<Book> bl = (List<Book>) request.getAttribute("data");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
html, body {
	height: 100%;
}

.wrapper {
	height: 100%;
}

.book {
	width: 70%;
	float: left;
}

.imgDiv {
	width: 125px;
	height: 175px;
	border: 1px solid black;
	float: left;
}

.Bookwrapper {
	overflow: hidden;
}

.Bookwrapper div {
	float: left;
}

.bookImg {
	width: 70px;
	height: 30px;
	border: 1px solid black;
	margin: 1%;
	font-size: 5px;
	overflow: hidden;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<!-- html5 dataset
	html 태그에 커스텀속성을 줄 수 있다.
	속성명을 data- 로 시작하면
	자바스크립트에서 해당 html 엘리먼트의 dataset 속성을 사용해
	속성의 값을 가져올 수 있다.
	
	<div id="test" class ="bookImg" 
	data-isbn='111111111'
	data-title='감자'
	data-author='점순이'
	></div>
	
	
	var test = document.querySelector('#test');
	test.dataset.isbn -> 111111111
	test.dataset.title = 감자
	test.dataset.author = 점순이
 -->

	<div class="wrapper">
		<div class="book">
			<div class="Bookwrapper">

				<%
					for (int i = 1; i <= bl.size(); i++) {
						String isbn = bl.get(i - 1).getbIsbn();
						String title = bl.get(i - 1).getbTitle();
						if (i % 10 != 0) {
				%>

				<div class="bookImg" data-isbn="<%=isbn%>"><%=title%></div>

				<%
					} else {
				%>
				<div class="bookImg" data-isbn="<%=isbn%>"><%=title%></div>
			</div>
			<div class="Bookwrapper">
				
				<%
					}
					}
				%>
			</div>
		</div>

		<div class="imgDiv"></div>
	</div>
	
	<script type="text/javascript">
	
	document.querySelectorAll('.bookImg').forEach(function(v) {
		v.addEventListener('click', function(e) {
			document.querySelector('.imgDiv').innerHTML = 
				'<img src = "/servletBM/resources/img/' + e.target.dataset.isbn+'.jpg">'
		})
	})
	
	
	
	</script>































</body>
</html>