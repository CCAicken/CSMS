package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.TNews;
import model.VNews;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getNewAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		List<TNews> newslist = null;
		VNews news = null;
		String newsId = request.getParameter("newsId");
		if (newsId != null) {
			news = newsdao.getNewsById(Integer.parseInt(newsId));
			request.setAttribute("news", news);
			return SUCCESS;
		} else {
			int allcount = bdao.selectValue(("select count(newid) from TNews"));
			Writer out;
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "³É¹¦", allcount,
						newsdao.getAllNews());

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;

		}
	}
}