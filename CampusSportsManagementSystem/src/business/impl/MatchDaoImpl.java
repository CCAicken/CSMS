package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Init;

import common.properties.RoleType;
import model.College;
import model.Match;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.MatchDAO;
import business.factory.DAOFactory;

public class MatchDaoImpl implements MatchDAO {
	private BaseDao bdao = null;
	public MatchDaoImpl() {
		bdao = new BaseDaoImpl();
	}

	@Override
	public boolean insert(Match match) {
		if(match.getRoleid() == RoleType.Student){
			String proName = "up_AddMatch(?,?)";
			Object[] param = {match.getProject().getProid(),match.getStudent().getUserid()};
			int row = (Integer)bdao.executeProduce(proName, param);
			if(row>0){
				return true;
			}else{
				return false;
			}
		}else{
			String proName = "up_AddMatch(?,?)";
			Object[] param = {match.getProject().getProid(),match.getTeacher().getUserid()};
			int row = (Integer)bdao.executeProduce(proName, param);
			if(row>0){
				return true;
			}else{
				return false;
			}
		}
	}

	@Override
	public List<Match> selectByUser(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSignUp(String userid, int proid) {
		String sql = "select * from t_match where userid=? and proid=?";
		Object[] param = {userid,proid};
		ResultSet rs = bdao.select(sql, param);
		College college = null;
		try {
			if(rs!=null&&rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
