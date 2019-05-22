package business.dao;

import java.util.List;

import model.*;

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
	public VStudentScore getByClassid(int userid);
	/**
	 * 查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 */
	public List<VStudentScore> getAllScoreStudent();
	
	/**
	 * 查询所有学院成绩(分页)
	 * @return List<ScoreStudent>数据集
	 */
	public List<VStudentScore> getAllCollegeScoreBypage(VStudentScore scorestudent);
}
