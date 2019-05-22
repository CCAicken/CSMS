package business.impl;

import model.TForumTitle;
import business.dao.ForumDAO;

public class ForumDAOImpl implements ForumDAO {

	@Override
	public int addForum(TForumTitle forum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteForum(int forumid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateForum(TForumTitle Forum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TForumTitle getTForumById(int forumid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getForumAmountByUser(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
