package business.dao;

import java.util.List;

import model.*;

/**
 * ����������Ϣ�ӿ���
 * @author Administrator
 *
 */
public interface SceneDAO {
	/**
	 * ��ӳ��α�����Ա��Ϣ
	 * @param scene ������Ϣ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TScene scene);
	/**
	 * �@ȡ���Ј�����Ϣ
	 * @return
	 */
	public List<TScene> seleScenes();
	/**
	 * �����~̖�@ȡ�����Ĉ�����Ϣ
	 * @param userid �Ñ�id
	 * @return
	 */
	public List<TScene> seleScenes(String userid);
	
	/**
	 * �����~̖�@ȡδ���ŵĈ����Ŀ
	 * @param userid �Ñ�id
	 * @return
	 */
	public List<TScene> seleOtherScenes(String userid);
}
