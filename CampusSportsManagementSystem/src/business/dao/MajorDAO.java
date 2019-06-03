package business.dao;

import java.util.List;

import model.Major;

public interface MajorDAO {
	/**
	 * 添加专业
	 * @param major 专业对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(Major major);
	
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
	public Major selectByid(int majorid);
	
	/**
	 * 获取所有专业对象列表
	 * @return 专业对象列表
	 */
	public List<Major> select();
	
	/**
	 * 获取所有专业对象列表
	 * @param collegeid 学院id
	 * @return 专业对象列表
	 */
	public List<Major> selectByColl(int collegeid);
}
