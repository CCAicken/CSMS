package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TMajor;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.iHibBaseDAO;
import business.dao.*;
import business.impl.MajorDaoImpl;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ServletContext application;
	protected ArrangeDAO arrangedao;
	protected ClassesDAO classesdao;
	protected CollegeDAO collegedao;
	protected ContentDAO contentdao;
	protected ForumDAO forumdao;
	protected MajorDAO majordao;
	protected MatchDAO matchdao;
	protected NewsDAO newsdao;
	protected PhotoDAO photodao;
	protected ProjectDAO projectdao;
	protected SceneDAO scenedao;
	protected ScoreClassesDAO scoreclassesdao;
	protected ScoreCollegeDAO scorecollegedao;
	protected ScoreDAO scoredao;
	protected ScoreStudentDAO scorestudentdao;
	protected SportsDAO sportsdao;
	protected UserDAO userdao;
	protected iHibBaseDAO bdao;
	protected Writer out;

	public BaseAction() {
		super();

		try {
			request = ServletActionContext.getRequest();
			response = ServletActionContext.getResponse();
			session = request.getSession();

			out = response.getWriter();

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");

			application = ServletActionContext.getServletContext();
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"factoryBean.xml");
			arrangedao = ctx.getBean("getArrangeDAO", ArrangeDAO.class);
			classesdao = ctx.getBean("getClassesDAO", ClassesDAO.class);
			collegedao = ctx.getBean("getCollegeDAO", CollegeDAO.class);
			contentdao = ctx.getBean("getContentDAO", ContentDAO.class);
			forumdao = ctx.getBean("getForumDAO", ForumDAO.class);
			majordao = ctx.getBean("getMajorDAO", MajorDAO.class);
			matchdao = ctx.getBean("getMatchDAO", MatchDAO.class);
			newsdao = ctx.getBean("getNewsDAO", NewsDAO.class);
			photodao = ctx.getBean("getPhotoDAO", PhotoDAO.class);
			projectdao = ctx.getBean("getProjectDAO", ProjectDAO.class);
			scenedao = ctx.getBean("getSceneDAO", SceneDAO.class);
			scoreclassesdao = ctx.getBean("getScoreClassesDAO",
					ScoreClassesDAO.class);
			scorecollegedao = ctx.getBean("getScoreCollegeDAO",
					ScoreCollegeDAO.class);
			scoredao = ctx.getBean("getScoreDAO", ScoreDAO.class);
			scorestudentdao = ctx.getBean("getScoreStudentDAO",
					ScoreStudentDAO.class);
			sportsdao = ctx.getBean("getSportsDAO", SportsDAO.class);
			userdao = ctx.getBean("getUserDAO", UserDAO.class);
			bdao = ctx.getBean("bdao", iHibBaseDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
