package business.factory;

import model.Match;
import model.Project;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.MatchDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.dao.ScoreClassesDAO;
import business.dao.ScoreCollegeDAO;
import business.dao.ScoreStudentDAO;
import business.dao.UserDAO;
import business.impl.ClassesDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.MatchDaoImpl;
import business.impl.ProjectDaoImpl;
import business.impl.SceneDaoImpl;
import business.impl.ScoreClassesDaoImpl;
import business.impl.ScoreCollegeDaoImpl;
import business.impl.ScoreStudentDaoImpl;
import business.impl.UserDaoImpl;

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
		return new CollegeDaoImpl();
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
	
	public static MatchDAO getMatchDAO(){
		return new MatchDaoImpl();
	}
	
	public static SceneDAO getSceneDAO(){
		return new SceneDaoImpl();
	}
}
