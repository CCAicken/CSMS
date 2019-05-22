package business.dao;

import java.util.List;

import model.*;


/**
 * �༶�ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 
	 * @param collegeid ѧԺid
	 * @return ѧԺ�ɼ���Ϣ
	 */
	public VScore getByClassid(int classid);
	/**
	 * ��ѯ����ѧԺ�ɼ�
	 * @return List<ScoreClasses>���ݼ�
	 */
	public List<VCollegeScore> getAllScoreClasses();
	
	/**
	 * ��ѯ����ѧԺ�ɼ�(��ҳ)
	 * @return List<ScoreClasses>���ݼ�
	 */
	public List<VCollegeScore> getAllCollegeScoreBypage(VCollegeScore scoreclasses);
}
