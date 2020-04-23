<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>01_JspSample</title>
</head>
<body>
	<h1>JSP ����</h1>
	<p>
		JSP�� ������ ������ �ڹپ���� Servlet����<br> ȭ�� ������ ���õ� �ҽ� �κ��� ������ �и��ϴ� �����
		���Ѵ�.
	</p>
	<h3>������ �±�(Directive)</h3>
	<%
		String startDirective = "<%@     ";
	%>
	<%
		String endDirective = "% >";
	%>

	<pre>
		<%=startDirective + endDirective%>
	</pre>
	<p>
		������ �±׶�, �ش��ϴ� ������ ��ü���� ����� �Ӽ��� <br> ������ �� ����ϴ� JSP �±�
	</p>
	<p>
		1. page : �ش� ������ ��ü �Ӽ��� �����ϴ� �±�<br> 1-1 : import - �ʿ��� �ڹ��� Ŭ������
		import�� �� ����մϴ�.<br> 2. include : �ٸ� ��ġ�� html/jsp �������� ���� ��������
		�����ϴ� �±�<br> 3. taglib : ����ڳ� �ٸ� ���̺귯������ �����ϴ� Ŀ���� �±׸� ������ �� ����ϴ�
		�Ӽ�
	</p>
	<h3>��ũ��Ʋ�� �±�(Scriptlet)</h3>
	<%
		String startScriptlet = "<%     ";
		String endScriptlet = "% >";
	%>
	<pre>
		<%=startScriptlet + endScriptlet%>
	</pre>
	<p>
		�ش� ������ ���ο��� �ڹ� �ҽ��ڵ带 �ۼ��ϴ� <br> ������ ��Ÿ���� JSP �±�, ��ũ��Ʋ���� ���������� �޼���
		�ȿ��� ����ȴ�.<br> ���� static ������ �޼��� ������� �� �� ����.
	</p>
	<hr>
	<h3>���� �±�(Declaration)</h3>
	<pre>
		<%
			declaration();
		%>
	</pre>
	<p>
		���� �±״� Ŭ������ �ʵ忡 �ش��Ѵ�.<br> �޼��� ���� ����, static ���� ���� ����
	</p>
	<%!public String declaration() {

		String startDeclaration = "<%!     ";
		String endDeclaration = "% > ";

		return startDeclaration + endDeclaration;
	}%>

	<h3>ǥ���� �±� (Expression)</h3>
	<%
		String startExpression = "<%=     ";
		String endExpression = "% >";
	%>

	<pre><%=startExpression + endExpression%></pre>
	<p>
		ǥ���� �±׶�, Ư�� ��ü��, ������ ���� ����ϴ� <br> �뵵�� ����ϴ� JSP �±��̴�.
	</p>
	<hr>
	<h3>�ּ� �±�</h3>
	<pre>&lt;% -- --%&gt;</pre>
	<p>
		�ּ� �±״� �ش� ���������� ���Ǵ� jsp �ڵ峪<br> ���������� �ڵ带 �ּ�ó���ϱ� ���� �±��̴�.
	</p>
</body>
</html>