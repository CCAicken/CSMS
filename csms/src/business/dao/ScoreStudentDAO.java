package business.dao;

import java.util.List;

import model.VStudentScore;

/**
 * ���˳ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param string ѧ���˺�
	 * @return ѧ���ɼ���Ϣ
	 */
	public VStudentScore getByUserid(String string);
	/**
	 * ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<VStudentScore> getAllScoreStudent();
	/**
	 * ��ҳ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 * @param startPage ��Ҫ��ҳ��������
	 * @param pageSize ÿҳ�ļ�¼��
	 * @return
	 */
	public List<VStudentScore> getAllScoreByPage(int startPage,int pageSize);
	/**
	 * ��ȡ����ѧ���ɼ�����
	 * @return
	 */
	public int allScoreCount();
	/**
	 * ��ȡĳ��ѧ�����ܷ�
	 * @return
	 */
	public double allScore(String userid);
	/**
	 * ��ȡĳ��ѧ����ƽ����
	 * @return
	 */
	public double avgScore(String userid);
}
