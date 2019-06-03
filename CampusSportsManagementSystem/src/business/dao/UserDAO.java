package business.dao;

import java.util.List;

import model.Student;
import model.Teacher;
/**
 * �û�ҵ��ӿ���
 * @author Administrator
 *
 */
public interface UserDAO {
	//ѧ������
	/**
	 * ѧ���û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public Student loginStu(String userid,String pwd);
	
	//public boolean insert(String userid,String username,String pwd,String agend,String mobile,Classes classes,College college,Role role);
	/**
	 * ���ѧ���û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertStu(Student user);
	
	/**
	 * �޸�ѧ������
	 * @param userid �û�id
	 * @param pwd ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updateStuPwd(String userid,String pwd);
	
	/**
	 * ɾ���û�����
	 * @param userid �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean deleteStu(String userid);
	
	/**
	 * ��ȡ�û�����
	 * @param userid �û�id
	 * @return �û�����
	 */
	public Student getStudent(String userid);
	
	/**
	 * ����ѧԺid��ȡ�û������б�
	 * @param collegeid ѧԺid
	 * @return �û������б�
	 */
	public List<Student> selectStuByColl(String collegeid);
	
	/**
	 * ����רҵid��ȡ�û������б�
	 * @param majorid רҵid
	 * @return �û������б�
	 */
	public List<Student> selectStuByMajor(String majorid);
	
	/**
	 * ���ݰ༶id��ȡ�û������б�
	 * @param classid �༶id
	 * @return �û������б�
	 */
	public List<Student> selectStuByClass(String classid);

	//��ʦ����
	
	/**
	 * ��ʦ�û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public Teacher loginTea(String userid,String pwd);
	
	/**
	 * ��ӽ�ʦ�û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertTea(Teacher user);
	
	/**
	 * �޸�ѧ������
	 * @param userid �û�id
	 * @param pwd ������
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean updateTeaPwd(String userid,String pwd);
	
	/**
	 * ɾ���û�����
	 * @param userid �û�id
	 * @return ɾ�������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean deleteTea(String userid);
	
	/**
	 * ��ȡ�û�����
	 * @param userid �û�id
	 * @return �û�����
	 */
	public Teacher getTeacher(String userid);
	
	/**
	 * ����ѧԺid��ȡ��ʦ�����б�
	 * @param collegeid ѧԺid
	 * @return ��ʦ�����б�
	 */
	public List<Teacher> selectTeaByColl(String collegeid);
}
