package action.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.VStudent;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class CompetitionEntry extends BaseAction {
	private int page;
	private int limit;

	public void setPage(int page) {
		this.page = page;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {
		int roletype = Integer
				.parseInt(session.getAttribute("role").toString());
		VStudent student = (VStudent) session.getAttribute("loginuser");
		int classid = student.getClassid();
		List<VStudent> list = bdao.selectByPage(
				"from VStudent where classid=13", page, limit);
		int count = bdao
				.selectValue("select count(userid) from VStudent where classid=13");
		PrintWriter out = response.getWriter();
		LayuiData data = new LayuiData();
		data.code = LayuiData.SUCCESS;
		data.count = 10;
		data.data = list;
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
		return SUCCESS;
	}
}