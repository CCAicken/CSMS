package business.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 数据库连接类，基于对应的jdbc驱动程序实现数据库的链接和断开
 * @author Administrator
 * @version 2019-3-4
 */
public class DBConnection {

	private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://192.168.3.60:1433;DatabaseName=CSMS";
	//private String url = "jdbc:sqlserver://localhost:1433;DatabaseName=CSMS";
	private String user = "sa";
	private String pwd = "123456";
	/**
	 * 根据DBConnection中设定的数据库连接参数实现数据库的连接，并返回一个指定数据库的Connection对象
	 * @return Connection
	 * @throws Exception 抛出可能出现的异常
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	/**
	 * 将通过参数传入的Connection对象进行关闭操作
	 * @param conn  要关闭的连接Connection对象
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
			System.out.println("链接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接错误");
		}
	}
}
