package business.dao;

import java.util.List;
import model.*;
/**
 * ������Ŀҵ��ӿ���
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * ��ӱ�����Ŀ
	 * @param project ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TProject project);
	
	/**
	 * �޸ı�����Ŀ
	 * @param project ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TProject project);
	
	/**
	 * ɾ��������Ŀ
	 * @param projectid ��Ŀid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int projectid);
	
	/**
	 * ��ȡ������Ŀ�����б�
	 * @return ��Ŀ�����б�
	 */
	public List<TProject> select();
	
	/**
	 * ͨ����Ŀ���ͻ�ȡ��Ŀ�����б�
	 * @param type ��Ŀ����
	 * @return ��Ŀ�����б�
	 */
	public List<TProject> selectByType(int type);
}
