package business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.MedalRank;
import model.TCollege;
import model.TConfig;
import model.TScore;
import model.VScore;
import model.VUserScore;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.iHibBaseDAO;
import business.dao.CollegeDAO;
import business.dao.ScoreDAO;
import business.factory.DAOFactory;

public class ScoreDaoImpl implements ScoreDAO {
	private iHibBaseDAO bdao;
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig) session.getAttribute("config");

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	// public ScoreDaoImpl(){
	// bdao = new iHibBaseDAOImpl();
	// }
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
		Object[] param = { userid, config.getSportid() };
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
		Object[] param = { collegeid, config.getSportid() };
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
		Object[] param = { classid, config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getCollegeScoreOrder() {
		String sql = "select top 10 a.collegename,Round(AVG(a.score),2) as scorenumber from (select top 100 collegename,Round(AVG(scorenumber),2) as score from V_Score where collegename!='' and sportid="
				+ config.getSportid()
				+ " group by collegename order by score desc union  select top 100 teacollegename,Round(AVG(scorenumber),2) as score from V_Score where teacollegename !=''  group by teacollegename order by score desc) as a group by a.collegename order by scorenumber desc";
		List<VScore> scorelist = bdao.selectBysql(sql);
		return scorelist;
	}

	@Override
	public List<VScore> getScoreByPage(String strwhere, int startPage, int limit) {
		String hql = "from VScore where sportid=" + config.getSportid()
				+ strwhere;
		List<VScore> list = bdao.selectByPage(hql, startPage, limit);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getScore(String strwhere) {
		String hql = "from VScore s1 where sportid="
				+ config.getSportid()
				+ " and scorenumber = (select max(s2.scorenumber) from VScore s2 group by s2.proid having s1.proid=s2.proid)"
				+ strwhere;
		List<VScore> list = bdao.select(hql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int allScoreCount(String strwhere) {
		String hql = "select count(*) from VScore where sportid="
				+ config.getSportid() + strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VScore> getScoreByProSingle(int proid) {
		String hql = "from VScore where proid=? and sportid=? and (protype=1 or protype=3) order by scorenumber desc";
		Object[] param = { proid, config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getScoreByProTeam(int proid) {
		String hql = "from VScore where proid=? and sportid=? and (protype=2 or protype=3) group by sceneid,teacollegeid,collegeid,classid order by scorenumber desc";
		Object[] param = { proid, config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
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
	public List<VUserScore> getAllScoreByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VUserScore where sportid=" + config.getSportid()
				+ strwhere;
		List<VUserScore> list = bdao.selectByPage(hql, startPage, pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	@Override
	public int allUserScoreCount(String strwhere) {
		String hql = "select count(*) from VUserScore where sportid="
				+ config.getSportid() + strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<HashMap<String, Integer>> getMedalRank(int rank) {
		String sql = "select collegeid,count(*) as count from (SELECT * FROM (select t.collegeid,t.proid,t.scorenumber,rank() over(partition by t.proid order by t.scorenumber desc) ranks from V_Score t where t.sportid="+config.getSportid()+") as b where b.ranks=" + rank +") as a group by collegeid";
		List<HashMap<String, Integer>> list = bdao.selectBysql(sql);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}
	
	@Override
	public List<MedalRank> getRank() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"factoryBean.xml");
		ScoreDAO scoredao = ctx.getBean("getScoreDAO", ScoreDAO.class);
		CollegeDAO collegedao = ctx.getBean("getCollegeDAO", CollegeDAO.class);
		List<TCollege> colllist = collegedao.select();
		List<HashMap<String, Integer>> goldlist = scoredao.getMedalRank(1);
		List<HashMap<String, Integer>> silverlist = scoredao.getMedalRank(2);
		List<HashMap<String, Integer>> bronzelist = scoredao.getMedalRank(3);
		List<MedalRank> newlist = new ArrayList();
		for (TCollege college : colllist) {
			MedalRank newrank = new MedalRank();
			newrank.setCollegeid(college.getCollegeid());
			newrank.setCollegename(college.getCollegename());
			newlist.add(newrank);
		}
		for (int i = 0; i < newlist.size(); i++) {
			for (int j = 0; j < goldlist.size(); j++) {
				if (newlist.get(i).getCollegeid() == goldlist.get(j).get(
						"collegeid")) {
					newlist.get(i).setGold(goldlist.get(j).get("count"));
					break;
				}
			}
			for (int j = 0; j < silverlist.size(); j++) {
				if (newlist.get(i).getCollegeid() == silverlist.get(j).get(
						"collegeid")) {
					newlist.get(i).setSilver(silverlist.get(j).get("count"));
					break;
				}
			}
			for (int j = 0; j < bronzelist.size(); j++) {
				if (newlist.get(i).getCollegeid() == bronzelist.get(j).get(
						"collegeid")) {
					newlist.get(i).setBronze(bronzelist.get(j).get("count"));
					break;
				}
			}
		}
		return newlist;
	}

	@Override
	public List<VScore> getAllCollScore() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"factoryBean.xml");
		CollegeDAO collegedao = ctx.getBean("getCollegeDAO", CollegeDAO.class);
		List<TCollege> colllist = collegedao.select();
		String sql = "select collegeid,collegename,CONVERT(float,MAX(scorenumber)) as scorenumber,sportid,sportname from V_Score group by collegeid,collegename,sportid,sportname";
		List<HashMap<String, Object>> allsorelist = bdao.selectBysql(sql);
		List<VScore> newlist = new ArrayList();
		for (TCollege college : colllist) {
			VScore newscore = new VScore();
			newscore.setCollegeid(college.getCollegeid());
			newscore.setCollegename(college.getCollegename());
			newlist.add(newscore);
		}
		for (int i = 0; i < newlist.size(); i++) {
			for (int j = 0; j < allsorelist.size(); j++) {
				if (newlist.get(i).getCollegeid().equals(allsorelist.get(j).get("collegeid"))) {
					Object sportid = allsorelist.get(j).get("sportid");
					Object sportname = allsorelist.get(j).get("sportname");
					Object scorenumber = allsorelist.get(j).get("scorenumber");
					newlist.get(i).setSportid((Integer)(sportid));
					newlist.get(i).setSportname((String)(sportname));
					newlist.get(i).setScorenumber((Double)scorenumber);
				}
			}
		}
		return newlist;
	}
}
