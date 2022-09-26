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
		String seqno = request.getParameter("SEQNO");//���� ��ȣ
		String btn = request.getParameter("BTN");
		String name = request.getParameter("NAME");//���� �̸�
		String addr = request.getParameter("ADDR");//�ּ�
		String birth = request.getParameter("BIRTH");//�������
		String team = request.getParameter("TITLE");//�Ҽ���
		String ann_sal = request.getParameter("ANN_SAL");//����
		String b_num = request.getParameter("B_NUM");//���ȣ
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
		System.out.println("code�� ����ִ� ��"+code);
		tl.setT_id(code);
		
		if(btn.equals("����")) {
			boolean update1 = dbe.playerUpdate(tl);
			boolean update2 = dbe.playerTeamUpdate(tl);
			if(update1 && update2) {
				response.sendRedirect("playerUpdateResult.jsp?R=Y");
			}else {
				response.sendRedirect("playerUpdateResult.jsp?R=N");
			}
		}else if(btn.equals("����")) {
			
		}
	}

}
