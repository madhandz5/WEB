<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<script type="text/javascript">
init = function ()
{
	 // Print Alert Message
    <c:if test="${data.alertMsg != null}">
    	alert("<c:out value="${data.alertMsg}"/>");
    </c:if>
    
    <c:if test="${data.back != null}">
		history.back();
	</c:if>
	
	<c:if test="${data.url != null}">
    	location.href="<c:out value="${data.url}"/>";
    </c:if>
};

init();
</script>

</body>
</html>