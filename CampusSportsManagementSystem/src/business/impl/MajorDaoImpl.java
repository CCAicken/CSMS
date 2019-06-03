package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Major;
import model.Student;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.MajorDAO;

public class MajorDaoImpl implements MajorDAO {

	private BaseDao bdao = null;
	public MajorDaoImpl(){
		bdao = new BaseDaoImpl();
	}
	
	@Override
	public boolean insert(Major major) {
		String sql = "insert into t_major(majorid,majorname,collegeid) values(?,?,?)";
		Object[] param = {major.getMajorid(),major.getMajorname(),major.getCollege().getCollegeid()};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int majorid) {
		String sql = "delete from t_major where majorid=?";
		Object[] param = {majorid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Major selectByid(int majorid) {
		String sql = "select * from t_major where majorid=?";
		Object[] param = {majorid};
		ResultSet rs = bdao.select(sql, param);
		Major major = null;
		try {
			if(rs!=null&&rs.next()){
				major = new Major(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return major;
		}
	}

	@Override
	public List<Major> select() {
		String sql = "select * from V_Major";
		ResultSet rs = bdao.select(sql);
		List<Major> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Major.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public List<Major> selectByColl(int collegeid) {
		String sql = "select * from t_major where collegeid=?";
		Object[] param = {collegeid};
		ResultSet rs = bdao.select(sql, param);
		List<Major> list = new ArrayList<Major>();
		try {
			if(rs!=null&&rs.next()){
				list = Major.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
}
