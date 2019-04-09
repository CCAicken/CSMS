package business.dao;

import model.Arrange;

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
}
