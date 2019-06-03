package business.dao;

import java.util.List;
import model.Config;
/**
 * 运动会配置业务接口类
 * @author Administrator
 *
 */
public interface SportsDAO {
	/**
	 * 添加运动会时间配置
	 * @param config 配置对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insert(Config config);
	
	/**
	 * 更新运动会时间配置
	 * @param config 配置对象
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean update(Config config);
	
	/**
	 * 获取所有配置对象列表
	 * @return 配置对象列表
	 */
	public List<Config> select();
}
