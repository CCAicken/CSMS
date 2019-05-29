package action.control;

import java.io.IOException;
import java.util.List;

import model.TProject;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getProjectAction extends BaseAction {
	private String userid;
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		int roletype = Integer.parseInt(session.getAttribute("role").toString());
		String startPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		int count = projectdao.getProCount(roletype);
		List<TProject> list = projectdao.selectByPage(roletype, Integer.parseInt(startPage), Integer.parseInt(pageSize));
		out = response.getWriter();
		LayuiData data = new LayuiData(0, "³É¹¦", count, list);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
		return SUCCESS;
	}
}