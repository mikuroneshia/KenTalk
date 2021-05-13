package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import othello.OthelloJSP;

/**
 * Servlet implementation class OthelloMainMenu
 */
@WebServlet("/OthelloMainMenu")
public class OthelloMainMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OthelloMainMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/othelloMainMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		OthelloJSP othello=new OthelloJSP();
		othello.shokibanmen();
		String com1=(String)request.getParameter("com1");
		String com2=(String)request.getParameter("com2");
		if(com1!=null&&!com1.isEmpty()&&com1.equals("com1")) {
			othello.setCom1();
		}
		if(com2!=null&&!com2.isEmpty()&&com2.equals("com2")) {
			othello.setCom2();
		}
		if(request.getParameter("com1Level")!=null) {
			int com1Level=Integer.parseInt(request.getParameter("com1Level"));
			othello.setCom1Lv(com1Level);
		}
		if(request.getParameter("com2Level")!=null) {
			int com2Level=Integer.parseInt(request.getParameter("com2Level"));
			othello.setCom2Lv(com2Level);
		}

		session.setAttribute("othello", othello);
		RequestDispatcher dispatcher=request.getRequestDispatcher("Othello");
		dispatcher.forward(request, response);

	}

}
