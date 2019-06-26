package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TProject;
import model.VSportProject;

import org.apache.struts2.ServletActionContext;

import basic.iHibBaseDAO;
import business.dao.ProjectDAO;

public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig) session.getAttribute("config");

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	// public ProjectDaoImpl() {
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
		if (roletype == 0) {
			hql = "from VSportProject where (protype=1 or protype=2) and sportid="
					+ config.getSportid() + strwhere;
		} else if (roletype == 1) {
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
		if (roletype == 0) {
			hql = "select count(*) from VSportProject where (protype=1 or protype=2) and sportid="
					+ config.getSportid() + strwhere;
		} else if (roletype == 1) {
			hql = "select count(*) from VSportProject where (protype=3 or protype=4) and sportid="
					+ config.getSportid() + strwhere;
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public int getProCount(String strwhere) {
		String hql = null;
		if (strwhere != null) {
			strwhere = " and " + strwhere;
		} else if (strwhere == null) {
			strwhere = "";
		}
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

	public List<VSportProject> getAllProject(String strwhere, int page,
			int limit) {
		if (strwhere != null) {
			strwhere = " and " + strwhere;
		} else if (strwhere == null) {
			strwhere = "";
		}
		String hql = "from VSportProject where sportid=" + config.getSportid();
		if (strwhere != null) {
			hql += strwhere;
		}
		List<VSportProject> list = bdao.selectByPage(hql, page, limit);
		return list;
	}

	@Override
	public int getAllAmount(String strwhere) {
		// TODO Auto-generated method stub
		if (strwhere != null) {
			strwhere = " and " + strwhere;
		} else if (strwhere == null) {
			strwhere = "";
		}
		String hql = "select count(*) from VSportProject where sportid="
				+ config.getSportid();
		if (strwhere != null) {
			hql += strwhere;
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	// public static void main(String[] args) {
	// ProjectDAO pdao = new ProjectDaoImpl();
	// List<VSportProject> list = pdao.get
	// }
}
