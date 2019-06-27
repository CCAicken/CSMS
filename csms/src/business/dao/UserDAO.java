package business.dao;

import model.TUser;

/**
 * 用户业务接口类
 * 
 * @author Administrator
 *
 */
public interface UserDAO {
	/**
	 * 用户登录
	 * 
	 * @param userid
	 * @param pwd
	 * @return
	 */
	public TUser login(String userid, String pwd);

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUser(TUser user);

	/**
	 * 修改密码
	 * 
	 * @param pwd
	 * @return
	 */
	public boolean changePwd(String userid, String oldpwd, String pwd);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(TUser user);

}
