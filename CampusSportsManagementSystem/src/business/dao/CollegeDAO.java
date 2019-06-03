package business.dao;

import java.util.List;

import model.College;

public interface CollegeDAO {
	/**
	 * ���ѧԺ
	 * @param college ѧԺ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(College college);
	
	/**
	 * ɾ��ѧԺ
	 * @param collegeid ѧԺid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int collegeid);
	
	/**
	 * ����ѧԺid��ȡѧԺ����
	 * @param collegeid ѧԺid
	 * @return ѧԺ����
	 */
	public College selectByid(int collegeid);
	
	/**
	 * ��ȡ����ѧԺ�����б�
	 * @return ѧԺ�����б�
	 */
	public List<College> select();
	
	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	public List<College> selectByPage();
}
