package business.impl;

import java.util.List;

import model.VCollegeScore;
import business.dao.ScoreCollegeDAO;

public class ScoreCollegeDaoImpl implements ScoreCollegeDAO {

	@Override
	public VCollegeScore getByCollegeid(int collegeid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VCollegeScore> getAllCollegeScore(String asction,
			String opretion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VCollegeScore> getAllCollegeScoreBypage(String opretion,
			int pageSize, int currpage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VCollegeScore> getSearchCollege(String opretion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getpageAmount(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getpageAmountbysearch(String opraton, int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

}
