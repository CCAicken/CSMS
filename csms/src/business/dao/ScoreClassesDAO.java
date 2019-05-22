package business.dao;

import java.util.List;

import model.*;


/**
 * 班级成绩业务接口类
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 
	 * @param collegeid 学院id
	 * @return 学院成绩信息
	 */
	public VScore getByClassid(int classid);
	/**
	 * 查询所有学院成绩
	 * @return List<ScoreClasses>数据集
	 */
	public List<VCollegeScore> getAllScoreClasses();
	
	/**
	 * 查询所有学院成绩(分页)
	 * @return List<ScoreClasses>数据集
	 */
	public List<VCollegeScore> getAllCollegeScoreBypage(VCollegeScore scoreclasses);
}
