<%@page import="org.apache.naming.java.javaURLContextFactory"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
span {
	width: 150px;
}
</style>
</head>
<body>
	<h1>Test Core Page</h1>
	<h3>c:set 으로 변수 만들기</h3>
	<c:set var="num1" value="100" />
	<c:set var="num2" value="200" />
	<c:set var="result" value="${num1+num2 }" />
	result 값 :
	<c:out value="${result }"></c:out>


	<h3>array 확인</h3>
	<c:set var="arr" scope="request">
	red,blue,grey,pink,green
	</c:set>
	<span>array 배열값 : ${arr }</span>
	<br>

	<h3>값 remove</h3>
	<c:remove var="result" />
	<span>result 값 재확인</span>
	<br>
	<span>result 값 : ${result}</span>
	<h4>c:out :출력 기능 제공 태그</h4>
	<span>그대로 출력 : </span>
	<c:out value="<h2>태그로 출력하기</h2>" escapeXml="true" />
	<span>태그로 출력 : </span>
	<c:out value="<h2>태그로 출력하기</h2>" escapeXml="false" />
	<span>전송온 값 출력 : </span>
	<c:out value="${param.no}" default="없음" />


	<h3>if문</h3>
	<c:if test="${num1>num2}">num1이 큽니다.</c:if>
	<c:if test="${num1<=num2}">num2가 같거나 큽니다.</c:if>

	<h4>Choose : like switch</h4>
	<c:set var="no" value="0"></c:set>
	<c:choose>
		<c:when test="${no eq 0 }">
		처음 뵙겠습니다.<br>
		</c:when>
		<c:when test="${no eq 1 }">
		다시 뵙게되어 반갑습니다.<br>
		</c:when>
		<c:otherwise>
		안녕하세요<br>
		</c:otherwise>
	</c:choose>
	<hr>
	<h4>c:forEach : for문과 같은 태그</h4>
	<c:forEach begin="1" end="10" var="i">
	
	반복 확인 : ${i}<br>

	</c:forEach>
	<br>
	<br>
	<br>
	<c:forEach var="color" items="${arr }">
		<span style="color:${color}">배열확인 : ${color }</span>
		<br>
	</c:forEach>

	<c:forEach var="i" begin="1" end="10" step="2">
	
		반복 확인 : ${i }<br>

	</c:forEach>
	<%
		java.util.ArrayList<String> bookList = new ArrayList<String>();
		bookList.add("java");
		bookList.add("oracle");
		bookList.add("html");
		bookList.add("css");
		bookList.add("javaScript");
		bookList.add("Servlet");
	%>

	<br>
	<br>
	<hr>
	<c:forEach var="title" items="<%=bookList%>" varStatus="status">
	번호 : ${status.index}, 순번:${status.count} 책이름 : ${title }<br>

	</c:forEach>
	<br>
	<br>
	<hr>
	<h3>c:forTokens : StringTokenizer와 같은 기능</h3>
	<ul style="background: black;">
		<c:forTokens var="color"
			items="yellow pink aqua green silver olive lime" delims=" ">
			<li style="background-color:${color};">${color }</li>
			<br>
		</c:forTokens>
	</ul>

	<h3>c:import : jsp:include 액션 태그와 같다.</h3>
	<c:import url="import.jsp"></c:import>
	<hr>
	<h3>c:catch 자바의 try~catch와 같음</h3>
	<c:set var="num3" value="null" />
	<c:set var="num4" value="77" />
	<c:catch var="e">
	나눈 결과 : ${num4/num3 }
	</c:catch>
	<c:if test="${e != null }">
	에러메시지 : ${e.message }
	</c:if>

	<h3>c:redirect : response.sendRedirect() 와 같음</h3>
	해당 기능 주석처리 되어있음. 코드 확인할것.
	<%-- <c:redirect url="../index.jsp" /> --%>


</body>
</html>