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
	 * @param collegeid ѧԺid
	 * @return ѧԺ�ɼ���Ϣ
	 */
	public VStudentScore getByClassid(int userid);
	/**
	 * ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<VStudentScore> getAllScoreStudent();
	
	/**
	 * ��ѯ����ѧԺ�ɼ�(��ҳ)
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<VStudentScore> getAllCollegeScoreBypage(VStudentScore scorestudent);
}
