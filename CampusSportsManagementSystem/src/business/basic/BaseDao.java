package business.basic;

import java.sql.ResultSet;

/**
 * ���ݿ���������ҵ��ӿ�
 * @author Administrator
 * @version 2019-3-4
 */
public interface BaseDao{
	/**
	 * ʵ�����ݿ�Ĺر�������
	 */
	public void close();
	
	/**
	 * ʵ��һ��insert into sql����ִ��
	 * ������ʾ��
	 * sql = "insert into T_User(userid, pwd, nickname) values('wuxf','123456','С��')"
	 * insert(sql);
	 * @param sql  ������ʵ��insert into��SQL���
	 * @return int ���������ݱ��в���identity�ֶΣ���==0Ϊִ��ʧ�ܣ�>0Ϊִ�гɹ���������а�����identity�ֶΣ���0����ʧ�ܣ�>0Ϊ���������ϵͳ���
	 */
	public int insert(String sql);
	
	/**
	 * ʵ��һ����������insert into sql����ִ��
	 * ������ʾ��
	 * sql = "insert into T_User(userid, pwd, nickname) values(?,?,?)"
	 * Object[] = para={'wuxf','123456','С��'};
	 * insert(sql,para);
	 * @param sql  ������ʵ��insert into��SQL���
	 * @param para  Object[]   
	 * @return  int ���������ݱ��в���identity�ֶΣ���==0Ϊִ��ʧ�ܣ�>0Ϊִ�гɹ���������а�����identity�ֶΣ���0����ʧ�ܣ�>0Ϊ���������ϵͳ���
	 * 
	 */
	public int insert(String sql, Object[] para);
	
	/**
	 * ͨ�ñ������޸ķ���
	 * ���磺sql = "update T_Account set balance = balace + 500 where cardid = 100001"
	 * BaseDAO dao = new BaseDAO();
	 * dao.update(sql);
	 * @param sql   ��һ������?��update���
	 * @return int ������Ӱ�������
	 */
	public int update(String sql);
	
	/**
	 * ͨ�ñ������޸ķ���
	 * * ���磺sql = "update T_Account set balance = balace + ? where cardid = ?"
	 * Object[] para = {500,"100001"};
	 * BaseDAO dao = new BaseDAO();
	 * dao.update(sql,para);
	 * @param sql   ��һ����?��update���
	 * @param Object[] �洢?��Ӧ��ֵ������
	 * @return int  ������Ӱ�������
	 */
	public int update(String sql,Object[] para);
	
	/**
	 * ͨ�ñ�����ɾ������
	 * ���磺sql = "delete from T_Account where cardid = 100001"
	 * BaseDAO dao = new BaseDAO();
	 * dao.delete(sql);
	 * @param sql   ��һ����?��delete���
	 * @param Object[] �洢?��Ӧ��ֵ������
	 * @return int  ������Ӱ�������
	 */
	public int delete(String sql);
	
	/**
	 * ͨ�ñ�����ɾ������
	 * ���磺sql = "delete from T_Account where cardid = ?"
	 * Object[] para = {"100001"};
	 * BaseDAO dao = new BaseDAO();
	 * dao.delete(sql,para);
	 * @param sql   ��һ����?��delete���
	 * @param Object[] �洢?��Ӧ��ֵ������
	 * @return int  ������Ӱ�������
	 */
	public int delete(String sql,Object[] para);
	
	/**
	 * ͨ�ò�ѯ���������ø÷���֮����Ҫ����BaseDAO���close()���ر������Դ����
	 * ���� �� sql = "select * from T_account"
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.select(sql);
	 * while(rs.next()){
	 * 		String cardid = rs.getString("cardid"); ....
	 * }
	 * dao.close(); //ע��ʹ����Ϻ�ر����ݿ������Դ����  
	 * @param sql  ����?��select��ѯ���
	 * @return ResultSet����
	 */
	public ResultSet select(String sql);

	/**
	 * ͨ�ò�ѯ���������ø÷���֮����Ҫ����BaseDAO���close()���ر������Դ����
	 * ���� �� sql = "select * from T_account where cardid = ?"
	 * Object[] para ={"100005"};
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.select(sql);
	 * while(rs.next()){
	 * 		String cardid = rs.getString("cardid"); ....
	 * }
	 * dao.close(); //ע��ʹ����Ϻ�ر����ݿ������Դ���� 
	 * @param sql  ��?��select��ѯ���
	 * @param Object[]  �洢��Ӧ?��ʵ��ֵ������ 
	 * @return ResultSet����
	 */
	public ResultSet select(String sql,Object[] param);

	/**
	 * ͨ�ò�ѯ���������������ز�ѯ�����ļ�¼����
	 * @param sql  ����?��select��ѯ���
	 * @return int
	 */
	public int selectCount(String sql);
	
	/**
	 * ͨ�ò�ѯ���������������ز�ѯ�����ļ�¼����
	 * @param sql  ��?��select��ѯ���
	 * @param Object[]  �洢��Ӧ?��ʵ��ֵ������ 
	 * @return int
	 */
	public int selectCount(String sql,Object[] param);
	
	/**
	 * ��ð��շ�ҳҪ��ķ�ҳҳ��
	 * ���� ������ÿҳ��5����¼���˻���Ϣ�ķ�ҳ���� 
	 * BaseDAO dao = new BaseDAO();
	 * int pageamount = pageAmount("select * from T_account",5);
	 * @param String ������������select��ѯ���
	 * @param int ÿҳ�ļ�¼��
	 * @return int ��������ķ�ҳҳ��
	 */
	public int pageAmount(String sql, int sizePage);
	
	/**
	 * ��ð��շ�ҳҪ��ķ�ҳҳ��
	 * ���� �� �� pageAmount(String sql)
	 * @param String ����������select��ѯ���
	 * @param Object[] �洢��Ӧ?��ֵ������
	 * @param int ÿҳ�ļ�¼��
	 * @return int ��������ķ�ҳҳ��
	 */
	public int pageAmount(String sql, Object[] param,int sizePage);

	/**
	 * ��ð��շ�ҳҪ�󣬲���ָ��ҳ������м�¼,������ɺ���Ҫ����BaseDAO���close()
	 * ���� ����5����¼һҳ�ķ��෽ʽ �������2ҳ��5����¼
	 * sql = "select * from T_account"
	 * BaseDAO dao = new BaseDAO();
	 * ResultSet rs = dao.selectByPage(sql,2,5);
	 * for(int i=0;i<5;i++){
	 * 		String cardid = rs.getString("cardid"); ....
	 * 		rs.next(); 
	 * }
	 * dao.close(); //ע��ʹ����Ϻ�ر����ݿ������Դ���� 
	 * @param String ������������select��ѯ���
	 * @param int ÿҳ�ļ�¼��
	 * @param Ҫ��ü�¼���ڵĵ�ǰҳ�룬ҳ���1��ʼ
	 * @return ResultSet
	 */
	public ResultSet selectByPage(String sql,int sizePage,int curPage);
	
	/**
	 * ��ð��շ�ҳҪ�󣬲���ָ��ҳ������м�¼,������ɺ���Ҫ����BaseDAO���close()
	 * ���� ���� selectByPage(String sql,int sizePage,int curPage)
	 * @param String ������������select��ѯ���
	 * @param Object[] �洢��Ӧ?��ֵ������
	 * @param int ÿҳ�ļ�¼��
	 * @param Ҫ��ü�¼���ڵĵ�ǰҳ�룬ҳ���1��ʼ
	 * @return ResultSet
	 */
	public ResultSet selectByPage(String sql,Object[] param,
			int sizePage,int curPage);

	/**
	 * ���þ���select���õ����ݿ�洢���̣������ز�ѯ�����rs��
	 * @param procName String �洢������
	 * @return Object, ����ǲ�ѯ�洢���̣�������ResultSet������ ����Integer��ִ�гɹ���־��1�ɹ� ��0ʧ�� 
	 * @see ʹ�����ڶ�BaseDAO��executeSelectProduce�����ĵ��ý�����Ҫ����BaseDAO���close()�ر���Դ;
	 * ����������getSysDate�洢���̣�����һ��������ʱ��
	 * BaseDAO bdao = new BaseDAO();
	 * ResultSet rs = bdao.executeSelectProduce("getSysDate");
	 * String currentTime = rs.getString(1);
	 * bdao.close()
	 */
	public Object executeProduce(String procName);
	
	/**
	 * ���þ���select���õ����ݿ�洢���̣������ز�ѯ�����rs��
	 * @param procName String �洢������
	 * @param para Object[] ��Ӧ?�Ĳ���ֵ����
	 * @return Object, ����ǲ�ѯ�洢���̣�������ResultSet������ ����Integer��ִ�гɹ���־��1�ɹ� ��0ʧ��  
	 * @see ʹ�����ڶ�BaseDAO��executeSelectProduce�����ĵ��ý�����Ҫ����BaseDAO���close()�ر���Դ
	 * ����������getSysDate�洢���̣�����һ��������ʱ��
	 * BaseDAO bdao = new BaseDAO();
	 * ResultSet rs = bdao.executeSelectProduce("getSysDate");
	 * String currentTime = rs.getString(1);
	 * bdao.close()
	 */
	public Object executeProduce(String procName, Object[] para);


}
