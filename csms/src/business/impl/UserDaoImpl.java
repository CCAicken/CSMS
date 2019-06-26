package business.impl;

import model.TUser;
import basic.iHibBaseDAO;
import business.dao.UserDAO;

public class UserDaoImpl implements UserDAO {
	private iHibBaseDAO bdao;

	public void setBdao(iHibBaseDAO bdao) {
		this.bdao = bdao;
	}

	// public UserDaoImpl() {
	// bdao = new iHibBaseDAOImpl();
	// }

	@Override
	public TUser login(String userid, String pwd) {
		// TODO Auto-generated method stub
		TUser user = (TUser) bdao.findById(TUser.class, userid);
		if (pwd.equals(user.getPwd())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean updateUser(TUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertUser(TUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePwd(String userid, String oldpwd, String pwd) {
		// TODO Auto-generated method stub
		TUser user = (TUser) bdao.findById(TUser.class, userid);
		if (user.getPwd().equals(oldpwd)) {
			user.setPwd(pwd);
			return bdao.update(user);
		}
		return false;
	}

	// public static void main(String[] args) {
	// UserDAO udao = new UserDaoImpl();
	// TUser user = udao.login("1001", "123456");
	// System.out.print(user.getUsername());
	// }
}
