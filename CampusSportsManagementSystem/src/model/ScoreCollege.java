package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreCollege {
	private int collegeid;
	private String collegename;
	private double scorenumber;
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public ScoreCollege(ResultSet rs){
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.collegeid = rs.getInt("collegeid");
				this.scorenumber = rs.getDouble("scorenumber");
				this.collegename=rs.getString("collegename");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<ScoreCollege> list = new ArrayList<ScoreCollege>();
		if(rs != null){
			try{
				while(rs.next()){
					ScoreCollege ScoreCollege = new ScoreCollege();
					ScoreCollege.setCollegeid(rs.getInt("collegeid"));
					ScoreCollege.setScorenumber(rs.getDouble("scorenumber"));
					ScoreCollege.setCollegename(rs.getString("collegename"));
					list.add(ScoreCollege);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
	
	
	
	public ScoreCollege(int collegeid, String collegename, double scorenumber) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
	}
	public ScoreCollege() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getScorenumber() {
		return scorenumber;
	}
	public void setScorenumber(double scorenumber) {
		this.scorenumber = scorenumber;
	}
}
