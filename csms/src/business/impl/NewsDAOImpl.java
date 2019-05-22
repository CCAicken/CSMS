package business.impl;

import java.util.List;

import model.TNews;
import basic.iHibBaseDAO;
import basic.iHibBaseDAOImpl;
import business.dao.NewsDAO;

public class NewsDAOImpl implements NewsDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	
	@Override
	public boolean addNews(TNews news) {
		String res= (String) bdao.insert(news);
		if(res!=null){

			return true;
		}
		return false;
	}

	@Override
	public TNews getNewsById(int newid) {
		TNews news=	(TNews) bdao.findById(TNews.class, newid);
		return news;
	}

	@Override
	public List<TNews> getAllNews() {
		String hql ="from TNews";
		return bdao.select(hql);
	}

	@Override
	public List<TNews> getNewsByTeaid(String teaid) {
		String hql="from TNews where teacerid=?";
		Object[] para={teaid};
		return bdao.select(hql, para);
	}

}
