package business.dao;

import java.util.List;

import model.VScore;

/**
 * ���˳ɼ�ҵ��ӿ���
 * 
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param string
	 *            ѧ���˺�
	 * @return ѧ���ɼ���Ϣ
	 */
	public VScore getByUserid(String string);

	/**
	 * ��ҳ��ѯ����ѧ���ɼ�
	 * 
	 * @return List<ScoreStudent>���ݼ�
	 * @param strwhere
	 *            ��ѯ������Ϊ����дΪ""��
	 * @param startPage
	 *            ��Ҫ��ҳ��������
	 * @param pageSize
	 *            ÿҳ�ļ�¼��
	 * @return
	 */
	public List<VScore> getAllScoreByPage(String strwhere, int startPage,
			int pageSize);

	/**
	 * ��ȡĳ��ѧ�����ܷ�
	 * 
	 * @return
	 */
	public double allScore(String userid);

	/**
	 * ��ȡĳ��ѧ����ƽ����
	 * 
	 * @return
	 */
	public double avgScore(String userid);
}
