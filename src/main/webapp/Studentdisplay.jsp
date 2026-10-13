<%@page import="Model.Studentmodel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Record</title>
</head>
<body>
<center>
<table border="1">
<caption>Student Record</caption>
<tr>
<th>Student Id</th>
<th>Student name</th>
<th>Student Dob</th>
<th>Student Aadharno</th>
</tr>

<%ArrayList<Studentmodel> student=(ArrayList<Studentmodel>)  request.getAttribute("view");
for(Studentmodel data:student){%>
<tr>
<td>Student id:<%=data.getStudentid() %></td>
<td>Student name:<%=data.getSname() %></td>
<td>Student dob:<%=data.getDob() %></td>
<td>Student Aadharno:<%=data.getAadharno() %></td>
</tr>
<%} %>

</table>
</center>
<a href="Studentlogin.jsp" style="text-decoration: none; height: 50px; width: 100px; background-color:gray;padding: 5px;border-radius: 5px">Back</a>
</body>
</html>