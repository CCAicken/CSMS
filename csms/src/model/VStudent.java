package model;

/**
 * VStudent entity. @author MyEclipse Persistence Tools
 */

public class VStudent implements java.io.Serializable {
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Integer classid;
	private Integer roleid;
	private String rolename;
	private String classname;
	private Integer majorid;
	private String majorname;
	private Integer collegeid;
	private String collegename;
	private Integer limit;

	// Constructors

	/** default constructor */
	public VStudent() {
	}

	/** minimal constructor */
	public VStudent(String userid, String username, String pwd, String agend,
			String mobile, Integer classid, Integer roleid, String rolename,
			Integer limit) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.classid = classid;
		this.roleid = roleid;
		this.rolename = rolename;
		this.limit = limit;
	}

	/** full constructor */
	public VStudent(String userid, String username, String pwd, String agend,
			String mobile, Integer classid, Integer roleid, String rolename,
			String classname, Integer majorid, String majorname,
			Integer collegeid, String collegename, Integer limit) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.classid = classid;
		this.roleid = roleid;
		this.rolename = rolename;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.limit = limit;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
}