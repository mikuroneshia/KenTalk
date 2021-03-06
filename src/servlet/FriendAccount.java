package servlet;

import java.io.IOException;
import java.net.URLDecoder;

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
 * Servlet implementation class FriendAccount
 */
@WebServlet("/FriendAccount")
public class FriendAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//String friend=request.getParameter("friend");
		String friend=new String(request.getParameter("friend").getBytes("ISO-8859-1"));
		friend=URLDecoder.decode(friend,"UTF-8");
		Account fAccount=DAO.getAccount(friend);
		HttpSession session=request.getSession();
		session.setAttribute("friendAccount", fAccount);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/friendAccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
