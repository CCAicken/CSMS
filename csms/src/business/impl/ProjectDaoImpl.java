package business.impl;

import java.util.List;

import model.TProject;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.ProjectDAO;

public class ProjectDaoImpl implements ProjectDAO {
	private iHibBaseDAO bdao;

	 public void setBdao(iHibBaseDAO bdao) {
	 this.bdao = bdao;
	 }
	

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
	public List<TProject> selectByType(int type) {
		String hql = "from TProject where protype=?";
		Object[] param = { type };
		return (List<TProject>) bdao.select(hql,param);
	}

}
