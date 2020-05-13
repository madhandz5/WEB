<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bm.book.model.vo.Book" %>    
<%@ page import="java.util.List" %>
<% List<Book> bl = (List<Book>)request.getAttribute("bookList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	html,body{
		height:100%;
	}
	
	.wrapper{
		height:100%;
	}

	.book{
		width : 70%;
		float:left;
	}
	
	.imgDiv{
		width:125px;
		height:175px;
		border:1px solid black;
		float:left;
	}
	
	.Bookwrapper{
		overflow: hidden;
	}
	
	.Bookwrapper div{
		float:left;
	}
	
	.bookImg{
		width:70px;
		height:30px;
		border:1px solid black;
		margin:1%;
		font-size:5px;
		overflow: hidden;
	
	}

</style>
</head>
<body>

<!-- html5 dataset 
	태그에 커스텀 속성을 줄 수 있다.
	이때 속성명을 data- 로 시작한다면
	자바스크립트에서 dataset 속성을 사용해 속성의 값을 사용할 수 있다.
 -->
<div class="wrapper">
		<div class="book">
			<div class="Bookwrapper">
			<%
			 	for(int i = 1; i <= bl.size(); i++){
			 		String isbn = bl.get(i-1).getB_isbn();
			 		String title = bl.get(i-1).getB_title();
			 		if(i%10 != 0){
			%>
			 			<div class="bookImg" data-isbn="<%= isbn %>"><%= title %></div>
 			
			<%
			 		}else{
			%> 			
			 			<div class="bookImg" data-isbn="<%= isbn %>"><%= title %></div>
			 			</div>
			 			<div class="Bookwrapper">
			<%			
			 		}
			%>		
			<%	
			 	}
			%>
			</div>
		</div>
		<div class="imgDiv">
		
		
		</div>
</div>
<script>
	document.querySelectorAll('.bookImg').forEach(function(v){
		v.addEventListener('click',function(e){
			e.target.backgroundColor='red';
			document.querySelector('.imgDiv').innerHTML=
				'<img src="/servletBM/resources/img/' + e.target.dataset.isbn + '.jpg">'
		})
	})
</script>

</body>
</html>