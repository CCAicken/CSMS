package business.dao;

import model.TUser;

/**
 * �û�ҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface UserDAO {
	/**
	 * �û���¼
	 * 
	 * @param userid
	 * @param pwd
	 * @return
	 */
	public TUser login(String userid, String pwd);

	/**
	 * �����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(TUser user);

	/**
	 * �޸�����
	 * 
	 * @param pwd
	 * @return
	 */
	public boolean changePwd(String userid, String oldpwd, String pwd);

	/**
	 * ����û�
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(TUser user);

}
