package business.dao;

import java.util.List;

import model.ScoreClasses;
import model.ScoreStudent;

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
	public ScoreStudent getByClassid(int userid);
	/**
	 * ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<ScoreStudent> getAllScoreStudent();
	
	/**
	 * ��ѯ����ѧԺ�ɼ�(��ҳ)
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<ScoreStudent> getAllCollegeScoreBypage(ScoreStudent scorestudent);
}
