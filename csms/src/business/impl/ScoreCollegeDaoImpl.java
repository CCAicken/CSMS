package business.impl;

import java.util.List;

import model.VCollegeScore;
import basic.iHibBaseDAO;
import business.dao.ScoreCollegeDAO;

public class ScoreCollegeDaoImpl implements ScoreCollegeDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public VCollegeScore getByCollegeid(int collegeid) {
		VCollegeScore score = (VCollegeScore)bdao.findById(VCollegeScore.class, collegeid);
		if(score!= null && score.getCollegeid()!=0){
			return score;
		}else{
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getAllCollegeScore() {
		String hql="from VCollegeScore";
		List<VCollegeScore> list=bdao.select(hql);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getCollegeScoreBypage(String collegeName,
			int pageSize, int currpage) {
		String hql="from VCollegeScore where collegeName=?";
		Object[] param = {collegeName};
		List<VCollegeScore> list=bdao.selectByPage(hql,param, currpage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public List<VCollegeScore> getSearchCollege(String collegeName) {
		String hql="from VCollegeScore where collegeName=?";
		Object[] param = {collegeName};
		List<VCollegeScore> list=bdao.select(hql,param);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public int getpageAmount(int pageSize) {
		String sql="select count(*) from VCollegeScore";
		return bdao.selectPages(sql, pageSize);
	}

	@Override
	public int getpageAmountbysearch(String opraton, int pageSize) {
		String sql="select count(*) from VCollegeScore where collegeName=?";
		Object[] param = {opraton};
		return bdao.selectPages(sql,param, pageSize);
	}

}
