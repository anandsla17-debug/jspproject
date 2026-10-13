package Controler;

import java.io.IOException;
import java.util.ArrayList;

import Model.Studentmodel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class StudentDisplayController extends HttpServlet {
	
	Studentlogic studentlogic= new Studentlogic();
	@Override
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
ArrayList<Studentmodel>	data =studentlogic.Alldisplay();
request.setAttribute("view", data);

request.getRequestDispatcher("/Studentdisplay.jsp")
.forward(request, response);

}

}
