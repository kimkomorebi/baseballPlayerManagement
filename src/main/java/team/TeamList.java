package team;

public class TeamList {
	private int t_id;//�� ��ȣ
	private String title;//�� �̸�
	private String town;//������
	private String o_name;//������ �̸�
	private String founding;//â����(DB�� date)
	
	private Integer seqno;//���� ��ȣ
	private String name;//���� �̸�
	private String addr;//�ּ�
	private String birth;//�������
	private Integer ann_sal;//����
	private Integer b_num;//���ȣ
	
	public Integer getSeqno() {
		return seqno;
	}
	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Integer getAnn_sal() {
		return ann_sal;
	}
	public void setAnn_sal(Integer ann_sal) {
		this.ann_sal = ann_sal;
	}
	public Integer getB_num() {
		return b_num;
	}
	public void setB_num(Integer b_num) {
		this.b_num = b_num;
	}
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
