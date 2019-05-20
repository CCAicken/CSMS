package model;

import java.sql.Timestamp;

/**
 * TConfig entity. @author MyEclipse Persistence Tools
 */

public class TConfig implements java.io.Serializable {

	// Fields

	private Integer configid;
	private Timestamp starttime;
	private Timestamp endtime;
	private Timestamp reportstart;
	private Timestamp reportend;

	// Constructors

	/** default constructor */
	public TConfig() {
	}

	/** full constructor */
	public TConfig(Timestamp starttime, Timestamp endtime,
			Timestamp reportstart, Timestamp reportend) {
		this.starttime = starttime;
		this.endtime = endtime;
		this.reportstart = reportstart;
		this.reportend = reportend;
	}

	// Property accessors

	public Integer getConfigid() {
		return this.configid;
	}

	public void setConfigid(Integer configid) {
		this.configid = configid;
	}

	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Timestamp getReportstart() {
		return this.reportstart;
	}

	public void setReportstart(Timestamp reportstart) {
		this.reportstart = reportstart;
	}

	public Timestamp getReportend() {
		return this.reportend;
	}

	public void setReportend(Timestamp reportend) {
		this.reportend = reportend;
	}

}