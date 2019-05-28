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
	/**
	 * 分页查询所有学生成绩
	 * @return List<ScoreStudent>数据集
	 * @param startPage 需要的页数的数据
	 * @param pageSize 每页的记录数
	 * @return
	 */
	public List<VStudentScore> getAllScoreByPage(int startPage,int pageSize);
	/**
	 * 获取所有学生成绩数量
	 * @return
	 */
	public int allScoreCount();
	/**
	 * 获取某个学生的总分
	 * @return
	 */
	public double allScore(String userid);
	/**
	 * 获取某个学生的平均分
	 * @return
	 */
	public double avgScore(String userid);
}
