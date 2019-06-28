package business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.TConfig;
import model.TMatch;
import model.VMatch;

import org.apache.struts2.ServletActionContext;

import basic.iHibBaseDAO;
import business.dao.MatchDAO;

public class MatchDaoImpl implements MatchDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	// public MatchDaoImpl() {
	// bdao = new iHibBaseDAOImpl();
	// }

	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig) session.getAttribute("config");

	@Override
	public boolean insert(TMatch match) {
		String proName = "up_AddMatch(?,?,?,?,?,?)";
		Object[] para = { match.getProid(), match.getUserid(),
				match.getUsername(), match.getSportid(), match.getClassid(),
				match.getCollegeid() };
		int result = (Integer) bdao.executeProduce(proName, para);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	// public static void main(String[] args) {
	// MatchDAO mdao = new MatchDaoImpl();
	// TMatch match = new TMatch();
	// match.setClassid(1);
	// match.setCollegeid(3);
	// match.setProid(11);
	// match.setSportid(2);
	// match.setUserid("90001");
	// match.setUsername("jishi");
	// System.out.print(mdao.insert(match));
	// }

	@Override
	public boolean isSignUp(String userid, int proid) {
		String proName = "up_AddMatch(?,?)";
		Object[] para = { proid, userid };
		int row = (Integer) bdao.executeProduce(proName, para);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<VMatch> selectByUser(String userid) {
		String hql = "from VMatch where userid=?";
		Object[] para = { userid };
		return bdao.select(hql, para);
	}

	@Override
	public List<VMatch> select() {
		String hql = "from VMatch";
		return bdao.select(hql);
	}

	@Override
	public List<VMatch> selectByPage(int startPage, int pageSize) {
		String hql = "from VMatch";
		List<VMatch> list = (List<VMatch>) bdao.selectByPage(hql, startPage,
				pageSize);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMatch";
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VMatch> selectAll() {
		String hql = "select proname,protype,currentnum,totallimit from VMatch  group by proname,currentnum,totallimit,protype order by proname";
		List<VMatch> matchlist = new ArrayList<VMatch>();
		List list = bdao.select(hql);
		for (Object obj : list) {
			Object[] objs = (Object[]) obj;
			VMatch match = new VMatch();
			match.setProname((String) objs[0]);
			match.setProtype((Integer) objs[1]);
			match.setCurrentnum((Integer) objs[2]);
			match.setTotallimit((Integer) objs[3]);
			matchlist.add(match);
		}
		return matchlist;
	}

	@Override
	public int countUser(int proid, String userid) {
		String hql = "select count(matchid) from TMatch where proid=? and userid=?";
		Object[] para = { proid, userid };
		int count = bdao.selectValue(hql, para);
		return count;
	}

	@Override
	public List<VMatch> getByid(String strwhere, int page, int limit) {
		// TODO Auto-generated method stub
		String hql = "from VMatch";
		if (strwhere != null && !strwhere.equals("")) {
			hql += strwhere + " and sportid=" + config.getSportid();
		} else {
			hql += " where sportid=" + config.getSportid();
		}
		List<VMatch> list = bdao.selectByPage(hql, page, limit);
		return list;
	}

	@Override
	public int getByidCount(String strwhere) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from VMatch";
		if (strwhere != null && !strwhere.equals("")) {
			hql += strwhere + " and sportid=" + config.getSportid();
		} else {
			hql += " where sportid=" + config.getSportid();
		}
		int count = bdao.selectValue(hql);
		return count;
	}

	// public static void main(String[] args) {
	// MatchDAO mdao = new MatchDaoImpl();
	// // List<VMatch> list = mdao.getByid(null, 1, 10);
	// System.out.print(mdao.getByidCount(null));
	// }
}
