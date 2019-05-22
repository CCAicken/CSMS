package business.dao;

import java.util.List;

import model.*;

/**
 * ���˳ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param userid ѧ���˺�
	 * @return ѧ���ɼ���Ϣ
	 */
	public VStudentScore getByUserid(int userid);
	/**
	 * ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<VStudentScore> getAllScoreStudent();
}
