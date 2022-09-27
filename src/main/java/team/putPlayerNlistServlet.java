package team;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbe.DBExpert;

/**
 * Servlet implementation class putPlayerNlistServlet
 */
@WebServlet("/PlayerList.do")
public class putPlayerNlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public putPlayerNlistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("EUC-KR");
		//String btn = request.getParameter("BTN");
		DBExpert dbe = new DBExpert();
		ArrayList<TeamList> list = dbe.getPlayerList();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("playerList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
