package model;

/**
 * TForumTitle entity. @author MyEclipse Persistence Tools
 */

public class TForumTitle implements java.io.Serializable {

	// Fields

	private Integer forumid;
	private String title;

	// Constructors

	/** default constructor */
	public TForumTitle() {
	}

	/** full constructor */
	public TForumTitle(String title) {
		this.title = title;
	}

	// Property accessors

	public Integer getForumid() {
		return this.forumid;
	}

	public void setForumid(Integer forumid) {
		this.forumid = forumid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}