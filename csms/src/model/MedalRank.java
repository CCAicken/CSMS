package model;

public class MedalRank {

	private int collegeid;
	private String collegename;
	private int count;
	private int gold;
	private int silver;
	private int bronze;
	
	public MedalRank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedalRank(int collegeid,String collegename, int count,int gold,int silver,int bronze) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.count = count;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	public int getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBronze() {
		return bronze;
	}

	public void setBronze(int bronze) {
		this.bronze = bronze;
	}
	
}
