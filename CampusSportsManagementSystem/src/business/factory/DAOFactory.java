package business.factory;

import model.Project;
import business.dao.ClassesDAO;
import business.dao.CollegeDAO;
import business.dao.MajorDAO;
import business.dao.ProjectDAO;
import business.dao.UserDAO;
import business.impl.ClassesDaoImpl;
import business.impl.CollegeDaoImpl;
import business.impl.MajorDaoImpl;
import business.impl.ProjectDaoImpl;
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
}
