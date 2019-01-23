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
	<form action="register" method="post">
		UserName:<input name="userName"/><br/><br/>
		Password:<input type="password" name="password"/><br/><br/>
		Age:<input name="age"/><br/><br/>
		Email:<input name="email"/><br/><br/>
		<input type="submit" name="submit" value="submit"/>
	</form>

</body>
</html>