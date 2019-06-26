package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.TConfig;
import model.VScore;

import org.apache.struts2.ServletActionContext;

import basic.iHibBaseDAO;
import business.dao.ScoreStudentDAO;

public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig) session.getAttribute("config");

	@Override
	public VScore getByUserid(String userid) {
		String hql = "from VScore where userid=? and sportid=?";
		Object[] param = { userid, config.getSportid() };
		List<VScore> list = bdao.select(hql, param);
		if (list != null && list.size() > 0) {
			for (VScore score : list) {
				VScore newScore = score;
				return newScore;
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public List<VScore> getAllScoreByPage(String strwhere, int startPage,
			int pageSize) {
		String hql = "from VScore where sportid=" + config.getSportid()
				+ strwhere;
		List<VScore> list = bdao.selectByPage(hql, startPage, pageSize);
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

}
