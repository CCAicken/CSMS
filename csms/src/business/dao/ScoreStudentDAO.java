package business.dao;

import java.util.List;

import model.VStudentScore;

/**
 * 个人成绩业务接口类
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param string 学生账号
	 * @return 学生成绩信息
	 */
	public VStudentScore getByUserid(String string);
	/**
	 * 查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 */
	public List<VStudentScore> getAllScoreStudent();
}
