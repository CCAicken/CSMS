package business.dao;

import java.util.List;

import model.Score;
import model.ScoreCollege;

/**
 * ѧԺ�ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreCollegeDAO {
	/**
	 * 
	 * @param collegeid ѧԺid
	 * @return ѧԺ�ɼ���Ϣ
	 */
	public ScoreCollege getByCollegeid(int collegeid);
	/**
	 * ��ѯ����ѧԺ�ɼ�
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<ScoreCollege> getAllCollegeScore();
	
	/**
	 * ��ѯ����ѧԺ�ɼ�(��ҳ)
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<ScoreCollege> getAllCollegeScoreBypage(ScoreCollege scorecollege);
}
