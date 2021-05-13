package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import javaBeans.Account;
@WebServlet("/Login")
public class Login extends HttpServlet{
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException,ServletException{
		RequestDispatcher dispatcher=null;
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		ArrayList<String> nameList=DAO.getName();
		for(String n:nameList) {
			System.out.println(n);
		}
		if(nameList.contains(name)&&DAO.getPass(name).equals(pass)) {
			dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			Account account=DAO.getAccount(name);
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
		}else {
			dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/loginFail.jsp");
		}
		request.setAttribute("name", name);
		dispatcher.forward(request, response);
	}
}
