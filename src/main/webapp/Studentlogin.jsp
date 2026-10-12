<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student login</title>
</head>
<body>
<%String result =(String) session.getAttribute("result");
if(result!=null)
{%>
<h1><%=result %></h1>
<%} %>

<h1>Student login</h1>
<form action="login" method="post">

<input type="number" name="studentid" placeholder="Enter (user id) student id">
<br>

<br>
<input type="text" name="aadharno" placeholder="Enter (password) aadharno">
<br>
<button type="submit">login</button>
<a href="StudentRegister.jsp" style="text-decoration: none">Back</a>
</form>
<%String message= (String) request.getAttribute("message"); 
if(message!=null)
{%>
<p><%=message %></p>
<%} %>
</body>
</html>