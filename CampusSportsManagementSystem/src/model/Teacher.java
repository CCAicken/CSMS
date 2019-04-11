package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.properties.RoleType;
/**
 * �û�ʵ����
 * @author Administrator
 *
 */
public class Teacher {
	
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Role role;
	private College college;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(String userid, String username, String pwd,
			String agend, String mobile, Role role, College college) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.role = role;
		this.college = college;
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
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Teacher(ResultSet rs){
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.userid = rs.getString("userid");
				this.username = rs.getString("username");
				this.pwd = rs.getString("pwd");
				this.agend = rs.getString("agend");
				this.mobile = rs.getString("mobile");
				Role role = new Role(rs);
				this.role = role;
				College college = new College(rs);
				this.college = college;
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
		List<Teacher> list = new ArrayList<Teacher>();
		if(rs != null){
			try{
				do{
					Teacher user = new Teacher();
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
					list.add(user);
				}while(rs.next());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
