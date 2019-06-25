package model;

/**
 * VCollegeScoreId entity. @author MyEclipse Persistence Tools
 */

public class VCollegeScoreId implements java.io.Serializable {

	// Fields

	private Integer collegeid;
	private String collegename;
	private Double scorenumber;
	private Double allscore;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public VCollegeScoreId() {
	}

	/** full constructor */
	public VCollegeScoreId(Integer collegeid, String collegename,
			Double scorenumber, Double allscore, Integer sportid) {
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
		this.allscore = allscore;
		this.sportid = sportid;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VCollegeScoreId))
			return false;
		VCollegeScoreId castOther = (VCollegeScoreId) other;

		return ((this.getCollegeid() == castOther.getCollegeid()) || (this
				.getCollegeid() != null && castOther.getCollegeid() != null && this
				.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getScorenumber() == castOther.getScorenumber()) || (this
						.getScorenumber() != null
						&& castOther.getScorenumber() != null && this
						.getScorenumber().equals(castOther.getScorenumber())))
				&& ((this.getAllscore() == castOther.getAllscore()) || (this
						.getAllscore() != null
						&& castOther.getAllscore() != null && this
						.getAllscore().equals(castOther.getAllscore())))
				&& ((this.getSportid() == castOther.getSportid()) || (this
						.getSportid() != null && castOther.getSportid() != null && this
						.getSportid().equals(castOther.getSportid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37
				* result
				+ (getScorenumber() == null ? 0 : this.getScorenumber()
						.hashCode());
		result = 37 * result
				+ (getAllscore() == null ? 0 : this.getAllscore().hashCode());
		result = 37 * result
				+ (getSportid() == null ? 0 : this.getSportid().hashCode());
		return result;
	}

}