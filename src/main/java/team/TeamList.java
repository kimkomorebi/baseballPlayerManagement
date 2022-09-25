package team;

public class TeamList {
	private int t_id;//팀 번호
	private String title;//팀 이름
	private String town;//연고지
	private String o_name;//구단주 이름
	private String founding;//창단일(DB에 date)
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getO_name() {
		return o_name;
	}
	public void setO_name(String o_name) {
		this.o_name = o_name;
	}
	public String getFounding() {
		return founding;
	}
	public void setFounding(String founding) {
		this.founding = founding;
	}
}
