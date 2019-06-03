package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ScoreCollege {
	private int collegeid;
	private String collegename;
	private double scorenumber;
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public ScoreCollege(ResultSet rs){
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.collegeid = rs.getInt("collegeid");
				this.scorenumber = rs.getDouble("scorenumber");
				this.collegename=rs.getString("collegename");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 将拥有多条记录的ResultSet对象按照分页要求转换为List<VForumTitle>               
	 * @param rs Result结果集
	 * @param pageSize 每页的记录数
	 * @return
	 */
	static public List<ScoreCollege> toList(ResultSet rs,int pageSize){
		List<ScoreCollege> list = new ArrayList<ScoreCollege>(); //长度为0的空的动态数组
		int count = 0;
		try {
			do{
				if(rs==null) break;
				ScoreCollege obj = new ScoreCollege();
				obj.collegeid = rs.getInt("collegeid");
				obj.collegename = rs.getString("collegename");
				obj.scorenumber = rs.getDouble("scorenumber");
				count++;
				list.add(obj); //将创建好的obj对象添加到list数组中保存
			}while(rs.next() && count <pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; //将数组返回
	}
	/**
	 * ResultSet结果集转List
	 * @param rs ResultSet结果集
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//静态方法，用于将0~N的VUser视图数据交换到List数组中来
		List<ScoreCollege> list = new ArrayList<ScoreCollege>();
		if(rs != null){
			try{
				while(rs.next()){
					ScoreCollege ScoreCollege = new ScoreCollege();
					ScoreCollege.setCollegeid(rs.getInt("collegeid"));
					ScoreCollege.setScorenumber(rs.getDouble("scorenumber"));
					ScoreCollege.setCollegename(rs.getString("collegename"));
					list.add(ScoreCollege);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
	
	
	
	public ScoreCollege(int collegeid, String collegename, double scorenumber) {
		super();
		this.collegeid = collegeid;
		this.collegename = collegename;
		this.scorenumber = scorenumber;
	}
	public ScoreCollege() {
		super();
		// TODO Auto-generated constructor stub
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
	public double getScorenumber() {
		return scorenumber;
	}
	public void setScorenumber(double scorenumber) {
		this.scorenumber = scorenumber;
	}
}
