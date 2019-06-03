package business.dao;

import java.util.List;

import model.ScoreClasses;
import model.ScoreStudent;

/**
 * 个人成绩业务接口类
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param collegeid 学院id
	 * @return 学院成绩信息
	 */
	public ScoreStudent getByClassid(int userid);
	/**
	 * 查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 */
	public List<ScoreStudent> getAllScoreStudent();
	
	/**
	 * 查询所有学院成绩(分页)
	 * @return List<ScoreStudent>数据集
	 */
	public List<ScoreStudent> getAllCollegeScoreBypage(ScoreStudent scorestudent);
}
