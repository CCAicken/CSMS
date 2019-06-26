package model;

/**
 * TMatch entity. @author MyEclipse Persistence Tools
 */

public class TMatch implements java.io.Serializable {

	// Fields

	private Integer matchid;
	private Integer proid;
	private String username;
	private Integer classid;
	private Integer collegeid;
	private String userid;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public TMatch() {
	}

	/** minimal constructor */
	public TMatch(Integer proid, String userid) {
		this.proid = proid;
		this.userid = userid;
	}

	/** full constructor */
	public TMatch(Integer proid, String username, Integer classid,
			Integer collegeid, String userid, Integer sportid) {
		this.proid = proid;
		this.username = username;
		this.classid = classid;
		this.collegeid = collegeid;
		this.userid = userid;
		this.sportid = sportid;
	}

	// Property accessors

	public Integer getMatchid() {
		return this.matchid;
	}

	public void setMatchid(Integer matchid) {
		this.matchid = matchid;
	}

	public Integer getProid() {
		return this.proid;
	}

	public void setProid(Integer proid) {
		this.proid = proid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

}