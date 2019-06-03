package business.dao;

import java.util.List;
import model.Project;
/**
 * 比赛项目业务接口类
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * 添加比赛项目
	 * @param project 项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(Project project);
	
	/**
	 * 修改比赛项目
	 * @param project 项目对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean update(Project project);
	
	/**
	 * 删除比赛项目
	 * @param projectid 项目id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int projectid);
	
	/**
	 * 获取所有项目对象列表
	 * @return 项目对象列表
	 */
	public List<Project> select();
	
	/**
	 * 通过项目类型获取项目对象列表
	 * @param type 项目类型
	 * @return 项目对象列表
	 */
	public List<Project> selectByType(int type);
}
