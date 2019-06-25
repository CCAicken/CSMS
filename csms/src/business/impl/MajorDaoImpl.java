package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.TConfig;
import model.TMajor;
import model.VClassScore;
import model.VMajorScore;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.MajorDAO;

public class MajorDaoImpl implements MajorDAO {

	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	//获取当前运动会
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig)session.getAttribute("config");
	@Override
	public boolean insert(TMajor major) {
		int row = (Integer) bdao.insert(major);
		if(row>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean delete(int majorid) {
		TMajor major=(TMajor) bdao.findById(TMajor.class, majorid);
		return  bdao.delete(major);
	}

	@Override
	public TMajor selectByid(int majorid) {
		return (TMajor) bdao.findById(TMajor.class, majorid);
	}

	@Override
	public List<TMajor> select() {
		String hql="from TMajor";
		List<TMajor> list=	(List<TMajor>)bdao.select(hql);
		return list;
	}

	@Override
	public List<TMajor> selectByColl(int collegeid) {
		String hql="from TMajor where collegeid=?";
		Object[] para={collegeid};
		List<TMajor> list=	(List<TMajor>)bdao.select(hql,para);
		return list;
	}

	@Override
	public int getPageCount() {
		String hql = "select count(*) from TMajor";
		int count = bdao.selectValue(hql);
		return count;
	}

	@Override
	public List<VMajorScore> getAllScoreByPage(String strwhere,int startPage,int pageSize) {
		String hql = "from VMajorScore where sportid="+config.getSportid()+strwhere;
		List<VMajorScore> list=bdao.selectByPage(hql, startPage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public int allScoreCount(String strwhere) {
		String hql = "select count(*) from VMajorScore where sportid="+config.getSportid()+strwhere;
		int count = bdao.selectValue(hql);
		return count;
	}

}
