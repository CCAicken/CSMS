package business.impl;

import java.util.List;

import model.TProject;
import model.TScene;
import model.VScene;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.SceneDAO;

public class SceneDaoImpl implements SceneDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	
	@Override
	public boolean insert(TScene scene) {
		String res=	(String) bdao.insert(scene);
		if(res!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<VScene> seleScenes() {
		String hql = "from VScene";
		return (List<VScene>) bdao.select(hql);
	}

	@Override
	public List<VScene> seleScenes(String userid) {
		String hql = "from TProject where userid=?";
		Object[] param = { userid };
		return (List<VScene>) bdao.select(hql,param);
	}

	@Override
	public List<VScene> seleOtherScenes(String userid) {
		String hql = "from TProject where userid=?";
		Object[] param = { userid };
		return (List<VScene>) bdao.select(hql,param);
	}

}
