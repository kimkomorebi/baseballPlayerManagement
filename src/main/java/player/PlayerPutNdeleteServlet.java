package player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbe.DBExpert;
import team.TeamList;

@WebServlet("/playerUpdateNdelete.do")
public class PlayerPutNdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlayerPutNdeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String seqno = request.getParameter("SEQNO");//선수 번호
		String btn = request.getParameter("BTN");
		String name = request.getParameter("NAME");//선수 이름
		String addr = request.getParameter("ADDR");//주소
		String birth = request.getParameter("BIRTH");//생년월일
		String team = request.getParameter("TITLE");//소속팀
		String ann_sal = request.getParameter("ANN_SAL");//연봉
		String b_num = request.getParameter("B_NUM");//등번호
		TeamList tl = new TeamList();
		tl.setSeqno(Integer.parseInt(seqno));
		tl.setName(name);
		tl.setAddr(addr);
		tl.setBirth(birth);
		tl.setTitle(team);
		tl.setAnn_sal(Integer.parseInt(ann_sal));
		tl.setB_num(Integer.parseInt(b_num));
		DBExpert dbe = new DBExpert();
		int code = dbe.findTeamCode(team);
		System.out.println("code에 들어있는 것"+code);
		tl.setT_id(code);
		
		if(btn.equals("수정")) {
			boolean update1 = dbe.playerUpdate(tl);
			boolean update2 = dbe.playerTeamUpdate(tl);
			if(update1 && update2) {
				response.sendRedirect("playerUpdateResult.jsp?R=Y");
			}else {
				response.sendRedirect("playerUpdateResult.jsp?R=N");
			}
		}else if(btn.equals("삭제")) {
			boolean delete1 = dbe.playerTeamDelete(Integer.parseInt(seqno));
			boolean delete2 = dbe.playerDelete(Integer.parseInt(seqno));
			if(delete1 && delete2) {
				response.sendRedirect("playerDeleteResult.jsp?R=Y");
			}else {
				response.sendRedirect("playerDeleteResult.jsp?R=N");
			}
			
		}
	}

}
