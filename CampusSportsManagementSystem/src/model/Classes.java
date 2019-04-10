package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * �༶ʵ����
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
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Classes(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.classid = rs.getInt("classid");
				this.classname = rs.getString("classname");
				Major major = new Major(rs);
				this.major = major;
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
		List<Classes> list = new ArrayList<Classes>();
		if(rs != null){
			try{
				while(rs.next()){
					Classes classes = new Classes();
					classes.setClassid((rs.getInt("classid")));
					classes.setClassname((rs.getString("classname")));
					Major major = new Major();
					major.setMajorid(rs.getInt("majorid"));
					classes.setMajor(major);
					list.add(classes);
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
