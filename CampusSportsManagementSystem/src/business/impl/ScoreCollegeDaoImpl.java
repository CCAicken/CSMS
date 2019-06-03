package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import util.ToolsUtil;
import model.ScoreCollege;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ScoreCollegeDAO;

public class ScoreCollegeDaoImpl implements ScoreCollegeDAO {

	private BaseDao bdao = null;

	public ScoreCollegeDaoImpl() {
		bdao = new BaseDaoImpl();
	}

	@Override
	public ScoreCollege getByCollegeid(int collegeid) {
		String sql = "SELECT collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from (select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where collegeid=? GROUP BY collegeid,collegename UNION ALL select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_TeacherScore where collegeid=? GROUP BY collegeid,collegename) as a where collegeid=? GROUP BY collegeid,collegename";
		Object[] param = { collegeid, collegeid, collegeid };
		ResultSet rs = bdao.select(sql, param);

		ScoreCollege sCollege = new ScoreCollege(rs);
		if (sCollege.getCollegename() != null
				|| sCollege.getCollegename().equals("")) {
			bdao.close();
			return sCollege;
		} else {
			bdao.close();
			return null;
		}

	}

	@Override
	public List<ScoreCollege> getSearchCollege(String opretion) {
		String sql = "SELECT collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from (select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where collegename='"
				+ opretion
				+ "' GROUP BY collegeid,collegename UNION ALL select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_TeacherScore where collegename='"
				+ opretion
				+ "' GROUP BY collegeid,collegename) as a where collegename='"
				+ opretion + "' GROUP BY collegeid,collegename";
		ResultSet rs = bdao.select(sql);
		List<ScoreCollege> list = null;
		try {
			if (rs != null && rs.next()) {
				list = ScoreCollege.toList(rs);
				bdao.close();
			} else {
				bdao.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ScoreCollege> getAllCollegeScore(String action, String opretion) {
		ResultSet rs;
		if (action.equals("all") && opretion.equals("all")) {
			String sql = "SELECT collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from (select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY collegeid,collegename UNION ALL select collegeid,collegename, ROUND(AVG(scorenumber), 2) as scorenumber from V_TeacherScore GROUP BY collegeid,collegename) as a GROUP BY collegeid,collegename";
			rs = bdao.select(sql);
		} else {
			String sql = "select * from V_CollegeScore where collegeid=?";
			Object[] param = { opretion };
			rs = bdao.selectByPage(sql, param, 20, 1);
		}

		List<ScoreCollege> list = null;
		try {
			if (rs != null && rs.next()) {
				list = ScoreCollege.toList(rs);
				bdao.close();
			} else {
				bdao.close();
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public int getpageAmount(int pageSize) {
		String sql = "select * from V_CollegeScore";
		int amount = bdao.pageAmount(sql, pageSize);
		return amount;
	}

	@Override
	public int getpageAmountbysearch(String opraton, int pageSize) {
		String sql=""; 
		if (ToolsUtil.isInteger(opraton)) {
			sql="select * from V_CollegeScore where collegeid=?";
		} else {
			sql= "select * from V_CollegeScore where collegename=?";
		}
		Object[] param = {opraton };
		int amount = bdao.pageAmount(sql, param, pageSize);
		return amount;
	}

	@Override
	public List<ScoreCollege> getAllCollegeScoreBypage(String opretion,int pageSize,int currpage) {
		String sql = "";
		List<ScoreCollege> list = null;
		if (ToolsUtil.isInteger(opretion)) {
			if (opretion.equals("0")) {
				sql = "select * from V_CollegeScore";
				ResultSet rs = bdao.selectByPage(sql, pageSize, currpage);
				if (rs != null) {
					list = ScoreCollege.toList(rs, pageSize);
				}
				bdao.close();
				return list;
			} else {
				sql = "select * from V_CollegeScore where collegeid=?";
				Object[] param = { opretion };
				ResultSet rs = bdao.selectByPage(sql, param, pageSize, currpage);
				if (rs != null) {
					list = ScoreCollege.toList(rs, pageSize);
				}
				bdao.close();
				return list;
			}

		} else {
			sql = "select * from V_CollegeScore where collegename=?";
			Object[] param = { opretion };
			ResultSet rs = bdao.selectByPage(sql, param, pageSize, currpage);
			if (rs != null) {
				list = ScoreCollege.toList(rs, pageSize);
			}
			bdao.close();
			return list;
		}

	}
}
