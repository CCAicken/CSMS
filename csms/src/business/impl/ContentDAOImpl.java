package business.impl;

import java.util.List;

import model.TForumContent;
import basic.iHibBaseDAO;
import business.dao.ContentDAO;

public class ContentDAOImpl implements ContentDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public boolean addContent(TForumContent fcontent) {
		int row = (Integer) bdao.insert(fcontent);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContent(int id) {
		TForumContent content = (TForumContent)bdao.findById(TForumContent.class, id);
		return bdao.delete(content);
	}

	@Override
	public boolean updateForumContent(TForumContent fcontent) {
		return bdao.update(fcontent);
	}

	@Override
	public TForumContent getTContnentById(int id) {
		TForumContent content = (TForumContent)bdao.findById(TForumContent.class, id);
		return content;
	}
	@Override
	public List<TForumContent> getContentByForumid(int forumid) {
		String hql = "from TForumContent where forumid=?";
		Object[] para = {forumid};
		List<TForumContent> list = (List<TForumContent>)bdao.select(hql, para);
		return list;
	}

}
