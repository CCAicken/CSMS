package business.dao;

import java.util.List;

import model.*;

/**
 * 比赛报名业务接口类
 * @author Administrator
 *
 */
public interface MatchDAO {
	/**
	 * 添加比赛报名信息
	 * @param match 报名对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TMatch match);
	
	/**
	 * 判断是否报过改比赛
	 * @param userid 用户id
	 * @param proid 项目id
	 * @return 操作结果，true为已报过，false为未报过
	 */
	public boolean isSignUp(String userid,int proid);
	
	/**
	 * 根据用户id查询报名对象列表
	 * @param userid 用户id
	 * @return 报名对象列表
	 */
	public List<TMatch> selectByUser(String userid);
}
