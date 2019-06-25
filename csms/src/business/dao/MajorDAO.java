package business.dao;

import java.util.List;

import model.*;

public interface MajorDAO {
	/**
	 * 添加专业
	 * @param major 专业对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TMajor major);
	
	/**
	 * 删除专业
	 * @param majorid 专业id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int majorid);
	
	/**
	 * 根据专业id获取专业对象
	 * @param majorid 专业id
	 * @return 专业对象
	 */
	public TMajor selectByid(int majorid);
	
	/**
	 * 获取所有专业对象列表
	 * @return 专业对象列表
	 */
	public List<TMajor> select();
	
	/**
	 * 获取所有专业对象列表
	 * @param collegeid 学院id
	 * @return 专业对象列表
	 */
	public List<TMajor> selectByColl(int collegeid);
	
	/**
	 * 获取总记录数
	 * @return 总记录数
	 */
	public int getPageCount();
	
	/**
	 * 分页查询专业成绩
	 * @param strwhere 查询条件（为空是填写为""）
	 * @param startPage 获取的页面数据
	 * @param pagesize 每页的记录数
	 * @return
	 */
	public List<VMajorScore> getAllScoreByPage(String strwhere,int startPage,int pagesize);
	/**
	 * 获取所有专业成绩数量
	 * @param strwhere 查询条件（为空是填写为""）
	 * @return
	 */
	public int allScoreCount(String strwhere);
}
