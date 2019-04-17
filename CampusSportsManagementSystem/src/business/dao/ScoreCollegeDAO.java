package business.dao;

import java.sql.ResultSet;
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
	 * string action ����
	 */
	public List<ScoreCollege> getAllCollegeScore(String asction,String opretion);
	
	/**
	 * ����ѧԺ���Ʋ�ѯѧԺ�ɼ�(��ҳ)
	 * @collegename ѧԺ����
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<ScoreCollege> getAllCollegeScoreBypage(String collegename);
	/**
	 * ��ѯѧԺ�ɼ�
	 * @param opretion ����
	 * @return
	 */
	public List<ScoreCollege> getSearchCollege(String opretion);
	
}
