package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TProject;
import model.VSportProject;

import org.apache.struts2.ServletActionContext;

import basic.iHibBaseDAO;
import business.dao.ProjectDAO;

import common.properties.RoleType;

public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig) session.getAttribute("config");

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
	public List<VSportProject> select() {
		String hql = "from VSportProject where sportid=" + config.getSportid();
		return (List<VSportProject>) bdao.select(hql);
	}

	@Override
	public List<VSportProject> selectList(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VSportProject where sportid=" + config.getSportid()
				+ strwhere;
		List<VSportProject> list = (List<VSportProject>) bdao.selectByPage(hql,
				startPage, pageSize);
		return list;
	}

	@Override
	public List<VSportProject> selectByType(int type) {
		String hql = "from VSportProject where protype=? and sportid=?";
		Object[] param = { type, config.getSportid() };
		return (List<VSportProject>) bdao.select(hql, param);
	}

	@Override
	public List<VSportProject> selectByPage(String strwhere, int roletype,
			int startPage, int pageSize) {
		String hql = null;
		if (strwhere != null) {
			strwhere = " and " + strwhere;
		} else if (strwhere == null) {
			strwhere = "";
		}
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			hql = "from VSportProject where (protype=1 or protype=2) and sportid="
					+ config.getSportid() + strwhere;
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			hql = "from VSportProject where (protype=3 or protype=4) and sportid="
					+ config.getSportid() + strwhere;
		}
		List<VSportProject> list = bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}

	@Override
	public int getProCountByRole(String strwhere, int roletype) {
		String hql = null;
		if (strwhere != null) {
			strwhere = " and " + strwhere;
		} else if (strwhere == null) {
			strwhere = "";
		}
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			hql = "select count(*) from VSportProject where (protype=1 or protype=2) and sportid="
					+ config.getSportid() + strwhere;
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			hql = "select count(*) from VSportProject where (protype=3 or protype=4) and sportid="
					+ config.getSportid() + strwhere;
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public int getProCount(String strwhere) {
		String hql = null;
		hql = "select count(*) from VSportProject where sportid="
				+ config.getSportid() + strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public TProject getptoject(int projectid) {
		TProject pro = (TProject) bdao.findById(TProject.class, projectid);
		return pro;
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
