package business.dao;

import java.util.HashMap;
import java.util.List;

import model.MedalRank;
import model.TCollege;
import model.TScore;
import model.VScore;
import model.VUserScore;
/**
 * 比赛成绩业务接口类
 * @author Administrator
 *
 */
public interface ScoreDAO {
	/**
	 * 添加成绩信息
	 * @param score 成绩对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insert(TScore score);
	
	/**
	 * 更新成绩对象
	 * @param score 成绩对象
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean update(TScore score);
	
	/**
	 * 查询用户的详细成绩列表
	 * @param userid 用户id
	 * @return 用户成绩列表
	 */
	public List<VScore> getByUser(String userid);

	/**
	 * 查询用户的详细成绩列表
	 * @param collegeid 学院id
	 * @return 学院成绩列表
	 */
	public List<VScore> getByCollege(int collegeid);
	
	/**
	 * 查询用户的详细成绩列表
	 * @param classid 班级id
	 * @return 班级成绩列表
	 */
	public List<VScore> getByClass(int classid);
	/**
	 * 查询各个学院的成绩排名
	 * @return 成绩列表
	 */
	public List<VScore> getCollegeScoreOrder();
	/**
	 * 查询成绩列表
	 * @param strwhere 查询条件（为空时填写为""）
	 * @param startPage 获取的页面数据
	 * @param limit 每页的记录数
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByPage(String strwhere,int startPage,int limit);
	/**
	 * 查询指定项目的个人赛成绩列表
	 * @param proid 项目id
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByProSingle(int proid);
	/**
	 * 查询指定项目的团体赛成绩列表
	 * @param proid 项目id
	 * @return 成绩列表
	 */
	public List<VScore> getScoreByProTeam(int proid);
	/**
	 * 查询成绩列表
	 * @param strwhere 查询条件（为空时填写为""）
	 * @param startPage 获取的页面数据
	 * @param limit 每页的记录数
	 * @return 成绩列表
	 */
	public List<VScore> getScore(String strwhere);
	/**
	 * 查询成绩总记录数
	 * @param strwhere 查询条件（为空时填写为""）
	 * @return 成绩列表
	 */
	public int allScoreCount(String strwhere);
	
	/**
	 * 分页查询所有学生成绩
	 * 
	 * @return List<ScoreStudent>数据集
	 * @param strwhere
	 *            查询条件（为空填写为""）
	 * @param startPage
	 *            需要的页数的数据
	 * @param pageSize
	 *            每页的记录数
	 * @return
	 */
	public List<VUserScore> getAllScoreByPage(String strwhere, int startPage,
			int pageSize);
	
	/**
	 * 查询成绩总记录数
	 * @param strwhere 查询条件（为空时填写为""）
	 * @return 成绩列表
	 */
	public int allUserScoreCount(String strwhere);
	
	/**
	 * 获取某个用户的总分
	 * @return
	 */
	public double allScore(String userid);

	/**
	 * 获取某个用户的平均分
	 * @return
	 */
	public double avgScore(String userid);
	/**
	 * 查询奖牌排行列表
	 * @return 成绩列表
	 */
	public List<HashMap<String, Integer>> getMedalRank(int rank);

	/**
	 * 获取最新一届各学院一、二、三排名数量
	 * @return
	 */
	public List<MedalRank> getRank();
	/**
	 * 获取各届各学院一、二、三排名数量
	 * @return
	 */
	public List<VScore> getAllCollScore();
}
