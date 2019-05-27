package business.dao;

import java.util.List;

import model.VClass;


/**
 * �༶�ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * 
	 * @param classid �༶id
	 * @return �༶�ɼ���Ϣ
	 */
	public VClass getByClassid(int classid);
	/**
	 * ��ѯ���а༶�ɼ�
	 * @return List<VClass>���ݼ�
	 */
	public List<VClass> getAllScoreClasses();
	/**
	 * ��ҳ��ѯ�༶�ɼ�
	 * @return
	 */
	public List<VClass> getClassesByPage(int startPage,int pagesize);
}
