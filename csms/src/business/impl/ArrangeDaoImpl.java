package business.impl;

import java.util.List;

import model.TArrange;
import model.VArrange;
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
	public List<VArrange> select(String strWhere) {
		String hql = "from VArrange"+strWhere;
		List<VArrange> list = bdao.select(hql);
		return list;
	}
//	public static void main(String[] args){
//		ArrangeDAO dao = new ArrangeDaoImpl();
//		List<TArrange> list = dao.select();
//		for(TArrange a:list){
//			System.out.println(a.getArrname());
//		}
//	}
	@Override
	public int getCount(String strWhere) {
		String hql = "select count(*) from VArrange"+strWhere;
		int count = bdao.selectValue(hql);
		return count;
	}
	@Override
	public VArrange selectById(int arrid) {
		VArrange arrange = (VArrange)bdao.findById(VArrange.class, arrid);
		return arrange;
	}

}
