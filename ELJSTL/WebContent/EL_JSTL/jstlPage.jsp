<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL PAGE</h1>

	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<c:forEach items="${sList}" var="score">
			<tr>
				<td>${score.name}</td>
				<td>${score.kor}</td>
				<td><c:if test="${score.eng }">=90}>
						<c:out value="멋져" />
					</c:if></td>
				<td>${score.math}</td>
				<td>${score.sum}</td>
				<td>${score.avg}</td>
				<td><c:choose>
						<c:when test="${score.grade eq 'A' || score.grade=='B' }">
							<c:out value="PASS" />
						</c:when>
						<c:otherwise>
							<c:out value="FAIL" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>