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

@WebServlet("/getTeamList.do")
public class GetTeamListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetTeamListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<TeamList> list = dbe.getAllTeamList();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("teamAllList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
