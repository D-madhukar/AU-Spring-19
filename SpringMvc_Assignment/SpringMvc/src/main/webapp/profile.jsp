<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.accolite.springmvc.model.User"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession sess=request.getSession(false);
		if(sess!=null && sess.getAttribute("user")!=null){
			User user=(User)sess.getAttribute("user");
		}
		else{
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>Welcome: ${user.getUserName()}</h1>
	<h1>Age: ${user.getAge()}</h1>
	<h1>Email: ${user.getEmail()}</h1>
	<form action="logout" method="post">
		<input type="submit" value="Logout">
	</form>
</body>
</html>