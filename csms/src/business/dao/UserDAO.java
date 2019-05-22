package business.dao;

import java.util.List;

import model.TStudent;
import model.TTeacher;
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
	public TStudent loginStu(String userid,String pwd);
	
	//public boolean insert(String userid,String username,String pwd,String agend,String mobile,Classes classes,College college,Role role);
	/**
	 * ���ѧ���û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertStu(TStudent user);
	
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
	public TStudent getStudent(String userid);
	
	/**
	 * ����ѧԺid��ȡ�û������б�
	 * @param collegeid ѧԺid
	 * @return �û������б�
	 */
	public List<TStudent> selectStuByColl(String collegeid);
	
	/**
	 * ����רҵid��ȡ�û������б�
	 * @param majorid רҵid
	 * @return �û������б�
	 */
	public List<TStudent> selectStuByMajor(String majorid);
	
	/**
	 * ���ݰ༶id��ȡ�û������б�
	 * @param classid �༶id
	 * @return �û������б�
	 */
	public List<TStudent> selectStuByClass(String classid);

	//��ʦ����
	
	/**
	 * ��ʦ�û���¼
	 * @param userid �û�id
	 * @param pwd �û�����
	 * @return user�û�����
	 */
	public TTeacher loginTea(String userid,String pwd);
	
	/**
	 * ��ӽ�ʦ�û�����
	 * @param user �û�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insertTea(TTeacher user);
	
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
	public TTeacher getTeacher(String userid);
	
	/**
	 * ����ѧԺid��ȡ��ʦ�����б�
	 * @param collegeid ѧԺid
	 * @return ��ʦ�����б�
	 */
	public List<TTeacher> selectTeaByColl(String collegeid);
}
