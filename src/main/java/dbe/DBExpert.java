package dbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import team.TeamList;

public class DBExpert {
	final private String dirver = "oracle.jdbc.OracleDriver";//DB Drvier
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";//DB URL
	
	public ArrayList<TeamList> getAllTeamList(){
		String select = "select bt.t_id, bt.title, bt.town, tow.name, to_char(bt.founding, 'YYYY-MM-DD')"
				+ " from baseball_team_tbl bt, team_owner_tbl tow"
				+ " where bt.t_id = tow.t_id";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<TeamList> list = new ArrayList<TeamList>();
		TeamList tl = null;
		try {
			Class.forName(dirver);
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
