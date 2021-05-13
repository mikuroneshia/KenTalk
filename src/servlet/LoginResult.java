package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginResult")
public class LoginResult extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		String name=request.getParameter("name");
		request.setAttribute("name",name );
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}
