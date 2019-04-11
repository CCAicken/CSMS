package business.dao;

import java.util.List;
import model.Project;
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
	public boolean insert(Project project);
	
	/**
	 * �޸ı�����Ŀ
	 * @param project ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(Project project);
	
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
	public List<Project> select();
	
	/**
	 * ͨ����Ŀ���ͻ�ȡ��Ŀ�����б�
	 * @param type ��Ŀ����
	 * @return ��Ŀ�����б�
	 */
	public List<Project> selectByType(int type);
	/**
	 * ��ȡ��ǰ��Ŀ��������
	 * @param proid ��Ŀid
	 * @return ���ص�ǰ��������
	 */
	public Integer currentNum(int proid);
}
