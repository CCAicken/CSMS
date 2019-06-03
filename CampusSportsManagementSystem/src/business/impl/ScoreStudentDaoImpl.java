package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ScoreClasses;
import model.ScoreStudent;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ScoreStudentDAO;

public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private BaseDao bdao=null;
	public ScoreStudentDaoImpl() {
		bdao=new BaseDaoImpl();
	}
	@Override
	public ScoreStudent getByClassid(int userid) {
		String sql="select userid,username,collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where userid=? GROUP BY classid,classname,collegeid,collegename,majorid,majorname,userid,username";
		Object[] param={userid};
		ResultSet rs=bdao.select(sql, param);
		
		ScoreStudent studentscore =new ScoreStudent(rs);
		if(studentscore.getUsername()!=null||studentscore.getUsername().equals("")){
			bdao.close();
			return studentscore;
		}else {
			bdao.close();
			return null;
		}
	}

	@Override
	public List<ScoreStudent> getAllScoreStudent() {
		String sql="select userid,username,collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname,userid,username";
		ResultSet rs =bdao.select(sql);
		List<ScoreStudent> list=null;
		try {
			if(rs!=null&&rs.next()){
				list= ScoreStudent.toList(rs);
				bdao.close();
			}else {
				bdao.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ScoreStudent> getAllCollegeScoreBypage(ScoreStudent scorestudent) {
		// TODO Auto-generated method stub
		return null;
	}

}
