<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.accolite.servletapplication.model.User,com.accolite.servletapplication.log.ServletApplicationLogger"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=submit]{
  width: 20%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
  background-color: #4CAF50;
  color: white;
}
h1{
	color:#452511;
}
</style>
</head>
<body>
	<% User user=(User)(session.getAttribute("user")); 
		if(user==null){
		response.sendRedirect("index.jsp");
		%>
	<%} else{
		ServletApplicationLogger.log(ServletApplicationLogger.TYPE_REQUEST,user.getUserName()+"logged successfully from "+request.getRemoteHost());
	%>
		
		<p><% String msg=(String)session.getAttribute("message");
			if(msg!=null){%>
			<%=msg %>	
			<%
				session.removeAttribute("message");
			}%></p>
		<h1>Welcome  <%=user.getUserName()%></h1>
		<h1>nickName : <%=user.getNickName()%></h1>
		
		<form action="EditProfile.jsp">
			<input type="submit" value="Edit Profile">
		</form>
		<form action="logoutservlet">
			<input type="submit" value="logout">
		</form>
	<%} %>
</body>
</html>