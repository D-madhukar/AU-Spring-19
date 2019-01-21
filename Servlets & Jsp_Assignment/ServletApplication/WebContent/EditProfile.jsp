<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	input[type=text], input[type=password] {
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
}
</style>
</head>
<body>
	<% 
		if(session.getAttribute("user")==null)
			response.sendRedirect("index.jsp");
	%>
	<form action="editprofile" method="post">
		<label>Password</label>
		<input type="password" name="password" placeholder="new password"/>
		<label>nickname</label>
		<input type="text" name="nickname" placeholder="new nickname"/>
		<input type="submit" value="update" name="update"/>
	</form>
	<form action="profile.jsp"><input type="submit" value="Back"/></form>
	
</body>
</html>