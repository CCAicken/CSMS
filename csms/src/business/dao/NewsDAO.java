package business.dao;

import java.util.List;

import model.TNews;

public interface NewsDAO {
	/**
	 * 添加公告
	 * @param news
	 * @return 返回值>0表示成功，<0表示失敗
	 */
	public int addNews(TNews news);
	/**
	 * 根據公告id獲取公告
	 * @param newid
	 * @return
	 */
	public TNews getNewsById(int newid);
	/**
	 * 獲取所有公告
	 * @return
	 */
	public List<TNews> getAllNews();
	/**
	 * 根據發佈人id獲取對應的公告對象
	 * @param teaid
	 * @return
	 */
	public List<TNews> getNewsByTeaid(String teaid);
}
