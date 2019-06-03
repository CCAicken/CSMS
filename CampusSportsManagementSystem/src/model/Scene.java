package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.properties.RoleType;

/**
 * 场次信息实体类
 * @author Administrator
 *
 */
public class Scene {
	private int sceneid;
	private int roleid;
	private Arrange arrange;
	private Match match;

	public Scene() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Scene(int sceneid, Arrange arrange, Match match,int roleid) {
		super();
		this.sceneid = sceneid;
		this.arrange = arrange;
		this.match = match;
		this.roleid = roleid;
	}

	public int getSceneid() {
		return sceneid;
	}

	public void setSceneid(int sceneid) {
		this.sceneid = sceneid;
	}

	public Arrange getArrange() {
		return arrange;
	}

	public void setArrange(Arrange arrange) {
		this.arrange = arrange;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Scene(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.sceneid = rs.getInt("matchid");
				Arrange arrange = new Arrange();
				arrange.setArrid(rs.getInt("arrid"));
				arrange.setArrname(rs.getString("arrname"));
				arrange.setAddr(rs.getString("addr"));
				arrange.setStarttime(rs.getString("starttime"));
				arrange.setEndtime(rs.getString("endtime"));
				arrange.setLeveltype(rs.getInt("leveltype"));
				arrange.setState(rs.getInt("state"));
				Project project = new Project();
				project.setProid(rs.getInt("proid"));
				project.setProname(rs.getString("proname"));
				project.setProtype(rs.getInt("protype"));
				project.setCollegelimit(rs.getInt("collegelimit"));
				project.setScenelimit(rs.getInt("scenelimit"));
				project.setTotallimit(rs.getInt("totallimit"));
				arrange.setProject(project);
				this.arrange = arrange;
				Match match = new Match();
				match.setMatchid((rs.getInt("matchid")));
				Project project2 = new Project();
				project2.setProid(rs.getInt("proid"));
				project2.setProname(rs.getString("proname"));
				project2.setProtype(rs.getInt("protype"));
				project2.setCollegelimit(rs.getInt("collegelimit"));
				project2.setScenelimit(rs.getInt("scenelimit"));
				project2.setTotallimit(rs.getInt("totallimit"));
				match.setProject(project2);
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
				this.roleid = rs.getInt("roleid");
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
		List<Scene> list = new ArrayList<Scene>();
		if(rs != null){
			try{
				while(rs.next()){
					Scene scene = new Scene();
					scene.setSceneid(rs.getInt("sceneid"));
					Arrange arrange = new Arrange();
					arrange.setArrid(rs.getInt("arrid"));
					arrange.setArrname(rs.getString("arrname"));
					arrange.setAddr(rs.getString("addr"));
					arrange.setStarttime(rs.getString("starttime"));
					arrange.setEndtime(rs.getString("endtime"));
					arrange.setLeveltype(rs.getInt("leveltype"));
					arrange.setState(rs.getInt("state"));
					Project project = new Project();
					project.setProid(rs.getInt("proid"));
					project.setProname(rs.getString("proname"));
					project.setProtype(rs.getInt("protype"));
					project.setCollegelimit(rs.getInt("collegelimit"));
					project.setScenelimit(rs.getInt("scenelimit"));
					project.setTotallimit(rs.getInt("totallimit"));
					arrange.setProject(project);
					scene.setArrange(arrange);
					Match match = new Match();
					match.setMatchid(rs.getInt("matchid"));
					Project project2 = new Project();
					project2.setProid(rs.getInt("proid"));
					project2.setProname(rs.getString("proname"));
					project2.setProtype(rs.getInt("protype"));
					project2.setCollegelimit(rs.getInt("collegelimit"));
					project2.setScenelimit(rs.getInt("scenelimit"));
					project2.setTotallimit(rs.getInt("totallimit"));
					match.setProject(project2);
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
					scene.setMatch(match);
					scene.setRoleid(rs.getInt("roleid"));
					list.add(scene);
				};
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
