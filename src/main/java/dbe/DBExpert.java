package dbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import team.TeamList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";//DB Drvier
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";//DB URL
	
	public boolean putPlayerTeam(TeamList tl) {
		String insert = "insert into player_team_tbl values("
				+"?,?,?,?,?)";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, tl.getSeqno());
			pstmt.setInt(2, tl.getT_id());
			pstmt.setInt(3, tl.getAnn_sal());
			pstmt.setString(4, null);
			pstmt.setInt(5, tl.getB_num());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean putPlayerInfo(TeamList tl) {
		String insert ="insert into baseball_player_tbl values("
				+"?,?,?,to_date(?, 'YYYY/MM/DD'))";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, tl.getSeqno());
			pstmt.setString(2, tl.getName());
			pstmt.setString(3, tl.getAddr());
			pstmt.setString(4, tl.getBirth());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e){}
		}
		return result;
	}
	
	public int maxSeqno() {
		String select ="select max(seqno) from baseball_player_tbl";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxnum = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			if(rs.next()) maxnum = rs.getInt(1);
			maxnum += 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return maxnum;
	}
	public boolean playerTeamDelete(int seqno) {
		String delete = "delete from player_team_tbl"
				+" where seqno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	public boolean playerDelete(int seqno) {
		String delete = "delete from baseball_player_tbl"
				+" where seqno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, seqno);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}

	public boolean playerTeamUpdate(TeamList tl) {
		String update = "update player_team_tbl set t_id=?, ann_sal=?,b_num=?"
				+ " where seqno=?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setInt(1, tl.getT_id());
			pstmt.setInt(2, tl.getAnn_sal());
			pstmt.setInt(3, tl.getB_num());
			pstmt.setInt(4, tl.getSeqno());
			pstmt.executeUpdate();
			con.commit();
			result= true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
	
//	public boolean teamUpdate(TeamList tl) {
//		String update = "update baseball_team_tbl set t_id=? where title =?";
//		Connection con = null; PreparedStatement pstmt = null;
//		boolean result = false;
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url,"hr","hr");
//			pstmt = con.prepareStatement(update);
//			pstmt.setString(1, tl.getTitle());
//			pstmt.setInt(2, tl.getT_id());
//			pstmt.executeUpdate();
//			result = true;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				pstmt.close(); con.close();
//			}catch(Exception e) {}
//		}
//		return result;
//	}
	
	public int findTeamCode(String team) { // 팀명으로 팀 번호 찾는 메소드
		String select ="select t_id from baseball_team_tbl where title = ?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, team);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean playerUpdate(TeamList tl) {
		String update = "update baseball_player_tbl set"
				+ " name=?, addr=?,birth=to_date(?, 'YYYY/MM/DD')"
				+ " where seqno = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		//TeamList tl = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, tl.getName());
			pstmt.setString(2, tl.getAddr());
			pstmt.setString(3, tl.getBirth());
			pstmt.setInt(4, tl.getSeqno());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
				
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<String> getTeamName(){
		String select = "select title from baseball_team_tbl";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String teamname = rs.getString(1);
				list.add(teamname);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public TeamList playerInfoView(String seqno) {
		String select= "select bp.seqno, bp.name, bp.addr, to_char(bp.birth, 'YYYY-MM-DD'), bt.title, pt.ann_sal, pt.b_num"
				+ " from baseball_player_tbl bp, baseball_team_tbl bt, player_team_tbl pt"
				+ " where bp.seqno = pt.seqno"
				+ " and bt.t_id = pt.t_id"
				+ " and bp.seqno = ?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeamList tl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, seqno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tl = new TeamList();
				tl.setSeqno(rs.getInt(1));
				tl.setName(rs.getString(2));
				tl.setAddr(rs.getString(3));
				tl.setBirth(rs.getString(4));
				tl.setTitle(rs.getString(5));
				tl.setAnn_sal(rs.getInt(6));
				tl.setB_num(rs.getInt(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return tl;
	}
	
	public ArrayList<TeamList> getPlayerList(){
		String select = "select bp.seqno, bp.name, bp.addr, to_char(bp.birth, 'YYYY-MM-DD'), bt.title, pt.ann_sal, pt.b_num"
				+ " from baseball_player_tbl bp, baseball_team_tbl bt, player_team_tbl pt"
				+ " where bp.seqno = pt.seqno"
				+ " and bt.t_id = pt.t_id"
				+ " order by bp.seqno asc";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TeamList> list = new ArrayList<TeamList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt= con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TeamList tl = new TeamList();
				tl.setSeqno(rs.getInt(1));
				tl.setName(rs.getString(2));
				tl.setAddr(rs.getString(3));
				tl.setBirth(rs.getString(4));
				tl.setTitle(rs.getString(5));
				tl.setAnn_sal(rs.getInt(6));
				tl.setB_num(rs.getInt(7));
				list.add(tl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<TeamList> getAllTeamList(){
		String select = "select bt.t_id, bt.title, bt.town, tow.name, to_char(bt.founding, 'YYYY-MM-DD')"
				+ " from baseball_team_tbl bt, team_owner_tbl tow"
				+ " where bt.t_id = tow.t_id";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TeamList> list = new ArrayList<TeamList>();
		TeamList tl = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				tl = new TeamList();
				tl.setT_id(rs.getInt(1));
				tl.setTitle(rs.getString(2));
				tl.setTown(rs.getString(3));
				tl.setO_name(rs.getString(4));
				tl.setFounding(rs.getString(5));
				list.add(tl);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
}
