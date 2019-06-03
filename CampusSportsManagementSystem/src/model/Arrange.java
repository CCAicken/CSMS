package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 场次安排实体类
 * @author Administrator
 *
 */
public class Arrange {
	private int arrid;
	private String arrname;
	private Project project;
	private String starttime;
	private String endtime;
	private String addr;
	private int leveltype;
	private int state;
	
	public Arrange() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arrange(int arrid, String arrname, Project project, String starttime,
			String endtime, String addr, int leveltype, int state) {
		super();
		this.arrid = arrid;
		this.arrname = arrname;
		this.project = project;
		this.starttime = starttime;
		this.endtime = endtime;
		this.addr = addr;
		this.leveltype = leveltype;
		this.state = state;
	}

	public int getArrid() {
		return arrid;
	}

	public void setArrid(int arrid) {
		this.arrid = arrid;
	}

	public String getArrname() {
		return arrname;
	}

	public void setArrname(String arrname) {
		this.arrname = arrname;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getLeveltype() {
		return leveltype;
	}

	public void setLeveltype(int leveltype) {
		this.leveltype = leveltype;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Arrange(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.arrid = rs.getInt("arrid");
				this.arrname = rs.getString("arrname");
				this.addr = rs.getString("addr");
				this.starttime = rs.getString("starttime");
				this.endtime = rs.getString("endtime");
				this.leveltype = rs.getInt("leveltype");
				this.state = rs.getInt("state");
				Project project = new Project();
				project.setProid(rs.getInt("proid"));
				project.setProname(rs.getString("proname"));
				project.setProtype(rs.getInt("protype"));
				project.setCollegelimit(rs.getInt("collegelimit"));
				project.setScenelimit(rs.getInt("scenelimit"));
				project.setTotallimit(rs.getInt("totallimit"));
				this.project = project;
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
		List<Arrange> list = new ArrayList<Arrange>();
		if(rs != null){
			try{
				do{
					Arrange arrange = new Arrange();
					arrange.setArrid((rs.getInt("arrid")));
					arrange.setArrname((rs.getString("arrname")));
					Project project = new Project();
					project.setProid(rs.getInt("proid"));
					project.setProname(rs.getString("proname"));
					project.setProtype(rs.getInt("protype"));
					project.setCollegelimit(rs.getInt("collegelimit"));
					project.setScenelimit(rs.getInt("scenelimit"));
					project.setTotallimit(rs.getInt("totallimit"));
					arrange.setProject(project);
					arrange.setAddr((rs.getString("addr")));
					arrange.setLeveltype((rs.getInt("leveltype")));
					arrange.setState((rs.getInt("state")));
					arrange.setStarttime((rs.getString("starttime")));
					arrange.setEndtime((rs.getString("endtime")));
					list.add(arrange);
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
