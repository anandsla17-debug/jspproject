package Controler;

import Model.Studentmodel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/student")
public class StudentController extends HttpServlet{
Studentmodel studentmodel=new Studentmodel();
	@Override
	public void doPost(HttpServletRequest request ,HttpServletResponse response) {
	int studentid= Integer.valueOf(request.getParameter("studentid"));
		String sname=request.getParameter("sname");
String dob=request.getParameter("dob");
	long aadharno	=Long.valueOf(request.getParameter("aadharno"));
	System.out.println("studentid:"+studentid+"sname:"+sname+"dob:"+dob+"aadhar:"+aadharno);
	studentmodel.setStudentid(studentid);
	studentmodel.setSname(sname);
	studentmodel.setAadharno(aadharno);
	studentmodel.setDob(dob);
	}
}
