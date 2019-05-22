package business.factory;


import business.dao.*;
import business.impl.*;

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
		return new CollegeDAOImpl();
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
	/**
	 * 返回一个用于查看比赛业务操作的MatchDAO对象
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
	 * 返回一个用于文章标题业务操作的ForumDAOImpl对象
	 * @return
	 */
	public static ForumDAO getForumDAO(){
		return new ForumDAOImpl();
	}
	/**
	 * 返回一个用于文章内容业务操作的ContentDAO对象
	 * @return
	 */
	public static ContentDAO getContentDAO(){
		return new ContentDAOImpl();
	}
	/**
	 * 返回一个用于公告业务操作的NewsDAO对象
	 * @return
	 */
	public static NewsDAO getNewsDAO(){
		return new NewsDAOImpl();
	}
	/**
	 * 返回一个用于图片操作业务操作的PhotoDAO对象
	 * @return
	 */
	public static PhotoDAO getPhotoDAO(){
		return new PhotoDAOImpl();
	}
	/**
	 * 返回一个用于查看比赛分数业务操作的ScoreDAO对象
	 * @return
	 */
	public static ScoreDAO getScoreDAO(){
		return new ScoreDaoImpl();
	}
	/**
	 * 返回一个用于设置运动会业务操作的SportsDAO对象
	 * @return
	 */
	public static SportsDAO getSportsDAO(){
		return new SportsDAOImpl();
	}
}
