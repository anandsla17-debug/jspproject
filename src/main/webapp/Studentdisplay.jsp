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
<%ArrayList<Studentmodel> student=(ArrayList<Studentmodel>)  request.getAttribute("view");
for(Studentmodel data:student){%>
<p>Student id:<%=data.getStudentid() %></p>
<p>Student name:<%=data.getSname() %></p>
<p>Student dob:<%=data.getDob() %></p>
<p>Student Aadharno:<%=data.getAadharno() %>
<%} %>>
</body>
</html>