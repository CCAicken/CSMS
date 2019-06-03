package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 班级实体类
 * @author Administrator
 *
 */
public class Classes {
	
	private int classid;
	private String classname;
	private Major major;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(int classid, String classname, Major major) {
		super();
		this.classid = classid;
		this.classname = classname;
		this.major = major;
	}
	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Classes(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.classid = rs.getInt("classid");
				this.classname = rs.getString("classname");
				Major major = new Major();
				major.setMajorid(rs.getInt("majorid"));
				major.setMajorname(rs.getString("majorname"));
				College college = new College();
				college.setCollegeid(rs.getInt("collegeid"));
				college.setCollegename(rs.getString("collegename"));
				major.setCollege(college);
				this.major = major;
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
		List<Classes> list = new ArrayList<Classes>();
		if(rs != null){
			try{
				do{
					Classes classes = new Classes();
					classes.setClassid((rs.getInt("classid")));
					classes.setClassname((rs.getString("classname")));
					Major major = new Major();
					major.setMajorid(rs.getInt("majorid"));
					major.setMajorname(rs.getString("majorname"));
					College college = new College();
					college.setCollegeid(rs.getInt("collegeid"));
					college.setCollegename(rs.getString("collegename"));
					major.setCollege(college);
					classes.setMajor(major);
					list.add(classes);
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
