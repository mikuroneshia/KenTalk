package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
@WebServlet("/SignUp")
public class SignUp extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/signUpComplete.jsp");
		//response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		String birthplace=request.getParameter("birthplace");
		String birthday=request.getParameter("birthday");
		String pass=request.getParameter("pass");
		DAO.setAccount(name, age, birthplace, birthday,pass);
		dispatcher.forward(request, response);
	}
}
