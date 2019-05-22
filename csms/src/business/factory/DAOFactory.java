package business.factory;


import business.dao.*;
import business.impl.*;

public class DAOFactory {
	/**
	 * �õ�һ�����ڰ༶ҵ�������ClassesDAO��ʵ�ֶ���
	 * @return ClassesDAO
	 */
	public static ClassesDAO getClassesDAO(){
		return new ClassesDaoImpl();
	}
	/**
	 * ����һ������ѧԺҵ�������CollegeDAO����
	 * @return CollegeDAO
	 */
	public static CollegeDAO getCollegeDAO(){
		return new CollegeDAOImpl();
	}
	/**
	 * ����һ������רҵҵ�������MajorDAO����
	 * @return MajorDAO
	 */
	public static MajorDAO getMajorDAO(){
		return new MajorDaoImpl();
	}
	/**
	 * ����һ�������û�ҵ�������UserDAO����
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO(){
		return new UserDaoImpl();
	}
	/**
	 * ����һ�����ڱ�����Ŀҵ�������ProjectDAO����
	 * @return ProjectDAO
	 */
	public static ProjectDAO getProjectDAO(){
		return new ProjectDaoImpl();
	}
	/**
	 * ����һ�����ڲ鿴ѧԺ����ҵ�������ScoreCollegeDAO����
	 * @return
	 */
	public static ScoreCollegeDAO getScoreCollegeDAO(){
		return new ScoreCollegeDaoImpl();
	}
	/**
	 * ����һ�����ڲ鿴�༶����ҵ�������ScoreCollegeDAO����
	 * @return
	 */
	public static ScoreClassesDAO getScoreClassesDAO(){
		return new ScoreClassesDaoImpl();
	}
	/**
	 * ����һ�����ڲ鿴ѧ������ҵ�������ScoreCollegeDAO����
	 * @return
	 */
	public static ScoreStudentDAO getScoreStudentDAO(){
		return new ScoreStudentDaoImpl();
	}
	/**
	 * ����һ�����ڲ鿴����ҵ�������MatchDAO����
	 * @return
	 */
	public static MatchDAO getMatchDAO(){
		return new MatchDaoImpl();
	}
	
	public static SceneDAO getSceneDAO(){
		return new SceneDaoImpl();
	}
	
	public static ArrangeDAO getArrangeDAO(){
		return new ArrangeDaoImpl();
	}
	/**
	 * ����һ���������±���ҵ�������ForumDAOImpl����
	 * @return
	 */
	public static ForumDAO getForumDAO(){
		return new ForumDAOImpl();
	}
	/**
	 * ����һ��������������ҵ�������ContentDAO����
	 * @return
	 */
	public static ContentDAO getContentDAO(){
		return new ContentDAOImpl();
	}
	/**
	 * ����һ�����ڹ���ҵ�������NewsDAO����
	 * @return
	 */
	public static NewsDAO getNewsDAO(){
		return new NewsDAOImpl();
	}
	/**
	 * ����һ������ͼƬ����ҵ�������PhotoDAO����
	 * @return
	 */
	public static PhotoDAO getPhotoDAO(){
		return new PhotoDAOImpl();
	}
	/**
	 * ����һ�����ڲ鿴��������ҵ�������ScoreDAO����
	 * @return
	 */
	public static ScoreDAO getScoreDAO(){
		return new ScoreDaoImpl();
	}
	/**
	 * ����һ�����������˶���ҵ�������SportsDAO����
	 * @return
	 */
	public static SportsDAO getSportsDAO(){
		return new SportsDAOImpl();
	}
}
