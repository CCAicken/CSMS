package business.dao;

import java.util.List;
import model.Score;
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
	public boolean insert(Score score);
	
	/**
	 * ���³ɼ�����
	 * @param score �ɼ�����
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(Score score);
	
	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * @param userid �û�id
	 * @return �û��ɼ��б�
	 */
	public List<Score> getByUser(String userid);
}
