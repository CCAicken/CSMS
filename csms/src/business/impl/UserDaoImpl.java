package business.impl;

import java.util.List;

import model.TStudent;
import model.TTeacher;
import model.VStudent;
import model.VTeacher;
import basic.iHibBaseDAO;
import business.dao.UserDAO;

public class UserDaoImpl implements UserDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	//
	// public UserDaoImpl() {
	// bdao = new iHibBaseDAOImpl();
	// }

	@Override
	public VStudent loginStu(String userid, String pwd) {
		VStudent student = (VStudent) bdao.findById(VStudent.class, userid);
		if (student != null && !student.getUserid().equals("")) {
			if (student.getPwd().equals(pwd)) {
				return student;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	// public static void main(String[] args){
	// UserDAO dao = new UserDaoImpl();
	// VStudent stu = dao.loginStu("1001", "123456");
	// //VStudent stu = dao.geVStudent("1001");
	// if(stu!=null){
	// System.out.print(stu.getUsername());
	// }
	// }
	@Override
	public boolean insertStu(VStudent user) {
		int row = (Integer) bdao.insert(user);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateStuPwd(String userid, String pwd) {
		// String sql="update T_Student set pwd=? where userid=?";
		// Object[] param = {pwd,userid};
		TStudent stu = (TStudent) bdao.findById(TStudent.class, userid);
		stu.setPwd(pwd);
		boolean flag = bdao.update(stu);
		return flag;
	}

	@Override
	public boolean deleteStu(String userid) {
		VStudent student = (VStudent) bdao.findById(VStudent.class, userid);
		if (student != null && !student.getUserid().equals("")) {
			return bdao.delete(student);
		} else {
			return false;
		}
	}

	@Override
	public VStudent getStudent(String userid) {
		VStudent student = (VStudent) bdao.findById(VStudent.class, userid);
		if (student != null && !student.getUserid().equals("")) {
			return student;
		} else {
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByColl(String collegeid) {
		String hql = "from VStudent where collegeid=?";
		Object[] param = { collegeid };
		List<VStudent> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByMajor(String majorid) {
		String hql = "from VStudent where majorid=?";
		Object[] param = { majorid };
		List<VStudent> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VStudent> selectStuByClass(String classid) {
		String hql = "from VStudent where classid=?";
		Object[] param = { classid };
		List<VStudent> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	// public static void main(String[] args){
	// UserDaoImpl udao= new UserDaoImpl();
	// List<VStudent> list = udao.selectStuByClassPage(3, 1, 5);
	// for(VStudent stu:list){
	// System.out.println(stu.getClassname());
	// }
	// }

	@Override
	public int stucount(String strwhere, int classid) {
		String hql = null;
		if (strwhere != null) {
			hql = "select count(userid) from VStudent where classid=? and "
					+ strwhere;
		} else {
			hql = "select count(userid) from VStudent where classid=?";
		}
		Object[] para = { classid };
		int count = bdao.selectValue(hql, para);
		return count;
	}

	@Override
	public List<VStudent> selectStuByClassPage(String strwhere, int classid,
			int page, int limit) {
		String hql = null;
		if (strwhere != null) {
			hql = "from VStudent where classid=? and " + strwhere;
		} else {
			hql = "from VStudent where classid=?";
		}
		Object[] param = { classid };
		List<VStudent> list = bdao.selectByPage(hql, param, page, limit);
		return list;
	}

	@Override
	public VTeacher loginTea(String userid, String pwd) {
		VTeacher tea = (VTeacher) bdao.findById(VTeacher.class, userid);
		if (tea != null && !tea.getUserid().equals("")) {
			if (tea.getPwd().equals(pwd)) {
				return tea;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public boolean insertTea(VTeacher user) {
		int row = (Integer) bdao.insert(user);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTeaPwd(String userid, String pwd) {
		TTeacher tea = (TTeacher) bdao.findById(TTeacher.class, userid);
		tea.setPwd(pwd);
		return bdao.update(tea);
	}

	@Override
	public boolean deleteTea(String userid) {
		VTeacher teacher = (VTeacher) bdao.findById(VTeacher.class, userid);
		if (teacher != null && !teacher.getUserid().equals("")) {
			return bdao.delete(teacher);
		} else {
			return false;
		}
	}

	@Override
	public VTeacher getTeacher(String userid) {
		VTeacher teacher = (VTeacher) bdao.findById(VTeacher.class, userid);
		if (teacher != null && !teacher.getUserid().equals("")) {
			return teacher;
		} else {
			return null;
		}
	}

	@Override
	public List<VTeacher> selectTeaByColl(String collegeid) {
		String hql = "from VTeacher where collegeid=?";
		Object[] param = { collegeid };
		List<VTeacher> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VTeacher> selectTeaByCollPage(String strwhere, int collegeid,
			int page, int limit) {
		String hql = null;
		if (strwhere != null) {
			hql = "from VTeacher where collegeid=? and " + strwhere;
		} else {
			hql = "from VTeacher where collegeid=?";
		}
		Object[] param = { collegeid };
		List<VTeacher> list = bdao.selectByPage(hql, param, page, limit);
		return list;
	}

	@Override
	public int teacount(String strwhere, int collegeid) {
		String hql = null;
		if (strwhere != null) {
			hql = "select count(userid) from VTeacher where collegeid=? and "
					+ strwhere;
		} else {
			hql = "select count(userid) from VTeacher where collegeid=?";
		}
		Object[] para = { collegeid };
		int count = bdao.selectValue(hql, para);
		return count;
	}

	// public static void main(String[] args) {
	// UserDAO dao = new UserDaoImpl();
	// List<VTeacher> list = dao.selectTeaByCollPage(null, 1, 1, 10);
	// System.out.print(list.get(0).getUsername());
	// }

}
