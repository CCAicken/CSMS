package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 用户实体类
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

	public Student(String userid, String username, String pwd, String agend,
			String mobile, Role role, Classes classes) {
		super();
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.role = role;
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

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Student(ResultSet rs){
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.userid = rs.getString("userid");
				this.username = rs.getString("username");
				this.pwd = rs.getString("pwd");
				this.agend = rs.getString("agend");
				this.mobile = rs.getString("mobile");
				Classes classes = new Classes();
				classes.setClassid(rs.getInt("classid"));
				classes.setClassname(rs.getString("classname"));
				Major major = new Major();
				major.setMajorid(rs.getInt("majorid"));
				major.setMajorname(rs.getString("majorname"));
				College college = new College();
				college.setCollegeid(rs.getInt("collegeid"));
				college.setCollegename(rs.getString("collegename"));
				major.setCollege(college);
				classes.setMajor(major);
				this.classes = classes;
				Role role = new Role();
				role.setRoleid(rs.getInt("roleid"));
				role.setRolename(rs.getString("rolename"));
				this.role = role;
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
		List<Student> list = new ArrayList<Student>();
		if(rs != null){
			try{
				do{
					Student user = new Student();
					user.setUserid(rs.getString("userid"));
					user.setAgend(rs.getString("agend"));
					user.setUsername(rs.getString("username"));
					user.setPwd(rs.getString("pwd"));
					user.setMobile(rs.getString("mobile"));Classes classes = new Classes();
					classes.setClassid(rs.getInt("classid"));
					classes.setClassname(rs.getString("classname"));
					Major major = new Major();
					major.setMajorid(rs.getInt("majorid"));
					major.setMajorname(rs.getString("majorname"));
					College college = new College();
					college.setCollegeid(rs.getInt("collegeid"));
					college.setCollegename(rs.getString("collegename"));
					major.setCollege(college);
					classes.setMajor(major);
					user.setClasses(classes);
					Role role = new Role();
					role.setRoleid(rs.getInt("roleid"));
					role.setRolename(rs.getString("rolename"));
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
