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
	 * @return
	 */
	public String execute() {
		try {
			List<VMatch> list = matchdao.select();
			int count = matchdao.getPageCount();
			ReturnData rd = new ReturnData();
			rd.code = ReturnData.SUCCESS;
			rd.msg = "³É¹¦";
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