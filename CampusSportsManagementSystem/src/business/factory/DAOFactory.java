package business.factory;

import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.basic.DBConnection;
import business.dao.ArrangeDAO;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.MatchDAO;
import business.dao.ProjectDAO;
import business.dao.SceneDAO;
import business.dao.ScoreClassesDAO;
import business.dao.ScoreCollegeDAO;
import business.dao.ScoreDAO;
import business.dao.ScoreStudentDAO;
import business.dao.UserDAO;
import business.impl.ArrangeDaoImpl;
import business.impl.ClassesDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.MatchDaoImpl;
import business.impl.ProjectDaoImpl;
import business.impl.SceneDaoImpl;
import business.impl.ScoreClassesDaoImpl;
import business.impl.ScoreCollegeDaoImpl;
import business.impl.ScoreDaoImpl;
import business.impl.ScoreStudentDaoImpl;
import business.impl.UserDaoImpl;

public class DAOFactory {
	/**
	 * 得到一个用于班级业务操作的ClassesDAO类实现对象
	 * @return ClassesDAO
	 */
	public static ClassesDAO getClassesDAO(){
		return new ClassesDaoImpl();
	}
	/**
	 * 返回一个用于学院业务操作的CollegeDAO对象
	 * @return CollegeDAO
	 */
	public static CollegeDAO getCollegeDAO(){
		return new CollegeDaoImpl();
	}
	/**
	 * 返回一个用于专业业务操作的MajorDAO对象
	 * @return MajorDAO
	 */
	public static MajorDAO getMajorDAO(){
		return new MajorDaoImpl();
	}
	/**
	 * 返回一个用于用户业务操作的UserDAO对象
	 * @return UserDAO
	 */
	public static UserDAO getUserDAO(){
		return new UserDaoImpl();
	}
	
	public static BaseDao getBaseDao(){
		return new BaseDaoImpl();
	}
	
	/**
	 * 返回一个用于比赛项目业务操作的ProjectDAO对象
	 * @return ProjectDAO
	 */
	public static ProjectDAO getProjectDAO(){
		return new ProjectDaoImpl();
	}
	/**
	 * 返回一个用于查看学院分数业务操作的ScoreCollegeDAO对象
	 * @return
	 */
	public static ScoreCollegeDAO getScoreCollegeDAO(){
		return new ScoreCollegeDaoImpl();
	}
	/**
	 * 返回一个用于查看班级分数业务操作的ScoreCollegeDAO对象
	 * @return
	 */
	public static ScoreClassesDAO getScoreClassesDAO(){
		return new ScoreClassesDaoImpl();
	}
	/**
	 * 返回一个用于查看学生分数业务操作的ScoreCollegeDAO对象
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
	
	public static ArrangeDAO getArrangeDAO(){
		return new ArrangeDaoImpl();
	}
	
	public static ScoreDAO getScoreDAO(){
		return new ScoreDaoImpl();
	}
}
