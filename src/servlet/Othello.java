package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import othello.OthelloComputer3;
import othello.OthelloJSP;

/**
 * Servlet implementation class Othello
 */
@WebServlet("/Othello")
public class Othello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Othello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		mainOthello(request,response);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/othello.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void mainOthello(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		if(session.getAttribute("othello")!=null) {
			OthelloJSP othello=(OthelloJSP)session.getAttribute("othello");
			String record=(String)request.getParameter("record");
			if(record!=null) {
				try {
					if(record.equals("forward")) {
						othello.plusTurnCount();
						othello.updateTurn();
						int turnCount=othello.getTurnCount();
						int[][] rBanmen=othello.getRecord().get(turnCount-1);
						othello.setBanmen(rBanmen);
					}else if(record.equals("back")) {
						othello.minusTurnCount();
						othello.updateTurn();
						int turnCount=othello.getTurnCount();
						int[][] rBanmen=othello.getRecord().get(turnCount-1);
						othello.setBanmen(rBanmen);
					}
				}catch(IndexOutOfBoundsException e) {

				}
			}
			else if(request.getParameter("pass")==null) {
				if(othello.getComputer1()&&othello.getTurn()==1) {
					int level=othello.getCom1Lv();
					int[] gyoretu=null;
					if(level==16) {
						gyoretu=OthelloComputer3.othelloCom316(othello);
					}
					else if(level==15) {
						gyoretu=OthelloComputer3.othelloCom315(othello);
					}
					else if(level==14) {
						gyoretu= OthelloComputer3.othelloCom314(othello);
					}else if(level==13) {
						gyoretu= OthelloComputer3.othelloCom313(othello);
					}else if(level==12) {
						gyoretu= OthelloComputer3.othelloCom312(othello);
					}else if(level==11) {
						gyoretu= OthelloComputer3.othelloCom311(othello);
					}else if(level==10) {
						gyoretu= OthelloComputer3.othelloCom310(othello);
					}else if(level==9) {
						gyoretu= OthelloComputer3.othelloCom39(othello);
					}else if(level==8) {
						gyoretu= OthelloComputer3.othelloCom38(othello);
					}else if(level==7) {
						gyoretu= OthelloComputer3.othelloCom37(othello);
					}else if(level==6) {
						gyoretu= OthelloComputer3.othelloCom36(othello);
					}else if(level==5) {
						gyoretu= OthelloComputer3.othelloCom35(othello);
					}else if(level==4) {
						gyoretu= OthelloComputer3.othelloCom34(othello);
					}else if(level==3) {
						gyoretu= OthelloComputer3.othelloCom33(othello);
					}else if(level==2) {
						gyoretu= OthelloComputer3.othelloCom32(othello);
					}else if(level==1) {
						gyoretu= OthelloComputer3.othelloCom31(othello);
					}
					if(othello.getComputer2()) {
						request.setAttribute("com", true);
					}
					if(gyoretu==null) {
						request.setAttribute("comPass", "comPass");
						if(othello.getPassCount()>=2) {
							String result=othello.result();
							othello.setResult(true);
							request.setAttribute("result", result);
							request.setAttribute("com", null);
						}
					}else {
						othello.plusTurnCount();
						othello.addRecord(othello.getVBanmen());
						request.setAttribute("gyo", gyoretu[0]);
						request.setAttribute("retu", gyoretu[1]);
					}
					if(othello.none0()||othello.all(othello.getBanmen())) {
						String result=othello.result();
						othello.setResult(true);
						request.setAttribute("result", result);
						request.setAttribute("com", null);
					}
				}else if(othello.getComputer2()&&othello.getTurn()==2) {
					if(othello.getComputer1()) {
						request.setAttribute("com", true);
					}
					int level=othello.getCom2Lv();
					int[] gyoretu=null;
					if(level==16) {
						gyoretu=OthelloComputer3.othelloCom316(othello);
					}
					else if(level==15) {
						gyoretu=OthelloComputer3.othelloCom315(othello);
					}
					else if(level==14) {
						gyoretu= OthelloComputer3.othelloCom314(othello);
					}else if(level==13) {
						gyoretu= OthelloComputer3.othelloCom313(othello);
					}else if(level==12) {
						gyoretu= OthelloComputer3.othelloCom312(othello);
					}else if(level==11) {
						gyoretu= OthelloComputer3.othelloCom311(othello);
					}else if(level==10) {
						gyoretu= OthelloComputer3.othelloCom310(othello);
					}else if(level==9) {
						gyoretu= OthelloComputer3.othelloCom39(othello);
					}else if(level==8) {
						gyoretu= OthelloComputer3.othelloCom38(othello);
					}else if(level==7) {
						gyoretu= OthelloComputer3.othelloCom37(othello);
					}else if(level==6) {
						gyoretu= OthelloComputer3.othelloCom36(othello);
					}else if(level==5) {
						gyoretu= OthelloComputer3.othelloCom35(othello);
					}else if(level==4) {
						gyoretu= OthelloComputer3.othelloCom34(othello);
					}else if(level==3) {
						gyoretu= OthelloComputer3.othelloCom33(othello);
					}else if(level==2) {
						gyoretu= OthelloComputer3.othelloCom32(othello);
					}else if(level==1) {
						gyoretu= OthelloComputer3.othelloCom31(othello);
					}
					if(gyoretu==null) {
						request.setAttribute("comPass", "comPass");
						if(othello.getPassCount()>=2) {
							String result=othello.result();
							othello.setResult(true);
							request.setAttribute("result", result);
							request.setAttribute("com", null);
						}
					}else {
						othello.plusTurnCount();
						othello.addRecord(othello.getVBanmen());
						request.setAttribute("gyo", gyoretu[0]);
						request.setAttribute("retu", gyoretu[1]);
					}
					if(othello.none0()||othello.all(othello.getBanmen())) {
						String result=othello.result();
						othello.setResult(true);
						request.setAttribute("result", result);
						request.setAttribute("com", null);
					}
				}else {
					if(request.getParameter("masu")!=null) {
						if(othello.getComputer1()||othello.getComputer2()) {
							request.setAttribute("com", true);
						}
						int masu=Integer.parseInt(request.getParameter("masu"));
						int gyo=masu/10;
						int retu=masu%10;
						othello.setReverseCount(0);
						int[][] banmen=othello.getBanmen();
						if(banmen[gyo][retu]==0) {
							banmen[gyo][retu]=othello.getTurn();
							othello.reverse(gyo,retu);
							if(othello.getReverseCount()!=0) {
								othello.setPassCount(0);
								othello.plusTurnCount();
								othello.addRecord(othello.getVBanmen());
								request.setAttribute("gyo", gyo);
								request.setAttribute("retu", retu);
								othello.updateTurn();
							}else {
								banmen[gyo][retu]=0;
							}
							if(othello.none0()) {
								String result=othello.result();
								othello.setResult(true);
								request.setAttribute("result", result);
							}else {
								request.setAttribute("result", null);
							}
						}
					}
				}
			}else if(request.getParameter("pass")!=null) {
				othello.plusPassCount();
				if(othello.getPassCount()>=2) {
					String result=othello.result();
					othello.setResult(true);
					request.setAttribute("result", result);
				}
				othello.updateTurn();
				if(othello.getComputer1()||othello.getComputer2()) {
					request.setAttribute("com", true);
				}
			}
		}else {
			OthelloJSP othello=new OthelloJSP();
			othello.shokibanmen();
			session.setAttribute("othello",othello );
		}
	}
}
