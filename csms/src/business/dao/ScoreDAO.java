package business.dao;

import java.util.List;

import model.TScore;
/**
 * �����ɼ�ҵ��ӿ���
 * @author Administrator
 *
 */
public interface ScoreDAO {
	/**
	 * ��ӳɼ���Ϣ
	 * @param score �ɼ�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TScore score);
	
	/**
	 * ���³ɼ�����
	 * @param score �ɼ�����
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TScore score);
	
	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * @param userid �û�id
	 * @return �û��ɼ��б�
	 */
	public List<TScore> getByUser(String userid);

	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * @param collegeid ѧԺid
	 * @return ѧԺ�ɼ��б�
	 */
	public List<TScore> getByCollege(int collegeid);
	
	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * @param classid �༶id
	 * @return �༶�ɼ��б�
	 */
	public List<TScore> getByClass(int classid);
}
