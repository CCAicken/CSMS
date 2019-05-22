package business.dao;

import java.sql.ResultSet;
import java.util.List;

import model.VCollegeScore;

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
	public VCollegeScore getByCollegeid(int collegeid);
	/**
	 * ��ѯ����ѧԺ�ɼ�
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<VCollegeScore> getAllCollegeScore();
	
	/**
	
	 */
	/**
	 * ����ѧԺ���Ʋ�ѯѧԺ�ɼ�(��ҳ)
	 * @param cllegeName ѧԺ����
	 * @param pageSize ÿҳ��ʾ����
	 * @param currpage ��ǰҳ
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<VCollegeScore> getCollegeScoreBypage(String cllegeName,int pageSize,int currpage);
	/**
	 * ��ѯѧԺ�ɼ�
	 * @param collegeName ѧԺ����
	 * @return
	 */
	public List<VCollegeScore> getSearchCollege(String collegeName);
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
