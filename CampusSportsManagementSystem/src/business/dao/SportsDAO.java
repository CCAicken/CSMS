package business.dao;

import java.util.List;
import model.Config;
/**
 * �˶�������ҵ��ӿ���
 * @author Administrator
 *
 */
public interface SportsDAO {
	/**
	 * ����˶���ʱ������
	 * @param config ���ö���
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(Config config);
	
	/**
	 * �����˶���ʱ������
	 * @param config ���ö���
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(Config config);
	
	/**
	 * ��ȡ�������ö����б�
	 * @return ���ö����б�
	 */
	public List<Config> select();
}
