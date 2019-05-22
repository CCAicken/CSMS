package business.impl;

import java.util.List;

import model.TScore;
import model.VScore;
import basic.iHibBaseDAO;
import business.dao.ScoreDAO;

public class ScoreDaoImpl implements ScoreDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public boolean insert(TScore score) {
		int row = (Integer)bdao.insert(score);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(TScore score) {
		return bdao.update(score);
	}

	@Override
	public List<VScore> getByUser(String userid) {
		String hql = "from TScore where userid=?";
		Object[] param = {userid};
		List<VScore> list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VScore> getByCollege(int collegeid) {
		String hql = "from TScore where collegeid=?";
		Object[] param = {collegeid};
		List<VScore> list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VScore> getByClass(int classid) {
		String hql = "from TScore where classid=?";
		Object[] param = {classid};
		List<VScore> list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
