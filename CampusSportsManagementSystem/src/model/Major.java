package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 专业实体类
 * @author Administrator
 *
 */
public class Major {

	private int majorid;
	private String majorname;
	private College college;
	
	public Major() {
		super();
	}

	public Major(int majorid, String majorname, College college) {
		super();
		this.majorid = majorid;
		this.majorname = majorname;
		this.college = college;
	}

	public int getMajorid() {
		return majorid;
	}

	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Major(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.majorid = rs.getInt("majorid");
				this.majorname = rs.getString("majorname");
				College college = new College();
				college.setCollegeid(rs.getInt("collegeid"));
				college.setCollegename(rs.getString("collegename"));
				this.college = college;
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
		List<Major> list = new ArrayList<Major>();
		if(rs != null){
			try{
				do{
					Major major = new Major();
					major.setMajorid((rs.getInt("majorid")));
					major.setMajorname((rs.getString("majorname")));
					College college = new College();
					college.setCollegeid(rs.getInt("collegeid"));
					college.setCollegename(rs.getString("collegename"));
					major.setCollege(college);
					list.add(major);
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
