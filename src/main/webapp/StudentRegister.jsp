<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register</title>
</head>
<body>
<h1>Student form</h1>

<form action="student" method="post">

<input type="number" name="studentid" placeholder="Enter your student id">
<br>
<input type="text" name="sname" placeholder="Enter your student name">
<br>
<input type="date" name="dob" > 
<br>
<input type="number" name="aadharno" placeholder="Enter your aadharno">
<br>
<button type="submit">Register</button>
<a href="Studentlogin.jsp" style="text-decoration: none">Login</a>
</form>
<%String result =(String) session.getAttribute("result");
if(result!=null)
{%>
<h1><%=result %></h1>
<%} %>
</body>
</html>