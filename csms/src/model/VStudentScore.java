package model;

/**
 * VStudentScore entity. @author MyEclipse Persistence Tools
 */

public class VStudentScore implements java.io.Serializable {

	private Integer scoreid;
	private Integer matchid;
	private Double scorenumber;
	private Integer proid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private String rolename;
	private String userid;
	private String collegename;
	private Integer collegeid;
	private String majorname;
	private String classname;
	private Integer majorid;
	private String username;
	private Integer roleid;
	private Integer classid;
	private String mobile;
	private String agend;
	private String pwd;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public VStudentScore() {
	}

	/** minimal constructor */
	public VStudentScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String userid,
			Integer collegeid, String majorname) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.userid = userid;
		this.collegeid = collegeid;
		this.majorname = majorname;
	}

	/** full constructor */
	public VStudentScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String proname,
			Integer scenelimit, Integer collegelimit, Integer totallimit,
			Integer protype, String rolename, String userid,
			String collegename, Integer collegeid, String majorname,
			String classname, Integer majorid, String username, Integer roleid,
			Integer classid, String mobile, String agend, String pwd,
			Integer sportid) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.rolename = rolename;
		this.userid = userid;
		this.collegename = collegename;
		this.collegeid = collegeid;
		this.majorname = majorname;
		this.classname = classname;
		this.majorid = majorid;
		this.username = username;
		this.roleid = roleid;
		this.classid = classid;
		this.mobile = mobile;
		this.agend = agend;
		this.pwd = pwd;
		this.sportid = sportid;
	}

	// Property accessors

	public Integer getScoreid() {
		return this.scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
	}

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public Integer getScenelimit() {
		return this.scenelimit;
	}

	public void setScenelimit(Integer scenelimit) {
		this.scenelimit = scenelimit;
	}

	public Integer getCollegelimit() {
		return this.collegelimit;
	}

	public void setCollegelimit(Integer collegelimit) {
		this.collegelimit = collegelimit;
	}

	public Integer getTotallimit() {
		return this.totallimit;
	}

	public void setTotallimit(Integer totallimit) {
		this.totallimit = totallimit;
	}

	public Integer getProtype() {
		return this.protype;
	}

	public void setProtype(Integer protype) {
		this.protype = protype;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAgend() {
		return this.agend;
	}

	public void setAgend(String agend) {
		this.agend = agend;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}
}