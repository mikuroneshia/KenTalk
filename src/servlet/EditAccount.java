package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import javaBeans.Account;

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
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/editAccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		Account account=(Account)session.getAttribute("account");
		String oldName=account.getName();
		String newName=request.getParameter("newName");
		String newAge=request.getParameter("newAge");
		String newHobby=request.getParameter("newHobby");
		System.out.println("oldName:"+oldName);
		System.out.println("newName:"+newName);
		System.out.println("newAge:"+newAge);
		System.out.println("newHobby:"+newHobby);
		if(!newAge.equals("")) {
			DAO.setAge(oldName, Integer.parseInt(newAge));
			System.out.println("editAge");
			account=DAO.getAccount(oldName);
		}
		if(!newHobby.equals("")) {
			DAO.setHobby(oldName, newHobby);
			System.out.println("editHobby");
			account=DAO.getAccount(oldName);
		}
		if(!newName.equals("")) {
			DAO.setName(oldName, newName);
			System.out.println("editName");
			account=DAO.getAccount(newName);
		}
		session.setAttribute("account", account);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/myAccount.jsp");
		dispatcher.forward(request, response);
	}

}
