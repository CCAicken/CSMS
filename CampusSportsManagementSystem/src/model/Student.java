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
public class Student {
	
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Role role;
	private Classes classes;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String userid, String username, String pwd,
			String agend, String mobile,Classes classes,Role role) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.classes = classes;
		this.role = role;
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
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Student(ResultSet rs){
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.userid = rs.getString("userid");
				this.username = rs.getString("username");
				this.pwd = rs.getString("pwd");
				this.agend = rs.getString("agend");
				this.mobile = rs.getString("mobile");
				Classes classes = new Classes(rs);
				this.classes = classes;
				Role role = new Role(rs);
				this.role = role;
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
		List<Student> list = new ArrayList<Student>();
		if(rs != null){
			try{
				do{
					Student user = new Student();
					user.setUserid(rs.getString("userid"));
					user.setAgend(rs.getString("agend"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));
					Classes classes = new Classes();
					classes.setClassid(rs.getInt("classid"));
					user.setClasses(classes);
					Role role = new Role();
					role.setRoleid(rs.getInt("roleid"));
					user.setRole(role);
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
