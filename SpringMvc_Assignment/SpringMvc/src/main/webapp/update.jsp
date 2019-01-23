<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String userName=request.getParameter("editUserName"); %>
	<form action="update" method="post">
		UserName:<input name="userName" value="<%= userName%>" /><br/><br/>
		Age:<input name="age" placeholder="enter Age(New or Old)"/><br/><br/>
		Email:<input name="email" placeholder="enter Email(New or Old)"/><br/><br/>
		<input type="submit" name="submit" value="Update"/>
	</form>
</body>
</html>