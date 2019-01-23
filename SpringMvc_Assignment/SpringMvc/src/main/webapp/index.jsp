<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page import="com.accolite.springmvc.model.User"%>
<%@page import="java.util.List"%>
<html>
<body>
	<h2>${message}</h2>
	<form action="login.jsp">
		<input type="submit" value="login">
	</form>
	<form action="users">
		<input type="submit" value="userList">
	</form>
	<form action="registration.jsp">
		<input type="submit" value="Register">
	</form>
	
	<% List<User> users=(List<User>)request.getAttribute("users");
		if(users!=null){ %>
			<table>
				<tr>
					<th>UserName</th>
					<th>Age</th>
					<th>Email</th>
					<th></th>
				</tr>
				<% for(User user:users){ %>
				<tr>
					<td><%=user.getUserName() %></td>
					<td><%=user.getAge() %></td>
					<td><%=user.getEmail() %></td>
					<td><form><button formaction="update.jsp" name="editUserName" value="<%=user.getUserName()%>">Edit</button></form></td>
				</tr>
				<%}%>
			</table>
		
		<%}%>
</body>
</html>
