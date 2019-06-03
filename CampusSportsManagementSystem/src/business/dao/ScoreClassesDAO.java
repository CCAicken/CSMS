package business.dao;

import java.util.List;

import model.ScoreClasses;
import model.ScoreCollege;

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
	public ScoreClasses getByClassid(int classid);
	/**
	 * 查询所有学院成绩
	 * @return List<ScoreClasses>数据集
	 */
	public List<ScoreClasses> getAllScoreClasses();
	
	/**
	 * 查询所有学院成绩(分页)
	 * @return List<ScoreClasses>数据集
	 */
	public List<ScoreClasses> getAllCollegeScoreBypage(ScoreClasses scoreclasses);
}
