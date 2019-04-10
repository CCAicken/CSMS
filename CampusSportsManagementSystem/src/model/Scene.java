package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ������Ϣʵ����
 * @author Administrator
 *
 */
public class Scene {
	private int sceneid;
	private Arrange arrange;
	private Match match;
	
	public Scene() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scene(int sceneid, Arrange arrange, Match match) {
		super();
		this.sceneid = sceneid;
		this.arrange = arrange;
		this.match = match;
	}

	public int getSceneid() {
		return sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public Arrange getArrange() {
		return arrange;
	}

	public void setArrange(Arrange arrange) {
		this.arrange = arrange;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Scene(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.sceneid = rs.getInt("matchid");
				Arrange arrange = new Arrange(rs);
				this.arrange = arrange;
				Match match = new Match(rs);
				this.match = match;
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
		List<Scene> list = new ArrayList<Scene>();
		if(rs != null){
			try{
				while(rs.next()){
					Scene scene = new Scene();
					scene.setSceneid(rs.getInt("sceneid"));
					Arrange arrange = new Arrange();
					arrange.setArrid(rs.getInt("arrid"));
					scene.setArrange(arrange);
					Match match = new Match();
					match.setMatchid(rs.getInt("matchid"));
					scene.setMatch(match);
					list.add(scene);
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
