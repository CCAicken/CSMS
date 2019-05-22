package business.impl;

import java.util.List;

import model.TArrange;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.ArrangeDAO;

public class ArrangeDaoImpl implements ArrangeDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
//	public ArrangeDaoImpl(){
//		bdao = new iHibBaseDAOImpl();
//	}
	@Override
	public boolean insert(TArrange arrange) {
		int row = (Integer) bdao.insert(arrange);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int arrangeid) {
		TArrange arrange = (TArrange)bdao.findById(TArrange.class, arrangeid);
		return bdao.delete(arrange);
	}

	@Override
	public List<TArrange> select() {
		String hql = "from TArrange";
		List<TArrange> list = bdao.select(hql);
		return list;
	}
//	public static void main(String[] args){
//		ArrangeDAO dao = new ArrangeDaoImpl();
//		List<TArrange> list = dao.select();
//		for(TArrange a:list){
//			System.out.println(a.getArrname());
//		}
//	}

}
