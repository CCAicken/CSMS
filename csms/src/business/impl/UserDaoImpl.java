package business.impl;

import java.util.List;

import model.TStudent;
import model.TTeacher;
import business.dao.UserDAO;

public class UserDaoImpl implements UserDAO {

	@Override
	public TStudent loginStu(String userid, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertStu(TStudent user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStuPwd(String userid, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStu(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TStudent getStudent(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TStudent> selectStuByColl(String collegeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TStudent> selectStuByMajor(String majorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TStudent> selectStuByClass(String classid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TTeacher loginTea(String userid, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertTea(TTeacher user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeaPwd(String userid, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTea(String userid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TTeacher getTeacher(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TTeacher> selectTeaByColl(String collegeid) {
		// TODO Auto-generated method stub
		return null;
	}

}
