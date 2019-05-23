package action.control;

import java.util.List;

import model.TNews;

import com.opensymphony.xwork2.ActionSupport;

public class getNewAction extends BaseAction {
	private String newsId;
	
	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	/**
	 * @return
	 */
	public String execute() {
		List<TNews> newslist = null;
		TNews news = null;
		if(newsId.equals("")){
			newslist = newsdao.getAllNews();
			request.setAttribute("newlist", newslist);
			return SUCCESS;
		}
		else {
			news = newsdao.getNewsById(Integer.parseInt(newsId));
			request.setAttribute("news", news);
			return SUCCESS;
		}
	}
}