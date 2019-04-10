package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ��ɫʵ����
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
	 * ResultSet�����תList
	 * @param rs ResultSet�����
	 * @return list
	 */
	public static List toList(ResultSet rs){
		//��̬���������ڽ�0~N��VUser��ͼ���ݽ�����List��������
		List<Role> list = new ArrayList<Role>();
		if(rs != null){
			try{
				while(rs.next()){
					Role role = new Role();
					role.setRoleid((rs.getInt("roleid")));
					role.setRolename((rs.getString("rolename")));
					list.add(role);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			return null;
		}
		return list;
	}
}
