package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbe.DBExpert;
import team.TeamList;

/**
 * Servlet implementation class PlayerUpdateServlet
 */
@WebServlet("/playerUpdate.do")
public class PlayerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlayerUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqno = request.getParameter("SEQNO");
		//System.out.println("선택한 번호"+seqno);
		DBExpert dbe = new DBExpert();
		TeamList list = dbe.playerInfoView(seqno);
		ArrayList<String> team = dbe.getTeamName();
		request.setAttribute("LIST", list);
		request.setAttribute("TEAM", team);
		RequestDispatcher rd = request.getRequestDispatcher("playerUpdateView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
