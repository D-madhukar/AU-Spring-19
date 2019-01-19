<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=text], input[type=password] {
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 40%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 16px;
}
	
	
</style>
</head>
<body>
	<% HttpSession ses=request.getSession(false);
		if(ses!=null && ses.getAttribute("user")!=null)
			response.sendRedirect("profile.jsp");
	%>		
	<form action="loginservlet" method="post">
		<h1>Login Page</h1>
		<span>
			<%	String errormessage=(String)(request.getAttribute("errormessage"));
				if(errormessage!=null) {%>
					<%=errormessage%>
			<%}%>			
		</span>
	  <div class="container">
	      <label><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="userName" required><br/> 
	      <label><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="password" required> <br/>      
	      <center></center><button type="submit">Login</button></center>
	  <div>
	</form>
</body>
</html>