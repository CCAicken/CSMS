package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.TConfig;
import model.VClassScore;
import model.VScore;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.ScoreClassesDAO;

public class ScoreClassesDaoImpl implements ScoreClassesDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig)session.getAttribute("config");
//	public ScoreClassesDaoImpl() {
//		// TODO Auto-generated constructor stub
//		bdao = new iHibBaseDAOImpl();
//	}
	@Override
	public VClassScore getByClassid(int classid) {
		//String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore where classid=? GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		String hql = "from VClassScore where classid=? and sportid=?";
		Object[] param={classid,config.getSportid()};
		List<VClassScore> list=bdao.select(hql, param);
		if(list!=null && list.size()>0){
			for(VClassScore score :list){
				VClassScore newScore = score;
				return newScore;
			}
			return null;
		}else{
			return null;
		}
	}

	@Override
	public List<VClassScore> getAllScoreClasses() {
		//String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		String hql = "from VClassScore where sportid="+config.getSportid();
		List<VClassScore> list=bdao.select(hql);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public List<VClassScore> getAllScoreByPage(String strwhere,int startPage,int pageSize) {
		//String sql="select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname";
		String hql = "from VClassScore where sportid="+config.getSportid()+strwhere;
		List<VClassScore> list=bdao.selectByPage(hql, startPage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public int allScoreCount(String strwhere) {
		String hql = "select count(classid) from VClassScore where sportid="+config.getSportid()+strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}
	@Override
	public double allScore(int classid) {
		String hql = "select round(sum(scorenumber),2) as scorenumber from VScore where classid=? and sportid=?";
		Object[] param = {classid,config.getSportid()};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			if(list.get(0)!=null){
				return (Double)list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	@Override
	public double avgScore(int classid) {
		String hql = "select round(avg(scorenumber),2) as scorenumber from VScore where classid=? and sportid=?";
		Object[] param = {classid,config.getSportid()};
		List list = bdao.select(hql, param);
		if(list!=null && list.size()>0){
			if(list.get(0)!=null){
				return (Double)list.get(0);
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
}
