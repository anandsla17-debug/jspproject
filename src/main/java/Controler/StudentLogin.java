package Controler;

import java.io.IOException;

import Model.Studentmodel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class StudentLogin  extends HttpServlet{
Studentmodel studentmodel=new Studentmodel();
Studentlogic studentlogic= new Studentlogic();
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String studentid=request.getParameter("studentid");
	
		String aadharno=request.getParameter("aadharno");
		studentmodel.setStudentid(Integer.valueOf(studentid));
		studentmodel.setAadharno(Long.valueOf(aadharno));
		String result =studentlogic.studentlogin(studentmodel);
		System.out.println("checking.."+result);
		if(result.equals(studentid+aadharno)) {
			request.setAttribute("message", "login successfull"); // name =>get , message
			try {
				Thread.sleep(2000);
				response.sendRedirect("display");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			request.setAttribute("message", "login failed");
			request.getRequestDispatcher("/Studentlogin.jsp").forward(request, response);
		}
		
		
		
	}
	
}
