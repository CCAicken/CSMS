package model;

/**
 * VTeacherScore entity. @author MyEclipse Persistence Tools
 */

public class VTeacherScore implements java.io.Serializable {

	private Integer scoreid;
	private Integer matchid;
	private Double scorenumber;
	private Integer proid;
	private String userid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private String rolename;
	private String username;
	private String mobile;
	private Integer collegeid;
	private Integer roleid;
	private String collegename;
	private String pwd;
	private String agend;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public VTeacherScore() {
	}

	/** minimal constructor */
	public VTeacherScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String userid, String collegename) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.userid = userid;
		this.collegename = collegename;
	}

	/** full constructor */
	public VTeacherScore(Integer scoreid, Integer matchid,
			Double scorenumber, Integer proid, String userid, String proname,
			Integer scenelimit, Integer collegelimit, Integer totallimit,
			Integer protype, String rolename, String username, String mobile,
			Integer collegeid, Integer roleid, String collegename, String pwd,
			String agend, Integer sportid) {
		this.scoreid = scoreid;
		this.matchid = matchid;
		this.scorenumber = scorenumber;
		this.proid = proid;
		this.userid = userid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.rolename = rolename;
		this.username = username;
		this.mobile = mobile;
		this.collegeid = collegeid;
		this.roleid = roleid;
		this.collegename = collegename;
		this.pwd = pwd;
		this.agend = agend;
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

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
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

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}
}