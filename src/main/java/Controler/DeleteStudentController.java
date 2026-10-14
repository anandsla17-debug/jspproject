package Controler;

import java.io.IOException;

import Model.Studentmodel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteStudentController extends HttpServlet{

	Studentlogic studentlogic= new Studentlogic();
	Studentmodel studentmodel= new Studentmodel();
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int studentid= Integer.valueOf(request.getParameter("studentid"));

		studentmodel.setStudentid(studentid);
	String result	=studentlogic.studentdelete(studentmodel);
	System.out.println(result);
		response.sendRedirect("display");
		
	}
	
}
