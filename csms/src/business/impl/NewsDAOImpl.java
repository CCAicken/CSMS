package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.TConfig;
import model.TNews;
import model.VNews;
import basic.iHibBaseDAO;
import business.dao.NewsDAO;

public class NewsDAOImpl implements NewsDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig)session.getAttribute("config");
	@Override
	public boolean addNews(TNews news) {
		String res = (String) bdao.insert(news);
		if (res != null) {
			return true;
		}
		return false;
	}

	@Override
	public VNews getNewsById(int newid) {
		VNews news = (VNews) bdao.findById(VNews.class, newid);
		return news;
	}

	@Override
	public List<TNews> getAllNews() {
		String hql = "from TNews where sportid="+config.getSportid();
		return bdao.select(hql);
	}

	@Override
	public List<TNews> getNewsByTeaid(String teaid) {
		String hql = "from TNews where teacerid=? and sportid=?";
		Object[] para = { teaid,config.getSportid() };
		return bdao.select(hql, para);
	}

}
