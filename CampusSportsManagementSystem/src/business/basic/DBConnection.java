package business.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ���ݿ������࣬���ڶ�Ӧ��jdbc��������ʵ�����ݿ�����ӺͶϿ�
 * @author Administrator
 * @version 2019-3-4
 */
public class DBConnection {

	private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://192.168.43.107:1433;DatabaseName=CSMS";
	private String user = "sa";
	private String pwd = "123456";
	/**
	 * ����DBConnection���趨�����ݿ����Ӳ���ʵ�����ݿ�����ӣ�������һ��ָ�����ݿ��Connection����
	 * @return Connection
	 * @throws Exception �׳����ܳ��ֵ��쳣
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	/**
	 * ��ͨ�����������Connection������йرղ���
	 * @param conn  Ҫ�رյ�����Connection����
	 */
	public void closeConnection(Connection conn,Statement stmt,ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn !=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		try {
			db.getConnection();
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���Ӵ���");
		}
	}
}
