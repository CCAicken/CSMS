package business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
		int row = (Integer) bdao.insert(score);
		if (row > 0) {
			return true;
		} else {
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
		Object[] param = { userid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getByCollege(int collegeid) {
		String hql = "from VScore where collegeid=?";
		Object[] param = { collegeid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getByClass(int classid) {
		String hql = "from VScore where classid=?";
		Object[] param = { classid };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getCollegeScoreOrder() {
		String sql = "select a.collegename,Round(AVG(a.score),2) as scorenumber from (select top 100 collegename,Round(AVG(scorenumber),2) as score from V_Score where collegename!='' group by collegename order by score desc union  select top 100 teacollegename,Round(AVG(scorenumber),2) as score from V_Score where teacollegename !=''  group by teacollegename order by score desc) as a group by a.collegename order by scorenumber desc";

		List<VScore> scorelist = bdao.selectBysql(sql);
		return scorelist;
	}

}
