package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Classes;
import model.College;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.CollegeDAO;

public class CollegeDaoImpl implements CollegeDAO {

	private BaseDao bdao = null;
	public CollegeDaoImpl(){
		bdao = new BaseDaoImpl();
	}
	
	@Override
	public boolean insert(College college) {
		String sql = "insert into t_college(collegeid,collegename) values(?,?)";
		Object[] param = {college.getCollegeid(),college.getCollegename()};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int collegeid) {
		String sql = "delete from t_college where collegeid=?";
		Object[] param = {collegeid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public College selectByid(int collegeid) {
		String sql = "select * from t_college where collegeid=?";
		Object[] param = {collegeid};
		ResultSet rs = bdao.select(sql, param);
		College college = null;
		
		college = new College(rs);
		if(college==null || college.getCollegeid()==0){
			return null;
		}else{
			return college;
		}
	}

	@Override
	public List<College> select() {
		String sql = "select * from t_college";
		ResultSet rs = bdao.select(sql);
		List<College> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = College.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public List<College> selectByPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
