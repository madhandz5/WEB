<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>문자열 관련 함수 태그</h3>
	문자열 관련 태그는 el안에서 사용하거나 value속성에서 사용한다.
	<c:set var="str" value="how are you?" />
	str : ${str }
	<br> 모두 대문자로 : ${fn:toUpperCase(str) }
	<br> 모두 소문자로 : ${fn:toLowerCase(str) }
	<br> are의 위치는? : ${fn:indexOf(str,"are") }
	<br> str에서 how를 where로 바꾼다. : ${fn:replace(str,"how","where") }
	<br> 문자열의 길이를 반환해준다. : ${fn:length(str) }
	<br> are 분리 추출 : ${fn:substring(str,4,7) }

</body>
</html>