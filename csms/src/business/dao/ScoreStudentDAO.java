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
}
