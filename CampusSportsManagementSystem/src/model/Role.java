package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.properties.RoleType;

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
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Role(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.roleid = rs.getInt("roleid");
				this.rolename = rs.getString("rolename");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
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
