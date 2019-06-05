package business.dao;

import java.util.List;

import model.TArrange;
import model.VArrange;

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
	public boolean insert(TArrange arrange);
	
	/**
	 * ɾ�����ΰ���
	 * @param arrangeid ����id
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int arrangeid);

	/**
	 * ��ȡ���г��ΰ���
	 * @param arrid ���ΰ���id
	 * @return ���ΰ��Ŷ���
	 */
	public VArrange selectById(int arrid);
	
	/**
	 * ��ȡ���г��ΰ����б�
	 * @param strWhere ��ѯ������Ϊ������дΪ""��
	 * @return ���ΰ����б�
	 */
	public List<VArrange> select(String strWhere);

	/**
	 * ��ȡ���г��ΰ����б�������
	 * @param strWhere ��ѯ������Ϊ������дΪ""��
	 * @return �б�������
	 */
	public int getCount(String strWhere);
}
