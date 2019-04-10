package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * �ɼ�ʵ����
 * @author Administrator
 *
 */
public class Score {

	private int scoreid;
	private Match match;
	private double scorenumber;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(int scoreid, Match match, double scorenumber) {
		super();
		this.scoreid = scoreid;
		this.match = match;
		this.scorenumber = scorenumber;
	}

	public int getScoreid() {
		return scoreid;
	}

	public void setScoreid(int scoreid) {
		this.scoreid = scoreid;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public double getScorenumber() {
		return scorenumber;
	}

	public void setScorenumber(double scorenumber) {
		this.scorenumber = scorenumber;
	}
	/**
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<Score> list = new ArrayList<Score>();
		if(rs != null){
			try{
				while(rs.next()){
					Score score = new Score();
					score.setScoreid(rs.getInt("scoreid"));
					score.setScorenumber(rs.getDouble("scorenumber"));
					Match match = new Match();
					match.setMatchid(rs.getInt("matchid"));
					score.setMatch(match);;
					list.add(score);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
