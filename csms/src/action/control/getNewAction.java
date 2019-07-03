package action.control;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.TConfig;
import model.TNews;
import model.VNews;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getNewAction extends BaseAction {
	private String newsId;

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	/**
	 * @return
	 */
	public String execute() {

		TConfig config = sportsdao.getConfig();
		if (config != null) {
			session.setAttribute("config", config);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String newDate = df.format(new Date());
			int res = config.getStarttime().compareTo(newDate);// if(res>0)
			// config.getStarttime>newDate
			int res2 = config.getEndtime().compareTo(newDate);
			if (res <= 0 && res2 >= 0) {
				session.setAttribute("sporttype", "yes");
			} else {
				session.setAttribute("sporttype", "no");
			}
		} else {
			session.setAttribute("sporttype", "no");
		}

		List<TNews> newslist = null;
		VNews news = null;
		if (newsId.equals("")) {
			int allcount = bdao.selectValue(("select count(newid) from TNews"));
			Writer out;
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "成功", allcount,
						newsdao.getAllNews(), null);

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} else {
			news = newsdao.getNewsById(Integer.parseInt(newsId));
			request.setAttribute("news", news);
			return ERROR;
		}
	}
}