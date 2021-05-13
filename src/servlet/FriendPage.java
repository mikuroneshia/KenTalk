package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.TalkDAO;
import javaBeans.Account;

/**
 * Servlet implementation class FriendPage
 */
@WebServlet("/FriendPage")
public class FriendPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String friend=(String)request.getParameter("friend");
		System.out.println("FriendPage.java:friend:"+friend);
		request.setAttribute("friend", friend);
		String accountName=(String)request.getParameter("accountName");
		System.out.println("FriendPage.java:accountName:"+accountName);
		ArrayList<ArrayList<String>>sentenseList=TalkDAO.getSentense(accountName, friend);
		request.setAttribute("sentenseList", sentenseList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/friendPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String accountName=(String)request.getParameter("accountName");
		System.out.println("FriendPage.java:accountName:"+accountName);
		String friend=(String)request.getParameter("friend");
		request.setAttribute("friend", friend);
		System.out.println("FriendPage.java:friend:"+friend);
		String sentense=request.getParameter("sentense");
		String room=accountName+"&"+friend;
		Date date=new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm" );
		String display=format.format(date);
		TalkDAO.setTalkRec(room, accountName, friend, sentense,display);
		ArrayList<ArrayList<String>>sentenseList=TalkDAO.getSentense(accountName, friend);
		request.setAttribute("sentenseList", sentenseList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/friendPage.jsp");
		dispatcher.forward(request, response);
	}

}
