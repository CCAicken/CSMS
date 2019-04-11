package business.dao;

import java.util.List;

import model.ScoreClasses;
import model.ScoreCollege;

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
	public ScoreClasses getByClassid(int classid);
	/**
	 * ��ѯ����ѧԺ�ɼ�
	 * @return List<ScoreClasses>���ݼ�
	 */
	public List<ScoreClasses> getAllScoreClasses();
	
	/**
	 * ��ѯ����ѧԺ�ɼ�(��ҳ)
	 * @return List<ScoreClasses>���ݼ�
	 */
	public List<ScoreClasses> getAllCollegeScoreBypage(ScoreClasses scoreclasses);
}
