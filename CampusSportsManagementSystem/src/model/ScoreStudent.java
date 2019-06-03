package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreStudent {
	private int userid;
	private String username;
	private int collegeid;
	private String collegename;
	private double scorenumber;
	private int classid;
	private String classname;
	private int majorid;
	private String majorname;
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public ScoreStudent(ResultSet rs){
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.userid = rs.getInt("userid");
				this.username=rs.getString("username");
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
	 * ResultSet结果集转List
	 * @param rs ResultSet结果集
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//静态方法，用于将0~N的VUser视图数据交换到List数组中来
		List<ScoreStudent> list = new ArrayList<ScoreStudent>();
		if(rs != null){
			try{
				while(rs.next()){
					ScoreStudent ScoreStudent = new ScoreStudent();
					ScoreStudent.setUserid(rs.getInt("userid"));
					ScoreStudent.setUsername(rs.getString("username"));
					ScoreStudent.setCollegeid(rs.getInt("collegeid"));
					ScoreStudent.setCollegename(rs.getString("collegename"));
					ScoreStudent.setScorenumber(rs.getDouble("scorenumber"));
					ScoreStudent.setClassid(rs.getInt("classid"));
					ScoreStudent.setClassname(rs.getString("classname"));
					ScoreStudent.setMajorid(rs.getInt("majorid"));
					ScoreStudent.setMajorname(rs.getString("majorname"));
					
					list.add(ScoreStudent);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
	
	public ScoreStudent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreStudent(int userid, String username, int collegeid,
			String collegename, double scorenumber, int classid,
			String classname, int majorid, String majorname) {
		super();
		this.userid = userid;
		this.username = username;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
