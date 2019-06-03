package business.dao;

import java.util.List;

import model.Project;
import model.Scene;

/**
 * 比赛场次信息接口类
 * @author Administrator
 *
 */
public interface SceneDAO {
	/**
	 * 添加场次比赛人员信息
	 * @param scene 场次信息对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(Scene scene);
	/**
	 * 獲取所有場次信息
	 * @return
	 */
	public List<Scene> seleScenes();
	/**
	 * 根據賬號獲取對應的場次信息
	 * @param userid 用戶id
	 * @return
	 */
	public List<Scene> seleScenes(String userid);
	
	/**
	 * 根據賬號獲取未安排的報名項目
	 * @param userid 用戶id
	 * @return
	 */
	public List<Project> seleOtherScenes(String userid);
}
