package business.dao;

import java.util.List;

import model.Scene;

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
	public boolean insert(Scene scene);
}
