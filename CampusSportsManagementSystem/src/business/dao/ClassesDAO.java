package business.dao;

import java.util.List;

import model.Classes;

public interface ClassesDAO {
	/**
	 * ��Ӱ༶
	 * @param classes �༶����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(Classes classes);
	
	/**
	 * ɾ���༶
	 * @param classid �༶id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int classid);
	
	/**
	 * ���ݰ༶id��ȡ�༶����
	 * @param classid �༶id
	 * @return �༶����
	 */
	public Classes selectByid(int classid);
	
	/**
	 * ��ȡ���а༶�����б�
	 * @return �༶�����б�
	 */
	public List<Classes> select();
}
