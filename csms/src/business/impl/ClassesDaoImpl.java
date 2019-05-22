package business.impl;

import java.util.List;

import com.opensymphony.xwork2.Result;

import model.TClass;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.ClassesDAO;

public class ClassesDaoImpl implements ClassesDAO {
	
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	
//	public ClassesDaoImpl() {
//		bdao = new iHibBaseDAOImpl();
//	}

	@Override
	public boolean insert(TClass classes) {
		int row = (Integer) bdao.insert(classes);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int classid) {
		TClass cla = (TClass)bdao.findById(TClass.class, classid);
		return bdao.delete(cla);
	}

	@Override
	public TClass selectByid(int classid) {
		TClass cla = (TClass)bdao.findById(TClass.class, classid);
		return cla;
	}

	@Override
	public List<TClass> select() {
		String hql = "from TClass";
		List<TClass> list = (List<TClass>)bdao.select(hql);
		return list;
	}

	@Override
	public List<TClass> selectByMajor(int majorid) {
		String hql = "from TClass where majorid=?";
		Object[] para = {majorid};
		List<TClass> list = (List<TClass>)bdao.select(hql, para);
		return list;
	}
//	public static void main(String[] args){
//		ClassesDAO dao = new ClassesDaoImpl();
//		List<TClass> list = dao.selectByMajor(1);
//		for(TClass cl:list){
//			System.out.println(cl.getClassname());
//		}
//	}
}
