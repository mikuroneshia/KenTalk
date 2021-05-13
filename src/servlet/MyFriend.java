package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

/**
 * Servlet implementation class MyFriend
 */
@WebServlet("/MyFriend")
public class MyFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String referer=request.getHeader("Referer");
		System.out.println(referer);
		String page=request.getParameter("page");
		//if(referer.equals("http://35.200.39.63:8080/kenTalk/MyPage")) {
		//if(referer.equals("http://localhost:8080/kenTalk/MyPage")) {
		if(page.equals("myPage")) {
			ArrayList<String> friends=DAO.getName();
			request.setAttribute("friends", friends);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/myFriend.jsp");
			dispatcher.forward(request,response);
		}
		//}else if(referer.equals("http://35.200.39.63:8080/kenTalk/MyFriend")) {
		//}else if(referer.equals("http://localhost:8080/kenTalk/MyFriend")) {
		 else if(page.equals("myFriend")){
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/friendPage.jsp");
			dispatcher.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
