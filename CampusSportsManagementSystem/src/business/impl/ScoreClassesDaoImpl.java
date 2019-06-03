package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ScoreClasses;
import model.ScoreCollege;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ScoreClassesDAO;

public class ScoreClassesDaoImpl implements ScoreClassesDAO {

	private BaseDao bdao=null;
	public ScoreClassesDaoImpl(){
		bdao=new BaseDaoImpl();
	}
	@Override
	public ScoreClasses getByClassid(int classid) {
		String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where classid=? GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		Object[] param={classid};
		ResultSet rs=bdao.select(sql, param);
		
		ScoreClasses sClass =new ScoreClasses(rs);
		if(sClass.getClassname()!=null||sClass.getClassname().equals("")){
			bdao.close();
			return sClass;
		}else {
			bdao.close();
			return null;
		}
	}

	@Override
	public List<ScoreClasses> getAllScoreClasses() {
		String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		ResultSet rs =bdao.select(sql);
		List<ScoreClasses> list=null;
		try {
			if(rs!=null&&rs.next()){
				list= ScoreClasses.toList(rs);
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
	public List<ScoreClasses> getAllCollegeScoreBypage(ScoreClasses scoreclasses) {
		// TODO Auto-generated method stub
		return null;
	}

}
