package model;


/**
 * VNews entity. @author MyEclipse Persistence Tools
 */

public class VNews implements java.io.Serializable {

	private Integer newid;
	private String newstitle;
	private String newscontent;
	private String datetime;
	private Integer sportid;
	private String adminuserid;
	private String realname;
	private String mobile;
	private Integer userstatus;
	private Integer roleId;
	private String name;

	// Constructors

	/** default constructor */
	public VNews() {
	}

	/** minimal constructor */
	public VNews(Integer newid, String newstitle, String newscontent,
			String datetime, String adminuserid, String realname,
			Integer userstatus, Integer roleId, String name) {
		this.newid = newid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.datetime = datetime;
		this.adminuserid = adminuserid;
		this.realname = realname;
		this.userstatus = userstatus;
		this.roleId = roleId;
		this.name = name;
	}

	/** full constructor */
	public VNews(Integer newid, String newstitle, String newscontent,
			String datetime, Integer sportid, String adminuserid,
			String realname, String mobile, Integer userstatus, Integer roleId,
			String name) {
		this.newid = newid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.datetime = datetime;
		this.sportid = sportid;
		this.adminuserid = adminuserid;
		this.realname = realname;
		this.mobile = mobile;
		this.userstatus = userstatus;
		this.roleId = roleId;
		this.name = name;
	}

	// Property accessors

	public Integer getNewid() {
		return this.newid;
	}

	public void setNewid(Integer newid) {
		this.newid = newid;
	}

	public String getNewstitle() {
		return this.newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewscontent() {
		return this.newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public String getDatetime() {
		return this.datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public Integer getSportid() {
		return this.sportid;
	}

	public void setSportid(Integer sportid) {
		this.sportid = sportid;
	}

	public String getAdminuserid() {
		return this.adminuserid;
	}

	public void setAdminuserid(String adminuserid) {
		this.adminuserid = adminuserid;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VNews))
			return false;
		VNews castOther = (VNews) other;

		return ((this.getNewid() == castOther.getNewid()) || (this.getNewid() != null
				&& castOther.getNewid() != null && this.getNewid().equals(
				castOther.getNewid())))
				&& ((this.getNewstitle() == castOther.getNewstitle()) || (this
						.getNewstitle() != null
						&& castOther.getNewstitle() != null && this
						.getNewstitle().equals(castOther.getNewstitle())))
				&& ((this.getNewscontent() == castOther.getNewscontent()) || (this
						.getNewscontent() != null
						&& castOther.getNewscontent() != null && this
						.getNewscontent().equals(castOther.getNewscontent())))
				&& ((this.getDatetime() == castOther.getDatetime()) || (this
						.getDatetime() != null
						&& castOther.getDatetime() != null && this
						.getDatetime().equals(castOther.getDatetime())))
				&& ((this.getSportid() == castOther.getSportid()) || (this
						.getSportid() != null && castOther.getSportid() != null && this
						.getSportid().equals(castOther.getSportid())))
				&& ((this.getAdminuserid() == castOther.getAdminuserid()) || (this
						.getAdminuserid() != null
						&& castOther.getAdminuserid() != null && this
						.getAdminuserid().equals(castOther.getAdminuserid())))
				&& ((this.getRealname() == castOther.getRealname()) || (this
						.getRealname() != null
						&& castOther.getRealname() != null && this
						.getRealname().equals(castOther.getRealname())))
				&& ((this.getMobile() == castOther.getMobile()) || (this
						.getMobile() != null && castOther.getMobile() != null && this
						.getMobile().equals(castOther.getMobile())))
				&& ((this.getUserstatus() == castOther.getUserstatus()) || (this
						.getUserstatus() != null
						&& castOther.getUserstatus() != null && this
						.getUserstatus().equals(castOther.getUserstatus())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNewid() == null ? 0 : this.getNewid().hashCode());
		result = 37 * result
				+ (getNewstitle() == null ? 0 : this.getNewstitle().hashCode());
		result = 37
				* result
				+ (getNewscontent() == null ? 0 : this.getNewscontent()
						.hashCode());
		result = 37 * result
				+ (getDatetime() == null ? 0 : this.getDatetime().hashCode());
		result = 37 * result
				+ (getSportid() == null ? 0 : this.getSportid().hashCode());
		result = 37
				* result
				+ (getAdminuserid() == null ? 0 : this.getAdminuserid()
						.hashCode());
		result = 37 * result
				+ (getRealname() == null ? 0 : this.getRealname().hashCode());
		result = 37 * result
				+ (getMobile() == null ? 0 : this.getMobile().hashCode());
		result = 37
				* result
				+ (getUserstatus() == null ? 0 : this.getUserstatus()
						.hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

}