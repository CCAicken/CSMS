package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ��������ʵ����
 * @author Administrator
 *
 */
public class Match {

	private int matchid;
	private Project project;
	private Student user;
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(int matchid, Project project, Student user) {
		super();
		this.matchid = matchid;
		this.project = project;
		this.user = user;
	}

	public int getMatchid() {
		return matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

	public Project getproject() {
		return project;
	}

	public void setproject(Project project) {
		this.project = project;
	}

	public Student getUser() {
		return user;
	}

	public void setUser(Student user) {
		this.user = user;
	}
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Match(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.matchid = rs.getInt("matchid");
				Project project = new Project(rs);
				this.project = project;
				Student user = new Student(rs);
				this.user = user;
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
		List<Match> list = new ArrayList<Match>();
		if(rs != null){
			try{
				do{
					Match match = new Match();
					match.setMatchid((rs.getInt("matchid")));
					Project project = new Project();
					project.setProid(rs.getInt("proid"));
					match.setproject(project);
					Student user = new Student();
					user.setUserid(rs.getString("userid"));
					match.setUser(user);;
					list.add(match);
				}while(rs.next());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
