package player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbe.DBExpert;
import team.TeamList;

/**
 * Servlet implementation class PutPlayerDoServlet
 */
@WebServlet("/putPlayer.do")
public class PutPlayerDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PutPlayerDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		DBExpert dbe = new DBExpert();
		int maxnum = dbe.maxSeqno();
		String name = request.getParameter("NAME");
		String addr = request.getParameter("ADDR");
		String birth = request.getParameter("BIRTH");
		String title = request.getParameter("TITLE");
		String b_num = request.getParameter("B_NUM");
		String ann_sal = request.getParameter("ANN_SAL");
		TeamList tl = new TeamList();
		tl.setSeqno(maxnum);
		tl.setName(name);
		tl.setAddr(addr);
		tl.setBirth(birth);
		//tl.setTitle(title);
		int code =dbe.findTeamCode(title);
		tl.setT_id(code);
		tl.setB_num(Integer.parseInt(b_num));
		tl.setAnn_sal(Integer.parseInt(ann_sal));
		boolean result1 = dbe.putPlayerInfo(tl);
		boolean result2 = dbe.putPlayerTeam(tl);
		if(result1 && result2) {
			response.sendRedirect("putPlayerResult.jsp?R=Y");
		}else {
			response.sendRedirect("putPlayerResult.jsp?R=N");
		}
	}

}
