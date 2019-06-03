package business.basic;

import java.sql.ResultSet;

/**
 * 数据库操作基类的业务接口
 * @author Administrator
 * @version 2019-3-4
 */
public interface BaseDao{
	/**
	 * 实现数据库的关闭与销毁
	 */
	public void close();
	
	/**
	 * 实现一个insert into sql语句的执行
	 * 案例提示：
	 * sql = "insert into T_User(userid, pwd, nickname) values('wuxf','123456','小凡')"
	 * insert(sql);
	 * @param sql  必须是实现insert into的SQL语句
	 * @return int 如果添加数据表中不含identity字段，则==0为执行失败，>0为执行成功，如果表中包含有identity字段，则0代表失败，>0为主键分配的系统编号
	 */
	public int insert(String sql);
	
	/**
	 * 实现一个带参数的insert into sql语句的执行
	 * 案例提示：
	 * sql = "insert into T_User(userid, pwd, nickname) values(?,?,?)"
	 * Object[] = para={'wuxf','123456','小凡'};
	 * insert(sql,para);
	 * @param sql  必须是实现insert into的SQL语句
	 * @param para  Object[]   
	 * @return  int 如果添加数据表中不含identity字段，则==0为执行失败，>0为执行成功，如果表中包含有identity字段，则0代表失败，>0为主键分配的系统编号
	 * 
	 */
	public int insert(String sql, Object[] para);
	
	/**
	 * 通用表数据修改方法
	 * 例如：sql = "update T_Account set balance = balace + 500 where cardid = 100001"
	 * BaseDAO dao = new BaseDAO();
	 * dao.update(sql);
	 * @param sql   是一个不带?的update语句
	 * @return int 返回受影响的行数
	 */
	public int update(String sql);
	
	/**
	 * 通用表数据修改方法
	 * * 例如：sql = "update T_Account set balance = balace + ? where cardid = ?"
	 * Object[] para = {500,"100001"};
	 * BaseDAO dao = new BaseDAO();
	 * dao.update(sql,para);
	 * @param sql   是一个带?的update语句
	 * @param Object[] 存储?对应的值的数组
	 * @return int  返回受影响的行数
	 */
	public int update(String sql,Object[] para);
	
	/**
	 * 通用表数据删除方法
	 * 例如：sql = "delete from T_Account where cardid = 100001"
	 * BaseDAO dao = new BaseDAO();
	 * dao.delete(sql);
	 * @param sql   是一个带?的delete语句
	 * @param Object[] 存储?对应的值的数组
	 * @return int  返回受影响的行数
	 */
	public int delete(String sql);
	
	/**
	 * 通用表数据删除方法
	 * 例如：sql = "delete from T_Account where cardid = ?"
	 * Object[] para = {"100001"};
	 * BaseDAO dao = new BaseDAO();
	 * dao.delete(sql,para);
	 * @param sql   是一个带?的delete语句
	 * @param Object[] 存储?对应的值的数组
	 * @return int  返回受影响的行数
	 */
	public int delete(String sql,Object[] para);
	
	/**
	 * 通用查询方法，调用该方法之后，需要调用BaseDAO类的close()来关闭相关资源对象
	 * 例如 ： sql = "select * from T_account"
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.select(sql);
	 * while(rs.next()){
	 * 		String cardid = rs.getString("cardid"); ....
	 * }
	 * dao.close(); //注意使用完毕后关闭数据库相关资源对象  
	 * @param sql  不带?的select查询语句
	 * @return ResultSet对象
	 */
	public ResultSet select(String sql);

	/**
	 * 通用查询方法，调用该方法之后，需要调用BaseDAO类的close()来关闭相关资源对象
	 * 例如 ： sql = "select * from T_account where cardid = ?"
	 * Object[] para ={"100005"};
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.select(sql);
	 * while(rs.next()){
	 * 		String cardid = rs.getString("cardid"); ....
	 * }
	 * dao.close(); //注意使用完毕后关闭数据库相关资源对象 
	 * @param sql  带?的select查询语句
	 * @param Object[]  存储对应?的实际值的数组 
	 * @return ResultSet对象
	 */
	public ResultSet select(String sql,Object[] param);

	/**
	 * 通用查询方法，方法将返回查询出来的记录总数
	 * @param sql  不带?的select查询语句
	 * @return int
	 */
	public int selectCount(String sql);
	
	/**
	 * 通用查询方法，方法将返回查询出来的记录总数
	 * @param sql  带?的select查询语句
	 * @param Object[]  存储对应?的实际值的数组 
	 * @return int
	 */
	public int selectCount(String sql,Object[] param);
	
	/**
	 * 获得按照分页要求的分页页数
	 * 例如 ：返回每页有5个记录的账户信息的分页总数 
	 * BaseDAO dao = new BaseDAO();
	 * int pageamount = pageAmount("select * from T_account",5);
	 * @param String 不带？参数的select查询语句
	 * @param int 每页的记录数
	 * @return int 计算出来的分页页数
	 */
	public int pageAmount(String sql, int sizePage);
	
	/**
	 * 获得按照分页要求的分页页数
	 * 案例 ： 如 pageAmount(String sql)
	 * @param String 带？参数的select查询语句
	 * @param Object[] 存储对应?的值的数组
	 * @param int 每页的记录数
	 * @return int 计算出来的分页页数
	 */
	public int pageAmount(String sql, Object[] param,int sizePage);

	/**
	 * 获得按照分页要求，并且指定页码的所有记录,调用完成后，需要调用BaseDAO类的close()
	 * 例如 ：按5条记录一页的分类方式 ，输出第2页的5条记录
	 * sql = "select * from T_account"
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.selectByPage(sql,2,5);
	 * for(int i=0;i<5;i++){
	 * 		String cardid = rs.getString("cardid"); ....
	 * 		rs.next(); 
	 * }
	 * dao.close(); //注意使用完毕后关闭数据库相关资源对象 
	 * @param String 不带？参数的select查询语句
	 * @param int 每页的记录数
	 * @param 要获得记录所在的当前页码，页码从1开始
	 * @return ResultSet
	 */
	public ResultSet selectByPage(String sql,int sizePage,int curPage);
	
	/**
	 * 获得按照分页要求，并且指定页码的所有记录,调用完成后，需要调用BaseDAO类的close()
	 * 例如 ：看 selectByPage(String sql,int sizePage,int curPage)
	 * @param String 不带？参数的select查询语句
	 * @param Object[] 存储对应?的值的数组
	 * @param int 每页的记录数
	 * @param 要获得记录所在的当前页码，页码从1开始
	 * @return ResultSet
	 */
	public ResultSet selectByPage(String sql,Object[] param,
			int sizePage,int curPage);

	/**
	 * 调用具有select作用的数据库存储过程，并返回查询结果到rs中
	 * @param procName String 存储过程名
	 * @return Object, 如果是查询存储过程，将返回ResultSet，否则 返回Integer的执行成功标志，1成功 ，0失败 
	 * @see 使用者在对BaseDAO类executeSelectProduce方法的调用结束后，要调用BaseDAO类的close()关闭资源;
	 * 案例：调用getSysDate存储过程，返回一个服务器时间
	 * BaseDAO bdao = new BaseDAO();
	 * ResultSet rs = bdao.executeSelectProduce("getSysDate");
	 * String currentTime = rs.getString(1);
	 * bdao.close()
	 */
	public Object executeProduce(String procName);
	
	/**
	 * 调用具有select作用的数据库存储过程，并返回查询结果到rs中
	 * @param procName String 存储过程名
	 * @param para Object[] 对应?的参数值数组
	 * @return Object, 如果是查询存储过程，将返回ResultSet，否则 返回Integer的执行成功标志，1成功 ，0失败  
	 * @see 使用者在对BaseDAO类executeSelectProduce方法的调用结束后，要调用BaseDAO类的close()关闭资源
	 * 案例：调用getSysDate存储过程，返回一个服务器时间
	 * BaseDAO bdao = new BaseDAO();
	 * ResultSet rs = bdao.executeSelectProduce("getSysDate");
	 * String currentTime = rs.getString(1);
	 * bdao.close()
	 */
	public Object executeProduce(String procName, Object[] para);


}
