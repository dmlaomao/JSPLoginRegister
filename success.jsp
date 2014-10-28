<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Servlet JSP Success</title>
</head>
<body>

	<%
		String user = (String) request.getAttribute("reqName");
	%>

	<h1>
		Hello welcome
		<%=user%>
		to the website
	</h1>
</body>
</html>
