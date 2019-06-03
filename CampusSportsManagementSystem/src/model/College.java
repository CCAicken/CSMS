package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 学院实体类
 * @author Administrator
 *
 */
public class College {
	
	private int collegeid;
	private String collegename;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public College(int collegeid, String collegename) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
	}
	
	public int getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(int collegeid) {
		this.collegeid = collegeid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public College(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.collegeid = rs.getInt("collegeid");
				this.collegename = rs.getString("collegename");
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
		List<College> list = new ArrayList<College>();
		if(rs != null){
			try{
				do{
					College college = new College();
					college.setCollegeid((rs.getInt("collegeid")));
					college.setCollegename((rs.getString("collegename")));
					list.add(college);
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
