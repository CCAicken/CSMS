package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.TForumTitle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import util.LayuiData;
import business.dao.ForumDAO;
import business.impl.ForumDAOImpl;

import com.alibaba.fastjson.JSON;

public class getForumAction extends BaseAction {
	/**
	 * 每页记录数
	 */
	private int limit;
	/**
	 * 当前页数
	 */
	private int page;
	
	
	public int getLimit() {
		return limit;
	}


	public void setLimit(int limit) {
		this.limit = limit;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	/**
	 * @return
	 */
	public String execute() {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			List<TForumTitle> list = forumdao.getForumTitleByPages(page, limit);
			int count = forumdao.getPageCount();
			LayuiData rd = new LayuiData();
			rd.code = LayuiData.SUCCESS;
			rd.msg = "成功";
			rd.count = count;
			rd.data = list;
			out.write(JSON.toJSONString(rd));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}