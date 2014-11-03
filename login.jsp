<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Servlet JSP Login</title>
        <link rel="stylesheet" href="/uikit/css/uikit.min.css" />
        <script src="/uikit/js/jquery-1.11.1.js"></script>
        <script src="/uikit/js/uikit.min.js"></script>
</head>
<body background="indexwallpaper.jpg" height="100%" width="100%">
	<h1 align="center">This is a Login page</h1>
	<form action="login.htm" method="post" class="uk-form">
		<table align="center">
			<tr>
				<td>username:</td>
				<td><input name="usernameTB" type="text"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input name="passwordTB" type="password"></td>
			</tr>
			<tr style="color: red">
				<td colspan="2">
					<%
						String errorMessage = (String) request.getAttribute("errMsg");
						if (errorMessage != null) {
					%> 
                                        <%=errorMessage%> 
                                        <%
 	                                    }
                                        %>
				</td>
			</tr>
			<tr>
				<td><input name="register" value="register" type="button" onclick="window.open('register.jsp')"></td>
				<td><input name="login" value="login" type="submit"></td>
			</tr>
			<tr>
				<td style="height:720px"></td>

			</tr>
		</table>
	</form>
</body>
</html>
