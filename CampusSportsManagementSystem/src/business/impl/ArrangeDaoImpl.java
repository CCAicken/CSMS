package business.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Arrange;
import model.College;
import business.basic.BaseDao;
import business.basic.BaseDaoImpl;
import business.dao.ArrangeDAO;

public class ArrangeDaoImpl implements ArrangeDAO {
	private BaseDao bdao = null;
	public ArrangeDaoImpl(){
		bdao = new BaseDaoImpl();
	}
	@Override
	public boolean insert(Arrange arrange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int arrangeid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Arrange> select() {
		String sql = "select * from V_Arrange";
		ResultSet rs = bdao.select(sql);
		List<Arrange> list = null;
		try {
			if(rs!=null&&rs.next()){
				list = Arrange.toList(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

}
