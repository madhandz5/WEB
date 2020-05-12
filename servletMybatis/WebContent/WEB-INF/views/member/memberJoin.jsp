<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="../common/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
에러페이지 테스트를 위한 에러코드
<% 
String str = null;
	str.charAt(1);
%> 
--%>
	<h1>직원 가입 양식</h1>
	<form action="<%=request.getContextPath()%>/member/joinemailcheck.do"
		method="post" onsubmit="return validate();">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="userId" id="userId" size="10">
					<button type="button" onclick="idCheck()">아이디확인</button> <br>
				<span id="idCheckMsg"></span></td>

			</tr>
			<tr>
				<td>PassWord :</td>
				<td><input type="Password" name="userPwd" id="userPwd"
					size="10"></td>
			</tr>
			<tr>
				<td>휴대폰번호 :</td>
				<td><input type="text" name="m_tell" id="m_tell" size="13"></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input type="text" name="m_email" id="m_email"></td>
			</tr>
		</table>
		<br>
		<button type="submit">전송하기</button>
	</form>
	<script src="https://code.jquery.com/jquery-3.5.0.js"
		integrity="sha256-r/AaFHrszJtwpe+tHyNi/XCfMxYpbsRg2Uqn0x3s2zc="
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		var idCheckFlag = false;

		<c:if test="${data.isSuccess == 'false'}">
		alert("회원가입에 실패하였습니다.");
		</c:if>

		function idCheck() {
			$
					.ajax({
						url : '/servletBM/member/idcheck.do',
						type : 'get',
						data : $('#userId').serialize(),
						success : function(data) {

							if (data != '') {
								document.querySelector('#idCheckMsg').textContent = '';
								document.querySelector('#idCheckMsg').textContent = data
										+ ' 이미 존재하는 아이디 입니다.';
								idCheckFlag = false;
							} else {
								document.querySelector('#idCheckMsg').textContent = '';
								document.querySelector('#idCheckMsg').textContent = data
										+ ' 사용가능한 아이디 입니다.';
								idCheckFlag = true;
							}
						}
					})
		}

		function validate() {
			var pw = document.getElementById('userPwd');
			var regExpPw = /(?=.*\d{1,50})(?=.*[~!@#$%\^&*()_+=]{1,50})(?=.*[a-zA-Z]{1,50}).{8,50}/;

			function chk(re, e, msg) {
				if (re.test(e.value)) {
					return true;
				} else {
					alert(msg);
					e.value = "";
					e.focus();
					return false;
				}
			}

			if (!idCheckFlag) {
				alert("아이디 중복검사를 해주세요.");
				return false;
			}

			//비밀번호 검사
			//암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.
			if (!chk(regExpPw, pw, '암호는 영문자 숫자 기호문자의 조합으로 8글자 이상 작성해주세요.')) {
				return false;
			}
			return true;
		}
	</script>























</body>
</html>