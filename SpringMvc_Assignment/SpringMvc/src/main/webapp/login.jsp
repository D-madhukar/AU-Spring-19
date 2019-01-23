<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="index.jsp">
		<input type="submit" value="home">
	</form>
	<h1>${message} </h1>
	<form action="loginprocess" method="post">
		<input name="userName" placeholder="enter username"/><br/>
		<input type="password" name="password" placeholder="enter Password"/><br/>
		<input type="submit" value="login">
	</form>
</body>
</html>