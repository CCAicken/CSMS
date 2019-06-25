package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.TConfig;
import model.TScore;
import model.VScore;
import basic.iHibBaseDAO;
import business.dao.ScoreDAO;

public class ScoreDaoImpl implements ScoreDAO {
	private iHibBaseDAO bdao;
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig)session.getAttribute("config");
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
		String hql = "from VScore where userid=? and sportid=?";
		Object[] param = { userid,config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getByCollege(int collegeid) {
		String hql = "from VScore where collegeid=? and sportid=?";
		Object[] param = { collegeid,config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getByClass(int classid) {
		String hql = "from VScore where classid=? and sportid=?";
		Object[] param = { classid,config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getCollegeScoreOrder() {
		String sql = "select top 10 a.collegename,Round(AVG(a.score),2) as scorenumber from (select top 100 collegename,Round(AVG(scorenumber),2) as score from V_Score where collegename!='' and sportid="+config.getSportid()+" group by collegename order by score desc union  select top 100 teacollegename,Round(AVG(scorenumber),2) as score from V_Score where teacollegename !=''  group by teacollegename order by score desc) as a group by a.collegename order by scorenumber desc";
		List<VScore> scorelist = bdao.selectBysql(sql);
		return scorelist;
	}

	@Override
	public List<VScore> getScoreByPage(String strwhere, int startPage, int limit) {
		String hql = "from VScore where sportid="+config.getSportid() + strwhere;
		List<VScore> list = bdao.selectByPage(hql, startPage, limit);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	@Override
	public List<VScore> getScore(String strwhere) {
		String hql = "from VScore s1 where sportid="+config.getSportid()+" and scorenumber = (select max(s2.scorenumber) from VScore s2 group by s2.proid having s1.proid=s2.proid)" + strwhere;
		List<VScore> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int allScoreCount(String strwhere) {
		String hql = "select count(*) from VScore where sportid="+config.getSportid() + strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VScore> getScoreByProSingle(int proid) {
		String hql = "from VScore where proid=? and sportid=? and (protype=1 or protype=3) order by scorenumber desc";
		Object[] param = {proid,config.getSportid()};
		List<VScore> list = bdao.select(hql,param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	@Override
	public List<VScore> getScoreByProTeam(int proid) {
		String hql = "from VScore where proid=? and sportid=? and (protype=2 or protype=3) group by sceneid,teacollegeid,collegeid,classid order by scorenumber desc";
		Object[] param = {proid,config.getSportid()};
		List<VScore> list = bdao.select(hql,param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
}
