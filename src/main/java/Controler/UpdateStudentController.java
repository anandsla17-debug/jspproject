package Controler;

import java.io.IOException;

import Model.Studentmodel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateStudentController extends HttpServlet{
	Studentlogic studentlogic= new Studentlogic();
	Studentmodel studentmodel= new Studentmodel();
@Override
public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
	int studentid=Integer.valueOf(request.getParameter("studentid"));
	String sname=request.getParameter("sname");
	String dob=request.getParameter("dob");
	long aadharno=Long.valueOf(request.getParameter("aadharno"));
	studentmodel.setSname(sname);
	studentmodel.setStudentid(studentid);
	studentmodel.setDob(dob);
	studentmodel.setAadharno(aadharno);
	System.out.println(studentlogic.update(studentmodel));
	response.sendRedirect("display");
	
}
}
