package business.dao;

import java.util.List;

import model.Match;

/**
 * ��������ҵ��ӿ���
 * @author Administrator
 *
 */
public interface MatchDAO {
	/**
	 * ��ӱ���������Ϣ
	 * @param match ��������
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(Match match);
	
	/**
	 * �ж��Ƿ񱨹��ı���
	 * @param userid �û�id
	 * @param proid ��Ŀid
	 * @return ���������trueΪ�ѱ�����falseΪδ����
	 */
	public boolean isSignUp(String userid,int proid);
	
	/**
	 * �����û�id��ѯ���������б�
	 * @param userid �û�id
	 * @return ���������б�
	 */
	public List<Match> selectByUser(String userid);
}
