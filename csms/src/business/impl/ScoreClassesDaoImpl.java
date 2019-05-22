package business.impl;

import java.util.List;

import model.VClass;
import basic.iHibBaseDAO;
import business.dao.ScoreClassesDAO;

public class ScoreClassesDaoImpl implements ScoreClassesDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public VClass getByClassid(int classid) {
		String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where classid=? GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		Object[] param={classid};
		List<VClass> list=bdao.select(sql, param);
		if(list!=null && list.size()>0){
			for(VClass score :list){
				VClass newScore = score;
				return newScore;
			}
			return null;
		}else{
			return null;
		}
	}

	@Override
	public List<VClass> getAllScoreClasses() {
		String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		List<VClass> list=bdao.select(sql);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

}
