package business.impl;

import java.util.List;

import model.VClassScore;
import model.VStudentScore;
import basic.iHibBaseDAO;
import business.dao.ScoreStudentDAO;

public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public VStudentScore getByUserid(String userid) {
		String hql = "from VStudentScore where userid=?";
		Object[] param = {userid};
		List<VStudentScore> list = bdao.select(hql,param);
		if(list!=null && list.size()>0){
			for(VStudentScore score:list){
				VStudentScore newScore = score;
				return newScore;
			}
			return null;
		}else{
			return null;
		}
	}

	@Override
	public List<VStudentScore> getAllScoreStudent() {
		String hql = "from VStudentScore";
		List<VStudentScore> list = bdao.select(hql);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<VStudentScore> getAllScoreByPage(int startPage,int pageSize) {
		String hql = "from VStudentScore";
		List<VStudentScore> list=bdao.selectByPage(hql, startPage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public int allScoreCount() {
		String hql = "select count(classid) from VClassScore";
		int count = bdao.selectValue(hql);
		return count;
	}
	@Override
	public double allScore(String userid) {
		String hql = "select sum(scorenumber) as scorenumber from VScore where userid=?";
		Object[] param = {userid};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return (Double)list.get(0);
		}else{
			return 0;
		}
	}
	@Override
	public double avgScore(String userid) {
		String hql = "select avg(scorenumber) as scorenumber from VScore where userid=?";
		Object[] param = {userid};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			return (Double)list.get(0);
		}else{
			return 0;
		}
	}

}
