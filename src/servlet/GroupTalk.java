package servlet;

import java.io.IOException;
import java.net.URLDecoder;
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

import dao.GroupTalkDAO;

/**
 * Servlet implementation class GroupTalk
 */
@WebServlet("/GroupTalk")
public class GroupTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupTalk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ArrayList<ArrayList<String>>gtList=GroupTalkDAO.getGroupTalk();
		request.setAttribute("gtList",gtList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/groupTalk.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//String f=request.getParameter("name");
		String f=new String(request.getParameter("name").getBytes("ISO-8859-1"));
		f=URLDecoder.decode(f,"UTF-8");
		String sentense=request.getParameter("sentense");
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String display=format.format(date);
		GroupTalkDAO.setGroupTalk(f, sentense,display);
		ArrayList<ArrayList<String>>gtList=GroupTalkDAO.getGroupTalk();
		request.setAttribute("gtList",gtList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/groupTalk.jsp");
		dispatcher.forward(request, response);
	}

}
