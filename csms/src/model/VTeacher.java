package model;

/**
 * VTeacher entity. @author MyEclipse Persistence Tools
 */

public class VTeacher implements java.io.Serializable {
	private String userid;
	private String username;
	private String pwd;
	private String agend;
	private String mobile;
	private Integer collegeid;
	private Integer roleid;
	private Integer limit;
	private String collegename;
	private String rolename;

	// Constructors

	/** default constructor */
	public VTeacher() {
	}

	/** full constructor */
	public VTeacher(String userid, String username, String pwd, String agend,
			String mobile, Integer collegeid, Integer roleid, Integer limit,
			String collegename, String rolename) {
		this.userid = userid;
		this.username = username;
		this.pwd = pwd;
		this.agend = agend;
		this.mobile = mobile;
		this.collegeid = collegeid;
		this.roleid = roleid;
		this.limit = limit;
		this.collegename = collegename;
		this.rolename = rolename;
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

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}