package business.impl;

import java.util.List;

import model.TStudent;
import model.TTeacher;
import basic.iHibBaseDAO;
import business.dao.UserDAO;

public class UserDaoImpl implements UserDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
//	public UserDaoImpl(){
//		bdao =  new iHibBaseDAOImpl();
//	}
	@Override
	public TStudent loginStu(String userid, String pwd) {
		TStudent student = (TStudent)bdao.findById(TStudent.class, userid);
		if(student != null && !student.getUserid().equals("")){
			if(student.getPwd().equals(pwd)){
				return student;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
//	public static void main(String[] args){
//		UserDAO dao = new UserDaoImpl();
//		TStudent stu = dao.loginStu("1001", "123456");
//		//TStudent stu = dao.getStudent("1001");
//		if(stu!=null){
//		System.out.print(stu.getUsername());
//		}
//	}
	@Override
	public boolean insertStu(TStudent user) {
		int row = (Integer)bdao.insert(user);
		if (row>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateStuPwd(String userid, String pwd) {
//		String sql="update T_Student set pwd=? where userid=?";
//		Object[] param = {pwd,userid};
		TStudent stu= (TStudent)bdao.findById(TStudent.class, userid);
		stu.setPwd(pwd);
		boolean flag = bdao.update(stu);
		return flag;
	}
//public static void main(String[] args){
//	UserDaoImpl udao= new UserDaoImpl();
//	System.out.println(udao.updateStuPwd("1001", "111111"));
//}
	@Override
	public boolean deleteStu(String userid) {
		TStudent student = (TStudent)bdao.findById(TStudent.class, userid);
		if(student != null && !student.getUserid().equals("")){
			return bdao.delete(student);
		}else{
			return false;
		}
	}

	@Override
	public TStudent getStudent(String userid) {
		TStudent student = (TStudent)bdao.findById(TStudent.class, userid);
		if(student != null && !student.getUserid().equals("")){
			return student;
		}else{
			return null;
		}
	}

	@Override
	public List<TStudent> selectStuByColl(String collegeid) {
		String hql = "from TStudent where collegeid=?";
		Object[] param = {collegeid};
		List<TStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<TStudent> selectStuByMajor(String majorid) {
		String hql = "from TStudent where majorid=?";
		Object[] param = {majorid};
		List<TStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<TStudent> selectStuByClass(String classid) {
		String hql = "from TStudent where classid=?";
		Object[] param = {classid};
		List<TStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public TTeacher loginTea(String userid, String pwd) {
		TTeacher tea = (TTeacher)bdao.findById(TTeacher.class, userid);
		if(tea != null && !tea.getUserid().equals("")){
			if(tea.getPwd().equals(pwd)){
				return tea;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	@Override
	public boolean insertTea(TTeacher user) {
		int row = (Integer)bdao.insert(user);
		if (row>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateTeaPwd(String userid, String pwd) {
		TTeacher teacher = new TTeacher();
		teacher.setUserid(userid);
		teacher.setPwd(pwd);
		return bdao.update(teacher);
	}

	@Override
	public boolean deleteTea(String userid) {
		TTeacher teacher = (TTeacher)bdao.findById(TTeacher.class, userid);
		if(teacher != null && !teacher.getUserid().equals("")){
			return bdao.delete(teacher);
		}else{
			return false;
		}
	}

	@Override
	public TTeacher getTeacher(String userid) {
		TTeacher teacher = (TTeacher)bdao.findById(TTeacher.class, userid);
		if(teacher != null && !teacher.getUserid().equals("")){
			return teacher;
		}else{
			return null;
		}
	}

	@Override
	public List<TTeacher> selectTeaByColl(String collegeid) {
		String hql = "from TTeacher where collegeid=?";
		Object[] param = {collegeid};
		List<TTeacher> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
