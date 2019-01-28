<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.Date"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	public boolean isPrime(int i){
	int count=0;
	for(int j=1;j<=i;j++){
		if(i%j==0)
			count++;
	}
	if(count>2)
		return false;
	else
		return true;
}%>
<%
	Date date=new Date();
%>
<%= date.getTime() %>
	<% for(int i=2;i<=100;i++){%>				
		<%= i%>isPrime? <%=isPrime(i) %>	
	<%} int count=0;%>
	${count}
</body>
</html>