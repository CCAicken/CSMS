package business.basic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaoImpl extends DBConnection implements BaseDao {
	private Connection conn = null;
	private PreparedStatement ptmt = null;
	CallableStatement ctmt = null;
	ResultSet rs = null;
	@Override
	public void close(){
		this.closeConnection(conn, ptmt, rs);
	}
	
	@Override
	public int insert(String sql) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			int row = ptmt.executeUpdate();
			if(row>0){
				rs = ptmt.getGeneratedKeys();
				//如果rs有值，则代表主键是identity
				if(rs.next()){
					int key = rs.getInt(1);
					if(key > 0){
						return key;
					}else{
						return row;
					}
				}else{
					return row;
				}
			}
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int insert(String sql, Object[] param) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			int row = ptmt.executeUpdate();
			if(row>0){
				rs = ptmt.getGeneratedKeys();
				//如果rs有值，则代表主键是identity
				if(rs.next()){
					int key = rs.getInt(1);
					if(key > 0){
						return key;
					}else{
						return row;
					}
				}else{
					return row;
				}
			}
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int update(String sql) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			int row = ptmt.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int update(String sql, Object[] param) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			int row = ptmt.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int delete(String sql) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			int row = ptmt.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int delete(String sql, Object[] param) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			int row = ptmt.executeUpdate();
			return row;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.close();
		}
		return 0;
	}

	@Override
	public ResultSet select(String sql) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = ptmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			this.close();
		}
		return null;
	}

	@Override
	public ResultSet select(String sql, Object[] param) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			rs = ptmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			this.close();
		}
		return null;
	}

	@Override
	public int selectCount(String sql) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = ptmt.executeQuery();
			if(rs != null){
				rs.last();
				int count = rs.getRow();
				return count;
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int selectCount(String sql, Object[] param) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			rs = ptmt.executeQuery();
			if(rs != null){
				rs.last();
				int count = rs.getRow();
				return count;
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int pageAmount(String sql, int sizePage) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = ptmt.executeQuery();
			if(rs != null){
				rs.last();
				int count = rs.getRow();
				if(count>sizePage){
					int amount = count / sizePage;
					int i = count % sizePage;
					if(i!=0){
						return amount+1;
					}else{
						return amount;
					}
				}else{
					return 1;
				}
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return 0;
	}

	@Override
	public int pageAmount(String sql, Object[] param, int sizePage) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			rs = ptmt.executeQuery();
			if(rs != null){
				rs.last();
				int count = rs.getRow();
				if(count>sizePage){
					int amount = count / sizePage;
					int i = count % sizePage;
					if(i!=0){
						return amount+1;
					}else{
						return amount;
					}
				}else{
					return 1;
				}
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return 0;
	}

	@Override
	public ResultSet selectByPage(String sql, int sizePage, int curPage) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = ptmt.executeQuery();
			//先获取页数
			rs.last();
			int count = rs.getRow();
			if(count<=0){
				this.close();
				return null;
			}else{
				int pages = 0;
				if(count>sizePage){
					int amount = count / sizePage;
					int i = count % sizePage;
					if(i!=0){
						pages = amount+1;
					}else{
						pages = amount;
					}
				}else{
					pages = 1;
				}
				//判断curPage是否有效
				if(curPage<1){
					curPage = 1;
				}
				if(curPage>pages){
					curPage = pages;
				}
				int startIndex = (curPage-1)*sizePage+1;
				rs.absolute(startIndex);
				return rs;
			}
		} catch (Exception e) {
			e.printStackTrace();
			close();
		}
		return null;
	}

	@Override
	public ResultSet selectByPage(String sql, Object[] param, int sizePage,
			int curPage) {
		try {
			conn = this.getConnection();
			ptmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			//设置参数
			for(int i=0;i<param.length;i++){
				ptmt.setObject(i+1, param[i]);
			}
			rs = ptmt.executeQuery();
			//先获取页数
			rs.last();
			int count = rs.getRow();
			if(count<=0){
				this.close();
				return null;
			}else{
				int pages = 0;
				if(count>sizePage){
					int amount = count / sizePage;
					int i = count % sizePage;
					if(i!=0){
						pages = amount+1;
					}else{
						pages = amount;
					}
				}else{
					pages = 1;
				}
				//判断curPage是否有效
				if(curPage<1){
					curPage = 1;
				}
				if(curPage>pages){
					curPage = pages;
				}
				int startIndex = (curPage-1)*sizePage+1;
				rs.absolute(startIndex);
				return rs;
			}
		} catch (Exception e) {
			e.printStackTrace();
			close();
		}
		return null;
	}

	@Override
	public Object executeProduce(String procName) {
		try{
			conn = this.getConnection();
			ctmt = conn.prepareCall("{? = call "+procName+"}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			boolean type = ctmt.execute();
			if(type){//为true表明存储过程是一个select语句
				rs = ctmt.getResultSet();
				return rs;
			}else{//不是select，则获取返回值
				int isSuccess = ctmt.getInt(1);//获取返回值
				return new Integer(isSuccess);
			}
		}catch(Exception e){
			e.printStackTrace();
			close();
		}
		return null;
	}

	@Override
	public Object executeProduce(String procName, Object[] param) {
		try{
			conn = this.getConnection();
			ctmt = conn.prepareCall("{? = call "+procName+"}");
			ctmt.registerOutParameter(1, java.sql.Types.INTEGER);
			//设置参数
			for(int i=0;i<param.length;i++){
				ctmt.setObject(i+2, param[i]);
			}
			boolean type = ctmt.execute();
			if(type){//为true表明存储过程是一个select语句
				rs = ctmt.getResultSet();
				return rs;
			}else{//不是select，则获取返回值
				int isSuccess = ctmt.getInt(1);//获取返回值
				return new Integer(isSuccess);
			}
		}catch(Exception e){
			e.printStackTrace();
			close();
		}
		return null;
	}
	

	public static void main(String[] args) {
		BaseDaoImpl bdao = new BaseDaoImpl();
		//insert实例
		//无identity表返回受影响行数
//		String sql = "insert into T_User(userid,pwd,nickname,usertype) values(?,?,?,?)";
//		Object[] parem = {"zhouliu","000000","周六",1};
//		int row = bdao.insert(sql,parem);
//		System.out.println(row);
		//有identity表返回identity
//		String sql = "insert into T_ForumTitle(topic,serilize,querykey,area,userid,ipaddr) values(?,?,?,?,?,?)";
//		Object[] param = {"红河-之旅","红河之旅","景点",1,"lisi","192.168.123.1"};
//		int row = bdao.insert(sql,param);
//		System.out.println(row);
		
		//update实例
//		String sql = "update T_User set realname=? where userid=?";
//		Object[] param = {"赵六","zhouliu"};
//		int row = bdao.update(sql,param);
//		System.out.println(row);
		
		//delete实例
//		String sql = "delete from T_User where userid=?";
//		Object[] param = {"zhouliu"};
//		int row = bdao.delete(sql,param);
//		System.out.println(row);
		
		//select实例
		String sql = "select * from T_User where agend=?";
		Object[] param = {"男"};
		ResultSet rs = bdao.select(sql,param);
		try {
			if(rs != null){
				while (rs.next()) {
					System.out.println(rs.getString("userid")+","+rs.getString("nickname"));
				}
				rs.close();
			}else{
				System.out.println("无符合条件数据");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//selectCount实例
//		String sql = "select count(userid) from T_User where agend=?";
//		Object[] param = {"男"};
//		int count = bdao.selectCount(sql,param);
//		System.out.println(count);
		
		//pageAmount实例
//		String sql = "select * from T_User where agend=?";
//		Object[] param = {"男"};
//		int amount = bdao.pageAmount(sql,param,2);
//		System.out.println(amount);
	}
}
