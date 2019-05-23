package business.impl;

import java.util.List;

import model.TArrange;
import model.TForumTitle;
import basic.iHibBaseDAO;
import business.dao.ForumDAO;

public class ForumDAOImpl implements ForumDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	@Override
	public boolean addForum(TForumTitle forum) {
		int row = (Integer) bdao.insert(forum);
		if(row>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteForum(int forumid) {
		TForumTitle forum = (TForumTitle)bdao.findById(TForumTitle.class, forumid);
		return bdao.delete(forum);
	}

	@Override
	public boolean updateForum(TForumTitle Forum) {
		return bdao.update(Forum);
	}

	@Override
	public TForumTitle getTForumById(int forumid) {
		TForumTitle forum = (TForumTitle)bdao.findById(TForumTitle.class, forumid);
		return forum;
	}
	@Override
	public List<TForumTitle> getForumTitleByPages(int startPage, int pageSize) {
		String hql = "from TForumTitle";
		List<TForumTitle> list = (List<TForumTitle>)bdao.selectByPage(hql, startPage, pageSize);
		return list;
	}
	@Override
	public int getPageCount() {
		String hql = "select count(*) from TForumTitle";
		int count = bdao.selectValue(hql);
		return count;
	}

}
