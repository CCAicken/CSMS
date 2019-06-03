package business.dao;

import java.sql.ResultSet;
import java.util.List;

import model.Score;
import model.ScoreCollege;

/**
 * 学院成绩业务接口类
 * @author jock
 *
 */
public interface ScoreCollegeDAO {
	/**
	 * 
	 * @param collegeid 学院id
	 * @return 学院成绩信息
	 */
	public ScoreCollege getByCollegeid(int collegeid);
	/**
	 * 查询所有学院成绩
	 * @return List<ScoreCollege>数据集
	 * string action 动作
	 */
	public List<ScoreCollege> getAllCollegeScore(String asction,String opretion);
	
	/**
	
	 */
	/**
	 * 根据学院名称查询学院成绩(分页)
	 
	 * @param opretion 条件
	 * @param pageSize 每页显示数量
	 * @param currpage 当前页
	 * @return List<ScoreCollege>数据集
	 */
	public List<ScoreCollege> getAllCollegeScoreBypage(String opretion,int pageSize,int currpage);
	/**
	 * 查询学院成绩
	 * @param opretion 条件
	 * @return
	 */
	public List<ScoreCollege> getSearchCollege(String opretion);
	/**
	 * 查询分页总页数
	 * @param pageSize 每页显示数量
	 */
	public int getpageAmount(int pageSize);
	/**
	 * 查询分页总页数（带条件）
	 * @param opraton 条件
	 * @param pageSize每页显示数量
	 * @return
	 */
	public int getpageAmountbysearch(String opraton,int pageSize); 
}
