package business.impl;

import model.TPhoto;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.PhotoDAO;

public class PhotoDAOImpl implements PhotoDAO {

	private iHibBaseDAO bdao;
//	public void setBdao(iHibBaseDAO bdao) {
//		this.bdao = bdao;
//	}
	public PhotoDAOImpl(){
		bdao= new iHibBaseDAOImpl();
	} 
	@Override
	public TPhoto getPhotoById(int id) {
		return (TPhoto) bdao.findById(TPhoto.class, id);
	}

	@Override
	public boolean addPhoto(TPhoto obj) {
	 String res=	(String) bdao.insert(obj);
	 if(res!=null){
		 return true;
	 } return false;
	}

	@Override
	public boolean deletePhoto(int id) {
	TPhoto photo=	(TPhoto) bdao.findById(TPhoto.class, id);
	return	bdao.delete(photo);
	}

}
