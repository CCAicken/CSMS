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
	 * @param userid 学生账号
	 * @return 学生成绩信息
	 */
	public VStudentScore getByUserid(int userid);
	/**
	 * 查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 */
	public List<VStudentScore> getAllScoreStudent();
}
