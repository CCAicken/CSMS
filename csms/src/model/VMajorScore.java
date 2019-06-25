package model;

/**
 * VMajorScore entity. @author MyEclipse Persistence Tools
 */

public class VMajorScore implements java.io.Serializable {
	private Integer majorid;
	private String collegename;
	private String majorname;
	private Double scorenumber;
	private Double allscore;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public VMajorScore() {
	}

	/** minimal constructor */
	public VMajorScore(String majorname) {
		this.majorname = majorname;
	}

	/** full constructor */
	public VMajorScore(Integer majorid, String collegename, String majorname,
			Double scorenumber, Double allscore, Integer sportid) {
		this.majorid = majorid;
		this.collegename = collegename;
		this.majorname = majorname;
		this.scorenumber = scorenumber;
		this.allscore = allscore;
		this.sportid = sportid;
	}

	// Property accessors

	public Integer getMajorid() {
		return this.majorid;
	}

	public void setMajorid(Integer majorid) {
		this.majorid = majorid;
	}

	public String getCollegename() {
		return this.collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public Double getScorenumber() {
		return this.scorenumber;
	}

	public void setScorenumber(Double scorenumber) {
		this.scorenumber = scorenumber;
	}

	public Double getAllscore() {
		return this.allscore;
	}

	public void setAllscore(Double allscore) {
		this.allscore = allscore;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}
}