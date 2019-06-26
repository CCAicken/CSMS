package business.dao;

import java.util.List;

import model.TProject;
import model.VSportProject;

/**
 * ������Ŀҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface ProjectDAO {
	/**
	 * ��ӱ�����Ŀ
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TProject project);

	/**
	 * �޸ı�����Ŀ
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TProject project);

	/**
	 * ɾ��������Ŀ
	 * 
	 * @param projectid
	 *            ��Ŀid
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean delete(int projectid);

	/**
	 * ������Ŀid��ȡ��Ŀ
	 * 
	 * @param projectid
	 * @return
	 */
	public TProject getptoject(int projectid);

	/**
	 * ��ȡ������Ŀ�����б�
	 * 
	 * @return ��Ŀ�����б�
	 */
	public List<VSportProject> select();

	/**
	 * ��ȡ������Ŀ�����б�
	 * 
	 * @param strwhere��ѯ����
	 * @param startPage
	 * @param pagesize
	 * @return ��Ŀ�����б�
	 */
	public List<VSportProject> selectList(String strwhere, int startPage,
			int pageSize);

	/**
	 * ͨ����Ŀ���ͻ�ȡ��Ŀ�����б�
	 * 
	 * @param type
	 *            ��Ŀ����
	 * @return ��Ŀ�����б�
	 */
	public List<VSportProject> selectByType(int type);

	/**
	 * ���ݽ�ɫ���ͷ�ҳ��ȡ������Ŀ
	 * 
	 * @param startPage
	 * @param pagesize
	 * @return
	 */
	public List<VSportProject> selectByPage(String strwhere, int roletype,
			int startPage, int pageSize);

	/**
	 * ��ȡ������Ŀ��
	 * 
	 * @param roletype
	 *            ��ɫ����
	 * @return ���ر�����Ŀ��
	 */
	public int getProCountByRole(String strwhere, int roletype);

	/**
	 * ��ȡ������Ŀ��
	 * 
	 * @param roletype
	 *            ��ɫ����
	 * @return ���ر�����Ŀ��
	 */
	public int getProCount(String strwhere);

}
