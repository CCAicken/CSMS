package business.dao;

import java.util.List;

import model.Arrange;
import model.College;

/**
 * �������ΰ��Žӿ���
 * @author Administrator
 *
 */
public interface ArrangeDAO {
	/**
	 * ��ӳ��ΰ���
	 * @param arrange ���ΰ��Ŷ���
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(Arrange arrange);
	
	/**
	 * ɾ�����ΰ���
	 * @param arrangeid ����id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int arrangeid);
	
	/**
	 * ��ȡ���г��ΰ����б�
	 * @return ���ΰ����б�
	 */
	public List<Arrange> select();
}
