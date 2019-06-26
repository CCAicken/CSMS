package model;

/**
 * VProject entity. @author MyEclipse Persistence Tools
 */

public class VProject implements java.io.Serializable {

	private Integer proid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private Integer currentnum;
	private String record;
	private Integer collegeid;
	private String collegename;
	private Integer classid;
	private String classname;
	private Integer majorid;
	private String majorname;
	private Integer sportid;
	private String sportname;
	private String holderid;
	private String holdername;

	// Constructors

	/** default constructor */
	public VProject() {
	}

	/** minimal constructor */
	public VProject(Integer proid, String proname, Integer scenelimit,
			Integer collegelimit, Integer totallimit, Integer protype,
			Integer currentnum, String sportname) {
		this.proid = proid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.currentnum = currentnum;
		this.sportname = sportname;
	}

	/** full constructor */
	public VProject(Integer proid, String proname, Integer scenelimit,
			Integer collegelimit, Integer totallimit, Integer protype,
			Integer currentnum, String record, Integer collegeid,
			String collegename, Integer classid, String classname,
			Integer majorid, String majorname, Integer sportid,
			String sportname, String holderid, String holdername) {
		this.proid = proid;
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.currentnum = currentnum;
		this.record = record;
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.classid = classid;
		this.classname = classname;
		this.majorid = majorid;
		this.majorname = majorname;
		this.sportid = sportid;
		this.sportname = sportname;
		this.holderid = holderid;
		this.holdername = holdername;
	}

	// Property accessors

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

	public Integer getCurrentnum() {
		return this.currentnum;
	}

	public void setCurrentnum(Integer currentnum) {
		this.currentnum = currentnum;
	}

	public String getRecord() {
		return this.record;
	}

	public void setRecord(String record) {
		this.record = record;
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

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
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

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public String getSportname() {
		return this.sportname;
	}

	public void setSportname(String sportname) {
		this.sportname = sportname;
	}

	public String getHolderid() {
		return this.holderid;
	}

	public void setHolderid(String holderid) {
		this.holderid = holderid;
	}

	public String getHoldername() {
		return this.holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VProject))
			return false;
		VProject castOther = (VProject) other;

		return ((this.getProid() == castOther.getProid()) || (this.getProid() != null
				&& castOther.getProid() != null && this.getProid().equals(
				castOther.getProid())))
				&& ((this.getProname() == castOther.getProname()) || (this
						.getProname() != null && castOther.getProname() != null && this
						.getProname().equals(castOther.getProname())))
				&& ((this.getScenelimit() == castOther.getScenelimit()) || (this
						.getScenelimit() != null
						&& castOther.getScenelimit() != null && this
						.getScenelimit().equals(castOther.getScenelimit())))
				&& ((this.getCollegelimit() == castOther.getCollegelimit()) || (this
						.getCollegelimit() != null
						&& castOther.getCollegelimit() != null && this
						.getCollegelimit().equals(castOther.getCollegelimit())))
				&& ((this.getTotallimit() == castOther.getTotallimit()) || (this
						.getTotallimit() != null
						&& castOther.getTotallimit() != null && this
						.getTotallimit().equals(castOther.getTotallimit())))
				&& ((this.getProtype() == castOther.getProtype()) || (this
						.getProtype() != null && castOther.getProtype() != null && this
						.getProtype().equals(castOther.getProtype())))
				&& ((this.getCurrentnum() == castOther.getCurrentnum()) || (this
						.getCurrentnum() != null
						&& castOther.getCurrentnum() != null && this
						.getCurrentnum().equals(castOther.getCurrentnum())))
				&& ((this.getRecord() == castOther.getRecord()) || (this
						.getRecord() != null && castOther.getRecord() != null && this
						.getRecord().equals(castOther.getRecord())))
				&& ((this.getCollegeid() == castOther.getCollegeid()) || (this
						.getCollegeid() != null
						&& castOther.getCollegeid() != null && this
						.getCollegeid().equals(castOther.getCollegeid())))
				&& ((this.getCollegename() == castOther.getCollegename()) || (this
						.getCollegename() != null
						&& castOther.getCollegename() != null && this
						.getCollegename().equals(castOther.getCollegename())))
				&& ((this.getClassid() == castOther.getClassid()) || (this
						.getClassid() != null && castOther.getClassid() != null && this
						.getClassid().equals(castOther.getClassid())))
				&& ((this.getClassname() == castOther.getClassname()) || (this
						.getClassname() != null
						&& castOther.getClassname() != null && this
						.getClassname().equals(castOther.getClassname())))
				&& ((this.getMajorid() == castOther.getMajorid()) || (this
						.getMajorid() != null && castOther.getMajorid() != null && this
						.getMajorid().equals(castOther.getMajorid())))
				&& ((this.getMajorname() == castOther.getMajorname()) || (this
						.getMajorname() != null
						&& castOther.getMajorname() != null && this
						.getMajorname().equals(castOther.getMajorname())))
				&& ((this.getSportid() == castOther.getSportid()) || (this
						.getSportid() != null && castOther.getSportid() != null && this
						.getSportid().equals(castOther.getSportid())))
				&& ((this.getSportname() == castOther.getSportname()) || (this
						.getSportname() != null
						&& castOther.getSportname() != null && this
						.getSportname().equals(castOther.getSportname())))
				&& ((this.getHolderid() == castOther.getHolderid()) || (this
						.getHolderid() != null
						&& castOther.getHolderid() != null && this
						.getHolderid().equals(castOther.getHolderid())))
				&& ((this.getHoldername() == castOther.getHoldername()) || (this
						.getHoldername() != null
						&& castOther.getHoldername() != null && this
						.getHoldername().equals(castOther.getHoldername())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getProid() == null ? 0 : this.getProid().hashCode());
		result = 37 * result
				+ (getProname() == null ? 0 : this.getProname().hashCode());
		result = 37
				* result
				+ (getScenelimit() == null ? 0 : this.getScenelimit()
						.hashCode());
		result = 37
				* result
				+ (getCollegelimit() == null ? 0 : this.getCollegelimit()
						.hashCode());
		result = 37
				* result
				+ (getTotallimit() == null ? 0 : this.getTotallimit()
						.hashCode());
		result = 37 * result
				+ (getProtype() == null ? 0 : this.getProtype().hashCode());
		result = 37
				* result
				+ (getCurrentnum() == null ? 0 : this.getCurrentnum()
						.hashCode());
		result = 37 * result
				+ (getRecord() == null ? 0 : this.getRecord().hashCode());
		result = 37 * result
				+ (getCollegeid() == null ? 0 : this.getCollegeid().hashCode());
		result = 37
				* result
				+ (getCollegename() == null ? 0 : this.getCollegename()
						.hashCode());
		result = 37 * result
				+ (getClassid() == null ? 0 : this.getClassid().hashCode());
		result = 37 * result
				+ (getClassname() == null ? 0 : this.getClassname().hashCode());
		result = 37 * result
				+ (getMajorid() == null ? 0 : this.getMajorid().hashCode());
		result = 37 * result
				+ (getMajorname() == null ? 0 : this.getMajorname().hashCode());
		result = 37 * result
				+ (getSportid() == null ? 0 : this.getSportid().hashCode());
		result = 37 * result
				+ (getSportname() == null ? 0 : this.getSportname().hashCode());
		result = 37 * result
				+ (getHolderid() == null ? 0 : this.getHolderid().hashCode());
		result = 37
				* result
				+ (getHoldername() == null ? 0 : this.getHoldername()
						.hashCode());
		return result;
	}

}