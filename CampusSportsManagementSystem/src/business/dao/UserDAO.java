package business.dao;

import java.util.List;
import model.User;
/**
 * �û�ҵ��ӿ���
 * @author Administrator
 *
 */
public interface UserDAO {
	/**
	 * �û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public User login(String userid,String pwd);
	//public boolean insert(String userid,String username,String pwd,String agend,String mobile,Classes classes,College college,Role role);
	/**
	 * ���ѧ���û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertStu(User user);
	
	/**
	 * ��ӽ�ʦ�û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertTea(User user);
	
	/**
	 * �޸�����
	 * @param userid �û�id
	 * @param pwd ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updatePwd(String userid,String pwd);
	
	/**
	 * ɾ���û�����
	 * @param userid �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(String userid);
	
	/**
	 * ��ȡ�û�����
	 * @param userid �û�id
	 * @return �û�����
	 */
	public User getUser(String userid);
	
	/**
	 * ����ѧԺid��ȡ�û������б�
	 * @param collegeid ѧԺid
	 * @return �û������б�
	 */
	public List<User> selectByColl(String collegeid);
	
	/**
	 * ����רҵid��ȡ�û������б�
	 * @param majorid רҵid
	 * @return �û������б�
	 */
	public List<User> selectByMajor(String majorid);
	
	/**
	 * ���ݰ༶id��ȡ�û������б�
	 * @param classid �༶id
	 * @return �û������б�
	 */
	public List<User> selectByClass(String classid);
}
