package business.impl;

import java.util.List;

import model.TProject;

import model.VProject;

import model.VStudent;

import basic.iHibBaseDAO;
import business.dao.ProjectDAO;
import common.properties.RoleType;

public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	// public ProjectDaoImpl() {
	// // TODO Auto-generated constructor stub
	// bdao = new iHibBaseDAOImpl();
	// }

	@Override
	public boolean insert(TProject project) {
		String res = (String) bdao.insert(project);
		if (res != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(TProject project) {
		TProject sqlproject = (TProject) bdao.findById(TProject.class,
				project.getProid());
		sqlproject.setProname(project.getProname());
		sqlproject.setScenelimit(project.getScenelimit());
		sqlproject.setCollegelimit(project.getCollegelimit());
		sqlproject.setTotallimit(project.getTotallimit());
		sqlproject.setProtype(project.getProtype());
		return bdao.update(sqlproject);

	}

	@Override
	public boolean delete(int projectid) {
		return bdao.delete(bdao.findById(TProject.class, projectid));
	}

	@Override
	public List<TProject> select() {
		String hql = "from TProject";
		return (List<TProject>) bdao.select(hql);
	}

	@Override
	public List<VProject> selectList(String strwhere,int startPage, int pageSize) {
		String hql = "from VProject"+strwhere;
		return (List<VProject>) bdao.selectByPage(hql, startPage, pageSize);
	}
	
	@Override
	public List<TProject> selectByType(int type) {
		String hql = "from TProject where protype=?";
		Object[] param = { type };
		return (List<TProject>) bdao.select(hql, param);
	}

	@Override
	public List<TProject> selectByPage(String strwhere, int roletype,
			int startPage, int pageSize) {
		String hql = null;
		if (strwhere != null) {
			if (roletype == RoleType.Student || roletype == RoleType.Committee) {
				hql = "from TProject where (protype=1 or protype=2) and "
						+ strwhere;
			} else if (roletype == RoleType.Teacher
					|| roletype == RoleType.Organization) {
				hql = "from TProject where (protype=3 or protype=4) and "
						+ strwhere;
			}
		} else {
			if (roletype == RoleType.Student || roletype == RoleType.Committee) {
				hql = "from TProject where (protype=1 or protype=2)";
			} else if (roletype == RoleType.Teacher
					|| roletype == RoleType.Organization) {
				hql = "from TProject where (protype=3 or protype=4)";
			}
		}
		List<TProject> list = bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}

	@Override
	public int getProCountByRole(String strwhere, int roletype) {
		String hql = null;
		if (strwhere != null) {
			if (roletype == RoleType.Student || roletype == RoleType.Committee) {
				hql = "select count(proid) from TProject where (protype=1 or protype=2) and "
						+ strwhere;
			} else if (roletype == RoleType.Teacher
					|| roletype == RoleType.Organization) {
				hql = "select count(proid) from TProject where (protype=3 or protype=4) and "
						+ strwhere;
			}
		} else {
			if (roletype == RoleType.Student || roletype == RoleType.Committee) {
				hql = "select count(proid) from TProject where (protype=1 or protype=2)";
			} else if (roletype == RoleType.Teacher
					|| roletype == RoleType.Organization) {
				hql = "select count(proid) from TProject where (protype=3 or protype=4)";
			}
		}
		int count = bdao.selectValue(hql);
		return count;
	}
	
	@Override
	public int getProCount(String strwhere) {
		String hql = null;
		hql = "select count(proid) from TProject"+ strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public TProject getptoject(int projectid) {
		TProject pro = (TProject) bdao.findById(TProject.class, projectid);
		return pro;
	}

	@Override
	public List<VStudent> selectPageClass(String strwhere, int classid,
			int page, int limit) {
		// TODO Auto-generated method stub
		String hql = "from VStudent where classid=?";
		if (strwhere != null && !strwhere.equals("")) {
			hql += strwhere;
		}
		Object[] para = { classid };
		return bdao.selectByPage(hql, para, page, limit);
	}

	@Override
	public int stuAmount(String strwhere, int classid) {
		// TODO Auto-generated method stub
		String hql = "select count(userid) from VStudent where classid=?";
		if (strwhere != null && !strwhere.equals("")) {
			hql += strwhere;
		}
		Object[] para = { classid };
		int count = bdao.selectValue(hql, para);
		return count;
	}

	// public static void main(String[] args) {
	// ProjectDAO pdao = new ProjectDaoImpl();
	// // int row = pdao.getProCount(2);
	// // List<TProject> list = pdao.selectByPage(1, 1, 3);
	// // for (TProject p : list) {
	// // System.out.println(p.getProname());
	// // }
	// List<VStudent> list = pdao.selectPageClass(null, 13, 1, 10);
	// for (VStudent stu : list) {
	// System.out.println(stu.getUsername());
	// }
	// }
}
