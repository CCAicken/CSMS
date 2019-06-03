package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.properties.RoleType;
import model.Student;
import model.Teacher;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.UserDAO;

public class UserDaoImpl implements UserDAO {
	private BaseDao bdao = null;
	public UserDaoImpl(){
		bdao = new BaseDaoImpl();
	}
	@Override
	public Student loginStu(String userid, String pwd) {
		String sql = "select * from V_Student where userid=? and pwd=?";
		Object[] param = {userid,pwd};
		ResultSet rs = bdao.select(sql,param);
		
		Student student = new Student(rs);
		bdao.close();
		if(student.getUserid()==null || student.getUserid().equals("")){
			return null;
		}else{
			return student;
		}
		
	}

	@Override
	public Teacher loginTea(String userid, String pwd) {
		String sql = "select * from V_Teacher where userid=? and pwd=?";
		Object[] param = {userid,pwd};
		ResultSet rs = bdao.select(sql,param);
		
		Teacher teacher = new Teacher(rs);
		bdao.close();
		if(teacher.getUserid()==null || teacher.getUserid().equals("")){
			return null;
		}else{
			return teacher;
		}
	}
	
	@Override
	public boolean insertStu(Student user) {
		String sql = "insert into T_User(userid,userbame,pwd,agend,mobile,classid,roleid) values(?,?,?,?,?,?,?)";
		Object[] param = {user.getUserid(),user.getUsername(),user.getPwd(),user.getAgend(),user.getMobile(),user.getClasses().getClassid(),user.getRole().getRoleid()};
		int row = bdao.insert(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean insertTea(Teacher user) {
		String sql = "insert into T_User(userid,userbame,pwd,agend,mobile,collegeid,roleid) values(?,?,?,?,?,?,?)";
		Object[] param = {user.getUserid(),user.getUsername(),user.getPwd(),user.getAgend(),user.getMobile(),user.getCollege().getCollegeid(),user.getRole().getRoleid()};
		int row = bdao.insert(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean updateStuPwd(String userid,String pwd) {
		String sql = "update T_Student set pwd=? where userid=?";
		Object[] param = {pwd,userid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean updateTeaPwd(String userid,String pwd) {
		String sql = "update T_Teacher set pwd=? where userid=?";
		Object[] param = {pwd,userid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteStu(String userid) {
		String sql = "delete from T_Student where userid=?";
		Object[] param = {userid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Student getStudent(String userid) {
		String sql = "select * from V_Student where userid=?";
		Object[] param = {userid};
		ResultSet rs = bdao.select(sql,param);
		
		Student student = new Student(rs);
		bdao.close();
		if(student.getUserid()==null || student.getUserid().equals("")){
			return null;
		}else{
			return student;
		}
	}

	@Override
	public List<Student> selectStuByColl(String collegeid) {
		String sql = "select * from V_Student where collegeid=?";
		Object[] param = {collegeid};
		ResultSet rs = bdao.select(sql, param);
		List<Student> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Student.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public List<Student> selectStuByMajor(String majorid) {
		String sql = "select * from V_Student where majorid=?";
		Object[] param = {majorid};
		ResultSet rs = bdao.select(sql, param);
		List<Student> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Student.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	
	@Override
	public List<Student> selectStuByClass(String classid) {
		String sql = "select * from V_Student where classid=?";
		Object[] param = {classid};
		ResultSet rs = bdao.select(sql, param);
		List<Student> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Student.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
	@Override
	public boolean deleteTea(String userid) {
		String sql = "delete from T_Teacher where userid=?";
		Object[] param = {userid};
		int row = bdao.update(sql, param);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public Teacher getTeacher(String userid) {
		String sql = "select * from V_Teacher where userid=?";
		Object[] param = {userid};
		ResultSet rs = bdao.select(sql, param);
		Teacher user = null;
		try {
			if(rs!=null&&rs.next()){
				user = new Teacher(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return user;
		}
	}
	@Override
	public List<Teacher> selectTeaByColl(String collegeid) {
		String sql = "select * from V_Teacher where collegeid=?";
		Object[] param = {collegeid};
		ResultSet rs = bdao.select(sql, param);
		List<Teacher> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Teacher.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}
}