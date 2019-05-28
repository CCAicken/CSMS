package business.impl;

import java.util.List;

import model.VStudent;
import model.VTeacher;
import model.VStudent;
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
	public VStudent loginStu(String userid, String pwd) {
		VStudent student = (VStudent)bdao.findById(VStudent.class, userid);
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
//		VStudent stu = dao.loginStu("1001", "123456");
//		//VStudent stu = dao.geVStudent("1001");
//		if(stu!=null){
//		System.out.print(stu.getUsername());
//		}
//	}
	@Override
	public boolean insertStu(VStudent user) {
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
		VStudent stu= (VStudent)bdao.findById(VStudent.class, userid);
		stu.setPwd(pwd);
		boolean flag = bdao.update(stu);
		return flag;
	}
//public static void main(String[] args){
//	UserDaoImpl udao= new UserDaoImpl();
//	System.out.println(udao.updateTeaPwd("94001", "111111"));
//}
	@Override
	public boolean deleteStu(String userid) {
		VStudent student = (VStudent)bdao.findById(VStudent.class, userid);
		if(student != null && !student.getUserid().equals("")){
			return bdao.delete(student);
		}else{
			return false;
		}
	}

	@Override
	public VStudent getStudent(String userid) {
		VStudent student = (VStudent)bdao.findById(VStudent.class, userid);
		if(student != null && !student.getUserid().equals("")){
			return student;
		}else{
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByColl(String collegeid) {
		String hql = "from VStudent where collegeid=?";
		Object[] param = {collegeid};
		List<VStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByMajor(String majorid) {
		String hql = "from VStudent where majorid=?";
		Object[] param = {majorid};
		List<VStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByClass(String classid) {
		String hql = "from VStudent where classid=?";
		Object[] param = {classid};
		List<VStudent> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public VTeacher loginTea(String userid, String pwd) {
		VTeacher tea = (VTeacher)bdao.findById(VTeacher.class, userid);
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
	public boolean insertTea(VTeacher user) {
		int row = (Integer)bdao.insert(user);
		if (row>0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateTeaPwd(String userid, String pwd) {
		VTeacher tea = (VTeacher) bdao.findById(VTeacher.class, userid);
		tea.setPwd(pwd);
		return bdao.update(tea);
	}
//	public static void main(String[] args){
//		UserDAO dao = new UserDaoImpl();
//		TStudent stu = dao.getStudent("1001");
//		if(stu!=null){
//		System.out.print(dao.updateTeaPwd("94001", "123456"));
//		}
//	}
	@Override
	public boolean deleteTea(String userid) {
		VTeacher teacher = (VTeacher)bdao.findById(VTeacher.class, userid);
		if(teacher != null && !teacher.getUserid().equals("")){
			return bdao.delete(teacher);
		}else{
			return false;
		}
	}

	@Override
	public VTeacher getTeacher(String userid) {
		VTeacher teacher = (VTeacher)bdao.findById(VTeacher.class, userid);
		if(teacher != null && !teacher.getUserid().equals("")){
			return teacher;
		}else{
			return null;
		}
	}

	@Override
	public List<VTeacher> selectTeaByColl(String collegeid) {
		String hql = "from VTeacher where collegeid=?";
		Object[] param = {collegeid};
		List<VTeacher> list = bdao.select(hql, param);
		if(list!=null&& list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
