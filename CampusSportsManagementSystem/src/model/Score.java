package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.properties.ProjectType;
import common.properties.RoleType;

/**
 * 成绩实体类
 * @author Administrator
 *
 */
public class Score {

	private int scoreid;
	private Match match;
	private double scorenumber;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Score(int scoreid, Match match, double scorenumber) {
		super();
		this.scoreid = scoreid;
		this.match = match;
		this.scorenumber = scorenumber;
	}

	public int getScoreid() {
		return scoreid;
	}

	public void setScoreid(int scoreid) {
		this.scoreid = scoreid;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public double getScorenumber() {
		return scorenumber;
	}

	public void setScorenumber(double scorenumber) {
		this.scorenumber = scorenumber;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Score(ResultSet rs){
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.scoreid = rs.getInt("scoreid");
				this.scorenumber = rs.getDouble("scorenumber");
				Match match = new Match();
				match.setMatchid(rs.getInt("matchid"));
				Project project = new Project();
				project.setProid(rs.getInt("proid"));
				project.setProname(rs.getString("proname"));
				project.setProtype(rs.getInt("protype"));
				project.setCollegelimit(rs.getInt("collegelimit"));
				project.setScenelimit(rs.getInt("scenelimit"));
				project.setTotallimit(rs.getInt("totallimit"));
				match.setProject(project);
				if(rs.getInt("roleid")==RoleType.Student){
					Student student = new Student();
					student.setUserid(rs.getString("userid"));
					student.setUsername(rs.getString("username"));
					student.setPwd(rs.getString("pwd"));
					student.setAgend(rs.getString("agend"));
					student.setMobile(rs.getString("mobile"));
					Classes classes = new Classes();
					classes.setClassid(rs.getInt("classid"));
					classes.setClassname(rs.getString("classname"));
					Major major = new Major();
					major.setMajorid(rs.getInt("majorid"));
					major.setMajorname(rs.getString("majorname"));
					College college = new College();
					college.setCollegeid(rs.getInt("collegeid"));
					college.setCollegename(rs.getString("collegename"));
					major.setCollege(college);
					classes.setMajor(major);
					student.setClasses(classes);
					Role role = new Role();
					role.setRoleid(rs.getInt("roleid"));
					role.setRolename(rs.getString("rolename"));
					student.setRole(role);
					match.setStudent(student);
				}else{
					Teacher teacher = new Teacher();
					teacher.setUserid(rs.getString("userid"));
					teacher.setUsername(rs.getString("teausername"));
					teacher.setPwd(rs.getString("teapwd"));
					teacher.setAgend(rs.getString("teaagend"));
					teacher.setMobile(rs.getString("teamobile"));
					College college = new College();
					college.setCollegeid(rs.getInt("teacollegeid"));
					college.setCollegename(rs.getString("teacollegename"));
					teacher.setCollege(college);
					Role role = new Role();
					role.setRoleid(rs.getInt("tearoleid"));
					role.setRolename(rs.getString("tearolename"));
					teacher.setRole(role);
					match.setTeacher(teacher);
				}
				this.match = match;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ResultSet结果集转List
	 * @param rs ResultSet结果集
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//静态方法，用于将0~N的VUser视图数据交换到List数组中来
		List<Score> list = new ArrayList<Score>();
		if(rs != null){
			try{
				do{
					Score score = new Score();
					score.setScoreid(rs.getInt("scoreid"));
					score.setScorenumber(rs.getDouble("scorenumber"));
					Match match = new Match();
					match.setMatchid((rs.getInt("matchid")));
					Project project = new Project();
					project.setProid(rs.getInt("proid"));
					project.setProname(rs.getString("proname"));
					project.setProtype(rs.getInt("protype"));
					project.setCollegelimit(rs.getInt("collegelimit"));
					project.setScenelimit(rs.getInt("scenelimit"));
					project.setTotallimit(rs.getInt("totallimit"));
					match.setProject(project);
					match.setRoleid(rs.getInt("roleid"));
					if(rs.getInt("roleid")==RoleType.Student){
						Student student = new Student();
						student.setUserid(rs.getString("userid"));
						student.setUsername(rs.getString("username"));
						student.setPwd(rs.getString("pwd"));
						student.setAgend(rs.getString("agend"));
						student.setMobile(rs.getString("mobile"));
						Classes classes = new Classes();
						classes.setClassid(rs.getInt("classid"));
						classes.setClassname(rs.getString("classname"));
						Major major = new Major();
						major.setMajorid(rs.getInt("majorid"));
						major.setMajorname(rs.getString("majorname"));
						College college = new College();
						college.setCollegeid(rs.getInt("collegeid"));
						college.setCollegename(rs.getString("collegename"));
						major.setCollege(college);
						classes.setMajor(major);
						student.setClasses(classes);
						Role role = new Role();
						role.setRoleid(rs.getInt("roleid"));
						role.setRolename(rs.getString("rolename"));
						student.setRole(role);
						match.setStudent(student);
					}else{
						Teacher teacher = new Teacher();
						teacher.setUserid(rs.getString("userid"));
						teacher.setUsername(rs.getString("username"));
						teacher.setPwd(rs.getString("pwd"));
						teacher.setAgend(rs.getString("agend"));
						teacher.setMobile(rs.getString("mobile"));
						College college = new College();
						college.setCollegeid(rs.getInt("collegeid"));
						college.setCollegename(rs.getString("collegename"));
						teacher.setCollege(college);
						Role role = new Role();
						role.setRoleid(rs.getInt("roleid"));
						role.setRolename(rs.getString("rolename"));
						teacher.setRole(role);
						match.setTeacher(teacher);
					}
					score.setMatch(match);;
					list.add(score);
				}while(rs.next());
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
