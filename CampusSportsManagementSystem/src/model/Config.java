package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ʵ����
 * @author Administrator
 *
 */
public class Config {

	private int configid;
	private String starttime;
	private String endtime;
	private String reportstart;
	private String reportend;
	
	public Config() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Config(int configid, String starttime, String endtime,String reportstart,String reportend) {
		super();
		this.configid = configid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reportstart = reportstart;
		this.reportend = reportend;
	}
	
	public int getConfigid() {
		return configid;
	}
	public void setConfigid(int configid) {
		this.configid = configid;
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
	public String getReportstart() {
		return reportstart;
	}
	public void setReportstart(String reportstart) {
		this.reportstart = reportstart;
	}
	public String getReportend() {
		return reportend;
	}
	public void setReportend(String reportend) {
		this.reportend = reportend;
	}
	
	/**
	 * ��ʼ��ResultSet�еĵ�һ������
	 * @param rs ResultSet�����
	 */
	public Config(ResultSet rs) {
		//rs��ֻ���ʼ����һ����¼������
		try{
			if(rs != null && rs.next()){//����һһ��Ӧ
				this.configid = rs.getInt("configid");
				this.starttime = rs.getString("starttime");
				this.endtime = rs.getString("endtime");
				this.reportstart = rs.getString("reportstart");
				this.reportend = rs.getString("reportend");
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
		List<Config> list = new ArrayList<Config>();
		if(rs != null){
			try{
				while(rs.next()){
					Config config = new Config();
					config.setConfigid((rs.getInt("configid")));
					config.setStarttime((rs.getString("starttime")));
					config.setEndtime((rs.getString("endtime")));
					config.setReportstart((rs.getString("reportstart")));
					config.setReportend((rs.getString("reportend")));
					list.add(config);
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
