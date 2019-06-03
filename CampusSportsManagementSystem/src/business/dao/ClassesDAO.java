package business.dao;

import java.util.List;

import model.Classes;

public interface ClassesDAO {
	/**
	 * 添加班级
	 * @param classes 班级对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(Classes classes);
	
	/**
	 * 删除班级
	 * @param classid 班级id
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean delete(int classid);
	
	/**
	 * 根据班级id获取班级对象
	 * @param classid 班级id
	 * @return 班级对象
	 */
	public Classes selectByid(int classid);
	
	/**
	 * 获取所有班级对象列表
	 * @return 班级对象列表
	 */
	public List<Classes> select();

	/**
	 * 获取所有班级对象列表
	 * @param majorid 专业id
	 * @return 班级对象列表
	 */
	public List<Classes> selectByMajor(int majorid);
}
