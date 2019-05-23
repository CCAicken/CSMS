package business.impl;

import java.util.List;

import model.TMatch;
import model.VMatch;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.MatchDAO;

public class MatchDaoImpl implements MatchDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	
	@Override
	public boolean insert(TMatch match) {
		String proName = "up_AddMatch(?,?)";
		Object[] para = {match.getProid(),match.getUserid()};
		int result= (Integer) bdao.executeProduce("up_AddMatch(?,?)", para);
		if (result>0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isSignUp(String userid, int proid) {
		String hql="from TMatch where userid=? peoid=?";
		Object[] para={userid,proid};
		TMatch match=	 (TMatch) bdao.select(hql, para);
		if(match==null){
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public List<VMatch> selectByUser(String userid) {
		String hql="from VMatch where userid=?";
		Object[] para={userid};
		return bdao.select(hql, para);
	}
	public static void main(String[] args){
		MatchDaoImpl impl=new MatchDaoImpl();
	List<VMatch> list=	impl.selectByUser("94005");
		for(VMatch match:list){
			System.out.println(match.getProname()+match.getTeausername());
		}
	}

	@Override
	public List<VMatch> select() {
		String hql="from VMatch";
		return bdao.select(hql);
	}
	
	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMatch";
		int count = bdao.selectValue(hql);
		return count;
	}
}
