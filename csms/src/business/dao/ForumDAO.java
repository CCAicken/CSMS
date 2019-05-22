package business.dao;

import java.util.List;

import model.TForumTitle;

public interface ForumDAO {
	/**
	 * ���һƪ�������µĻ�����Ϣ
	 * @param TForum����
	 * @return ��ӳɹ������±�ţ���<=0���ʾ���ʧ��
	 */
	public int addForum(TForumTitle forum);
	
	/**
	 * �������Լ�����������ݴ����������ȫɾ��������ɾ�����۱����ݱ����±��Լ��޸����ݶ�ӦͼƬ��ͼƬ״̬���û��������·�������-1
	 * @param forumid ���±��
	 * @return ��Ӱ�������
	 */
	public boolean deleteForum(int forumid);
	
	/**
	 * �޸�һ������������Ϣ
	 * @param Forum ������Ϣ����
	 * @return ��Ӱ�������
	 */
	public boolean updateForum(TForumTitle Forum);
	/**
	 * ͨ�����±�ŷ���һ�����¶���
	 * @param forumid ���±��
	 * @return VForumTitle������ͼ����
	 */
//	public VForumTitle getVForumById(int forumid);
	
	/**
	 * ͨ�����±�ŷ���һ�����¶���
	 * @param forumid ���±��
	 * @return TForumTitle���¶���
	 */
	public TForumTitle getTForumById(int forumid);
	
	/**
	 * ���ָ�������û���������¶����б�
	 * @param userid �û����
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ�������
	 * @return ������Ϣ�����б�
	 */
//	public List<VForumTitle> getForumListByPage(String userid,int currentPage, int pageSize);
	/**
	 * �������ݿ���ĳ�û��������������
	 * @param userid �û����
	 * @return ��������
	 */
	public int getForumAmountByUser(String userid);
	
	/**
	 * ���ز����û��������£�����pageSize��ʾ��ҳ��
	 * @param userid �û���ţ�ÿҳ��ʾ����
	 * @param pageSize ÿҳ��ʾ����
	 * @return ��ҳ����
	 */
//	public int getPageAmount(String userid, int pageSize);
	
	/**
	 * ��ð�ģ����ѯʵ�ֵ����в����û���������¶����б�
	 * @param likecondtion ģ����ѯ����
	 * @param currentPage ��ǰҳ
	 * @param pageSize ÿҳ�������
	 * @return ������Ϣ�����б�
	 */
//	public List<VForumTitle> getForumListByLike(String likecondtion,int currentPage, int pageSize);
	
	/**
	 * ��û������±����ģ����ѯʵ�ֵ�ָ�������û���������¶����б�
	 * @param ģ����ѯ���ݣ���ǰҳ��ÿҳ�������
	 * @return ������Ϣ�����б�
	 */
//	public List<VForumTitle> getBlogerUserForumListByTopicLike(String likecondtion,String userid,int currentPage, int pageSize);
	
	/**
	 * �����û�����������µ������б� ����û���Ϊnull���򷵻������û������µ������б�
	 * @param userid �û���
	 * @return ������Ϣ�����б�
	 */
//	public List<VForumTitle> getForumsByUser(String userid);
}
