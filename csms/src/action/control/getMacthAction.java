package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.ReturnData;
import model.TMajor;
import model.TMatch;
import model.VMatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import business.dao.MajorDAO;
import business.dao.MatchDAO;

import com.alibaba.fastjson.JSON;

public class getMacthAction extends BaseAction {
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
		try {
			List<VMatch> list = matchdao.selectByPage(page, limit);
			int count = matchdao.getPageCount();
			ReturnData rd = new ReturnData();
			rd.code = ReturnData.SUCCESS;
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
		return SUCCESS;
	}
}