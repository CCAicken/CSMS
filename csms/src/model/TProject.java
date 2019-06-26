package model;

/**
 * TProject entity. @author MyEclipse Persistence Tools
 */

public class TProject implements java.io.Serializable {

	// Fields

	private Integer proid;
	private String proname;
	private Integer scenelimit;
	private Integer collegelimit;
	private Integer totallimit;
	private Integer protype;
	private Integer currentnum;
	private String record;
	private String holderid;
	private Integer classid;
	private String holdername;
	private Integer collegeid;
	private Integer sportid;

	// Constructors

	/** default constructor */
	public TProject() {
	}

	/** minimal constructor */
	public TProject(String proname, Integer scenelimit, Integer collegelimit,
			Integer totallimit, Integer protype, Integer currentnum) {
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.currentnum = currentnum;
	}

	/** full constructor */
	public TProject(String proname, Integer scenelimit, Integer collegelimit,
			Integer totallimit, Integer protype, Integer currentnum,
			String record, String holderid, Integer classid, String holdername,
			Integer collegeid, Integer sportid) {
		this.proname = proname;
		this.scenelimit = scenelimit;
		this.collegelimit = collegelimit;
		this.totallimit = totallimit;
		this.protype = protype;
		this.currentnum = currentnum;
		this.record = record;
		this.holderid = holderid;
		this.classid = classid;
		this.holdername = holdername;
		this.collegeid = collegeid;
		this.sportid = sportid;
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

	public String getHolderid() {
		return this.holderid;
	}

	public void setHolderid(String holderid) {
		this.holderid = holderid;
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getHoldername() {
		return this.holdername;
	}

	public void setHoldername(String holdername) {
		this.holdername = holdername;
	}

	public Integer getCollegeid() {
		return this.collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

}