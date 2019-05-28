package business.dao;

import java.util.List;

import model.VClassScore;


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
	public VClassScore getByClassid(int classid);
	/**
	 * ��ѯ���а༶�ɼ�
	 * @return List<VClass>���ݼ�
	 */
	public List<VClassScore> getAllScoreClasses();
	/**
	 * ��ҳ��ѯ�༶�ɼ�
	 * @return
	 */
	public List<VClassScore> getAllScoreByPage(int startPage,int pagesize);
	/**
	 * ��ȡ���а༶�ɼ�����
	 * @return
	 */
	public int allScoreCount();
	/**
	 * ��ȡĳ���༶���ܷ�
	 * @return
	 */
	public double allScore(int classid);
	/**
	 * ��ȡĳ���༶��ƽ����
	 * @return
	 */
	public double avgScore(int classid);
}
