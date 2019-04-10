package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * �û�ʵ����
 * @author Administrator
 *
 */
public class User {
	
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Role role;
	private College college;
	private Classes classes;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userid, String username, String pwd,
			String agend, String mobile, Role role, College college,Classes classes) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.role = role;
		this.college = college;
		this.classes = classes;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAgend() {
		return agend;
	}
	public void setAgend(String agend) {
		this.agend = agend;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	/**
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<User> list = new ArrayList<User>();
		if(rs != null){
			try{
				while(rs.next()){
					User user = new User();
					user.setUserid(rs.getString("userid"));
					user.setAgend(rs.getString("agend"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));
					Role role = new Role();
					role.setRoleid(rs.getInt("roleid"));
					user.setRole(role);
					College college = new College();
					college.setCollegeid(rs.getInt("collegeid"));
					user.setCollege(college);
					Classes classes = new Classes();
					classes.setClassid(rs.getInt("classid"));
					user.setClasses(classes);
					list.add(user);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
