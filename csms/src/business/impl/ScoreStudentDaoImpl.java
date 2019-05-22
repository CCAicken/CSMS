package business.impl;

import java.util.List;

import model.VScore;
import model.VStudentScore;
import basic.iHibBaseDAO;
import business.dao.ScoreStudentDAO;

public class ScoreStudentDaoImpl implements ScoreStudentDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public VStudentScore getByUserid(int userid) {
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

}
