package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Classes;
import model.College;
import model.Major;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ClassesDAO;

public class ClassesDaoImpl implements ClassesDAO {

	private BaseDao bdao = null;
	public ClassesDaoImpl(){
		bdao = new BaseDaoImpl();
	}
	
	@Override
	public boolean insert(Classes classes) {
		String sql = "insert into t_class(classid,classname,majorid) values(?,?,?)";
		Object[] param = {classes.getClassid(),classes.getClassname(),classes.getMajor().getMajorid()};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int classid) {
		String sql = "delete from t_class where classid=?";
		Object[] param = {classid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Classes selectByid(int classid) {
		String sql = "select * from v_student where classid=?";
		Object[] param = {classid};
		ResultSet rs = bdao.select(sql, param);
		Classes classes = null;
		classes = new Classes(rs);
		if(classes==null || classes.getClassid()==0){
			return null;
		}else{
			return classes;
		}
	}

	@Override
	public List<Classes> select() {
		String sql = "select * from V_Class";
		ResultSet rs = bdao.select(sql);
		List<Classes> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Classes.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public List<Classes> selectByMajor(int majorid) {
		String sql = "select * from t_class where majorid=?";
		Object[] param = {majorid};
		ResultSet rs = bdao.select(sql,param);
		List<Classes> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Classes.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

}
