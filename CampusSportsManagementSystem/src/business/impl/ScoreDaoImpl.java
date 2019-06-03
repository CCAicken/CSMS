package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Classes;
import model.Match;
import model.Project;
import model.Score;
import model.Student;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ScoreDAO;

public class ScoreDaoImpl implements ScoreDAO {

	private BaseDao bdao=null;
	public ScoreDaoImpl(){
		bdao=new BaseDaoImpl();
	}
	@Override
	public boolean insert(Score score) {
		String sql="insert into T_Score(matchid,scorenumber) values(?,?)";
		Object[] param={score.getMatch(),score.getScorenumber()};
		int row = bdao.insert(sql,param);
		if(row>0)
		{
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean update(Score score) {
		String sql="update T_Score set matchid=?,scorenumber=? where scoreid=?";
		Object[] param={score.getMatch(),score.getScorenumber(),score.getScoreid()};
		int row= bdao.update(sql,param);
		if(row>0)
		{
		return true;	
		}else {
			return false;
		}
	}

	@Override
	public List<Score> getByUser(String userid) {
		String sql = "select * from V_StudentScore where userid=?";
		Object[] param = {userid};
		ResultSet rs = bdao.select(sql, param);
		List<Score> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Score.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public List<Score> getByCollege(int collegeid) {
		String sqString = "SELECT collegeid,collegename,proid,proname,protype,AVG(scorenumber) as score FROM ";
		String whereString = " where collegeid=? group by collegeid,collegename,proname,proid,protype";
		String sql = sqString+"V_TeacherScore"+whereString+" UNION "+sqString+"V_StudentScore"+whereString;
		Object[] param = {collegeid,collegeid};
		ResultSet rs = bdao.select(sql, param);
		List<Score> list = new ArrayList<Score>();
		try {
			if(rs!=null && rs.next()){
				do{
					Score score = new Score();
					score.setScorenumber(rs.getDouble("score"));
					Match match = new Match();
					Project project = new Project();
					project.setProname(rs.getString("proname"));
					project.setProtype(rs.getInt("protype"));
					match.setProject(project);
					score.setMatch(match);
					list.add(score);
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Score> getByClass(int classid) {
		String sql = "select proid,proname,protype,classid,classname,AVG(scorenumber) as score from V_StudentScore where classid=? group by proid,classid,proname,classname,protype";
		Object[] param = {classid};
		ResultSet rs = bdao.select(sql, param);
		List<Score> list = new ArrayList<Score>();
		try {
			if(rs!=null&&rs.next()){
				do{
					Score score = new Score();
					score.setScorenumber(rs.getDouble("score"));
					Match match = new Match();
					Project project = new Project();
					project.setProname(rs.getString("proname"));
					project.setProtype(rs.getInt("protype"));
					match.setProject(project);
					score.setMatch(match);
					list.add(score);
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
