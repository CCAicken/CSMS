package business.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.TArrange;
import model.TConfig;
import model.TForumTitle;
import basic.iHibBaseDAO;
import business.dao.ForumDAO;

public class ForumDAOImpl implements ForumDAO {
	private iHibBaseDAO bdao;
	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}
	HttpSession session = ServletActionContext.getRequest().getSession();
	TConfig config = (TConfig)session.getAttribute("config");
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
		String hql = "from TForumTitle where sportid="+config.getSportid();
		List<TForumTitle> list = (List<TForumTitle>)bdao.selectByPage(hql, startPage, pageSize);
		if(list!=null && list.size()>0){
			return list;
		}else{
			return null;
		}
	}
	@Override
	public int getPageCount() {
		String hql = "select count(*) from TForumTitle where sportid="+config.getSportid();
		int count = bdao.selectValue(hql);
		return count;
	}

}
