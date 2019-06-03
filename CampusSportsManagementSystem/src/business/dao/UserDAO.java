package business.dao;

import java.util.List;

import model.Student;
import model.Teacher;
/**
 * 用户业务接口类
 * @author Administrator
 *
 */
public interface UserDAO {
	//学生方法
	/**
	 * 学生用户登录
	 * @param userid 用户id
	 * @param pwd 用户密码
	 * @return user用户对象
	 */
	public Student loginStu(String userid,String pwd);
	
	//public boolean insert(String userid,String username,String pwd,String agend,String mobile,Classes classes,College college,Role role);
	/**
	 * 添加学生用户对象
	 * @param user 用户对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insertStu(Student user);
	
	/**
	 * 修改学生密码
	 * @param userid 用户id
	 * @param pwd 新密码
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean updateStuPwd(String userid,String pwd);
	
	/**
	 * 删除用户对象
	 * @param userid 用户id
	 * @return 删除结果，true为成功，false为失败
	 */
	public boolean deleteStu(String userid);
	
	/**
	 * 获取用户对象
	 * @param userid 用户id
	 * @return 用户对象
	 */
	public Student getStudent(String userid);
	
	/**
	 * 根据学院id获取用户对象列表
	 * @param collegeid 学院id
	 * @return 用户对象列表
	 */
	public List<Student> selectStuByColl(String collegeid);
	
	/**
	 * 根据专业id获取用户对象列表
	 * @param majorid 专业id
	 * @return 用户对象列表
	 */
	public List<Student> selectStuByMajor(String majorid);
	
	/**
	 * 根据班级id获取用户对象列表
	 * @param classid 班级id
	 * @return 用户对象列表
	 */
	public List<Student> selectStuByClass(String classid);

	//教师方法
	
	/**
	 * 教师用户登录
	 * @param userid 用户id
	 * @param pwd 用户密码
	 * @return user用户对象
	 */
	public Teacher loginTea(String userid,String pwd);
	
	/**
	 * 添加教师用户对象
	 * @param user 用户对象
	 * @return 添加结果，true为成功，false为失败
	 */
	public boolean insertTea(Teacher user);
	
	/**
	 * 修改学生密码
	 * @param userid 用户id
	 * @param pwd 新密码
	 * @return 更新结果，true为成功，false为失败
	 */
	public boolean updateTeaPwd(String userid,String pwd);
	
	/**
	 * 删除用户对象
	 * @param userid 用户id
	 * @return 删除结果，true为成功，false为失败
	 */
	public boolean deleteTea(String userid);
	
	/**
	 * 获取用户对象
	 * @param userid 用户id
	 * @return 用户对象
	 */
	public Teacher getTeacher(String userid);
	
	/**
	 * 根据学院id获取教师对象列表
	 * @param collegeid 学院id
	 * @return 教师对象列表
	 */
	public List<Teacher> selectTeaByColl(String collegeid);
}
