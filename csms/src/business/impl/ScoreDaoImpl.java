package business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.MedalRank;
import model.TCollege;
import model.TConfig;
import model.TScore;
import model.VScore;
import basic.iHibBaseDAO;
import business.dao.ScoreDAO;
import business.factory.DAOFactory;

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
	@Override
	public double allScore(String userid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where userid=? and sportid=?";
		Object[] param = { userid, config.getSportid() };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return (Double) list.get(0);
		} else {
			return 0;
		}
	}

	@Override
	public double avgScore(String userid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where userid=? and sportid=?";
		Object[] param = { userid, config.getSportid() };
		List list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return (Double) list.get(0);
		} else {
			return 0;
		}
	}

	@Override
	public List<MedalRank> getMedalRank(int rank) {
		String hql = "select a.collegeid,a.collegename,count(*) as count from (SELECT * FROM (select t.collegeid,t.collegename,t.proid,t.scorenumber,rank() over(partition by t.proid order by t.scorenumber desc) ranks from V_Score t) as b where b.ranks=?) as a group by a.collegeid,a.collegename;";
		Object[] param = {rank};
		List<MedalRank> list = bdao.select(hql,param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	@Override
	public List getRank() {
		List list = new ArrayList();
		List<TCollege> colllist = DAOFactory.getCollegeDAO().select();
		List<MedalRank> goldlist = DAOFactory.getScoreDAO().getMedalRank(1);
		List<MedalRank> silverlist = DAOFactory.getScoreDAO().getMedalRank(2);
		List<MedalRank> bronzelist = DAOFactory.getScoreDAO().getMedalRank(3);
		String[] medallist = {};
		for(int i=0;i<colllist.size();i++){
			String collegestr = colllist.get(i).toString();
			medallist[i] = collegestr;
		}
		for(int j=0;j<medallist.length;j++){
			for(int k=0;k<goldlist.size();k++){
				if(goldlist.get(k).getCollegeid() == Integer.parseInt(medallist[j])){
					String gold = "'gold':'"+goldlist.get(k).getGold()+"'";
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		ScoreDAO sdao = new ScoreDaoImpl();
		List list = sdao.getMedalRank(1);
		System.out.println(list.size());
	}

}
