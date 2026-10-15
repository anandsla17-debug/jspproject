package Controler;

import java.io.IOException;
import java.io.PrintWriter;

import Model.Studentmodel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
@WebServlet("/student")
public class StudentController extends HttpServlet{
Studentmodel studentmodel=new Studentmodel();
Studentlogic studentlogic= new Studentlogic();
	@Override
	public void doPost(HttpServletRequest request ,HttpServletResponse response) throws IOException {
	int studentid= Integer.valueOf(request.getParameter("studentid"));
		String sname=request.getParameter("sname");
String dob=request.getParameter("dob");
	long aadharno	=Long.valueOf(request.getParameter("aadharno"));
	System.out.println("studentid:"+studentid+"sname:"+sname+"dob:"+dob+"aadhar:"+aadharno);
	studentmodel.setStudentid(studentid);
	studentmodel.setSname(sname);
	studentmodel.setAadharno(aadharno);
	studentmodel.setDob(dob);
	
	String register= studentlogic.storestudentlogic(studentmodel);
	HttpSession session=request.getSession();
	session.setAttribute("result", register);
	        
	        
	      // one
//		        response.setContentType("text/html");
//	        	PrintWriter out  =response.getWriter();
//		    	out.println("<h1 style='color:green'>"+studentlogic.storestudentlogic(studentmodel)+"</h1>");

			//two
	if(register.equals("student record stored successfully")) {
	response.sendRedirect("Studentlogin.jsp");
	
	}else {
		
		response.sendRedirect("StudentRegister.jsp");
	}
	}
}
