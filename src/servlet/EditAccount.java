package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oldName=request.getParameter("oldName");
		String newName=request.getParameter("newName");
		String newAge=request.getParameter("newAge");
		String newHobby=request.getParameter("newHobby");
		if(!newAge.equals("")) {
			DAO.setAge(oldName, Integer.parseInt(newAge));
		}
		if(!newHobby.equals("")) {
			DAO.setHobby(oldName, newHobby);
		}
		if(!newName.equals("")) {
			DAO.setName(oldName, newName);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/myAccount.jsp");
		dispatcher.forward(request, response);
	}

}
