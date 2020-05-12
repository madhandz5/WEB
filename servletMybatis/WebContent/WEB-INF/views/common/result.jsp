<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		init = function() {
			<c:if test="${data.alertMsg != null}">
			//print alert message
			alert("<c:out value="${data.alertMsg}"/>");
			</c:if>
			<c:if test="${data.back != null}">
			history.back();
			</c:if>
			<c:if test="${data.url !=null}">
			location.href = "<c:out value="${data.url}"/>";
			</c:if>
		}
		init();
	</script>

</body>
</html>