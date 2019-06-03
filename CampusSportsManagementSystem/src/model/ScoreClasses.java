package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreClasses {
	private int collegeid;
	private String collegename;
	private double scorenumber;
	private int classid;
	private String classname;
	private int majorid;
	private String majorname;
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public ScoreClasses(ResultSet rs){
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.collegeid = rs.getInt("collegeid");
				this.collegename=rs.getString("collegename");
				this.scorenumber = rs.getDouble("scorenumber");
				this.classid = rs.getInt("classid");
				this.classname=rs.getString("classname");
				this.majorid = rs.getInt("majorid");
				this.majorname=rs.getString("majorname");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<ScoreClasses> list = new ArrayList<ScoreClasses>();
		if(rs != null){
			try{
				while(rs.next()){
					ScoreClasses ScoreClasses = new ScoreClasses();
					ScoreClasses.setCollegeid(rs.getInt("collegeid"));
					ScoreClasses.setCollegename(rs.getString("collegename"));
					ScoreClasses.setScorenumber(rs.getDouble("scorenumber"));
					ScoreClasses.setClassid(rs.getInt("classid"));
					ScoreClasses.setClassname(rs.getString("classname"));
					ScoreClasses.setMajorid(rs.getInt("majorid"));
					ScoreClasses.setMajorname(rs.getString("majorname"));
					
					list.add(ScoreClasses);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
	
	public ScoreClasses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreClasses(int collegeid, String collegename, double scorenumber,
			int classid, String classname, int majorid, String majorname) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
	}
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public double getScorenumber() {
		return scorenumber;
	}
	public void setScorenumber(double scorenumber) {
		this.scorenumber = scorenumber;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	
}
