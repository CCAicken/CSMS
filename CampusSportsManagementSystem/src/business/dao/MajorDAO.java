package business.dao;

import java.util.List;

import model.Major;

public interface MajorDAO {
	/**
	 * ���רҵ
	 * @param major רҵ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(Major major);
	
	/**
	 * ɾ��רҵ
	 * @param majorid רҵid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int majorid);
	
	/**
	 * ����רҵid��ȡרҵ����
	 * @param majorid רҵid
	 * @return רҵ����
	 */
	public Major selectByid(int majorid);
	
	/**
	 * ��ȡ����רҵ�����б�
	 * @return רҵ�����б�
	 */
	public List<Major> select();
	
	/**
	 * ��ȡ����רҵ�����б�
	 * @param collegeid ѧԺid
	 * @return רҵ�����б�
	 */
	public List<Major> selectByColl(int collegeid);
}
