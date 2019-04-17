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
	
	 */
	/**
	 * ����ѧԺ���Ʋ�ѯѧԺ�ɼ�(��ҳ)
	 
	 * @param opretion ����
	 * @param pageSize ÿҳ��ʾ����
	 * @param currpage ��ǰҳ
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<ScoreCollege> getAllCollegeScoreBypage(String opretion,int pageSize,int currpage);
	/**
	 * ��ѯѧԺ�ɼ�
	 * @param opretion ����
	 * @return
	 */
	public List<ScoreCollege> getSearchCollege(String opretion);
	/**
	 * ��ѯ��ҳ��ҳ��
	 * @param pageSize ÿҳ��ʾ����
	 */
	public int getpageAmount(int pageSize);
	/**
	 * ��ѯ��ҳ��ҳ������������
	 * @param opraton ����
	 * @param pageSizeÿҳ��ʾ����
	 * @return
	 */
	public int getpageAmountbysearch(String opraton,int pageSize); 
}
