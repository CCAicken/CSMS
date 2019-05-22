package business.dao;

import model.TForumContent;

public interface ContentDAO {
	/**
	 * ��Ӳ������µ�һ��������Ϣ
	 * @param TForumContent����
	 * @return ��ӳɹ������±�ţ���<=0���ʾ���ʧ��
	 */
	public int addContent(TForumContent fcontent);
	
	/**
	 * ɾ��һ����������������Ϣ
	 * @param ���ݱ��
	 * @return ��Ӱ�������
	 */
	public boolean deleteContent(int id);
	/**
	 * �޸�һ����������������Ϣ
	 * @param �������ݶ���
	 * @return ��Ӱ�������
	 */
	public boolean updateForumContent(TForumContent fcontent);

	/**
	 * ͨ�����ݱ�ż���һ���������ݼ�¼
	 * @param ���ݱ��
	 * @return VForumContent����
	 */
	//public VForumContent getContnentById(int id);
	
	/**
	 * ͨ�����ݱ�ż���һ���������ݼ�¼
	 * @param ���ݱ��
	 * @return TForumContent����
	 */
	public TForumContent getTContnentById(int id);
}
