package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * רҵʵ����
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
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Major(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.majorid = rs.getInt("majorid");
				this.majorname = rs.getString("majorname");
				College college = new College(rs);
				this.college = college;
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
		List<Major> list = new ArrayList<Major>();
		if(rs != null){
			try{
				while(rs.next()){
					Major major = new Major();
					major.setMajorid((rs.getInt("majorid")));
					major.setMajorname((rs.getString("majorname")));
					College college = new College();
					college.setCollegeid(rs.getInt("college"));
					major.setCollege(college);
					list.add(major);
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
