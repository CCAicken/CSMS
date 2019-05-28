package business.dao;

import java.util.List;

import model.VClassScore;


/**
 * 班级成绩业务接口类
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 
	 * @param classid 班级id
	 * @return 班级成绩信息
	 */
	public VClassScore getByClassid(int classid);
	/**
	 * 查询所有班级成绩
	 * @return List<VClass>数据集
	 */
	public List<VClassScore> getAllScoreClasses();
	/**
	 * 分页查询班级成绩
	 * @return
	 */
	public List<VClassScore> getAllScoreByPage(int startPage,int pagesize);
	/**
	 * 获取所有班级成绩数量
	 * @return
	 */
	public int allScoreCount();
	/**
	 * 获取某个班级的总分
	 * @return
	 */
	public double allScore(int classid);
	/**
	 * 获取某个班级的平均分
	 * @return
	 */
	public double avgScore(int classid);
}
