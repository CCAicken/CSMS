package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.properties.RoleType;

/**
 * 角色实体类
 * @author Administrator
 *
 */
public class Role {

	private int roleid;
	private String rolename;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Role(int roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * 初始化ResultSet中的第一条数据
	 * @param rs ResultSet结果集
	 */
	public Role(ResultSet rs) {
		//rs中只会初始化第一条记录的数据
		try{
			if(rs != null && rs.next()){//必须一一对应
				this.roleid = rs.getInt("roleid");
				this.rolename = rs.getString("rolename");
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
		List<Role> list = new ArrayList<Role>();
		if(rs != null){
			try{
				do{
					Role role = new Role();
					role.setRoleid((rs.getInt("roleid")));
					role.setRolename((rs.getString("rolename")));
					list.add(role);
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
