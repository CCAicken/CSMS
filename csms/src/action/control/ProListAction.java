package action.control;

import java.io.IOException;
import java.util.List;

import model.VSportProject;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class ProListAction extends BaseAction {

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {
		String op = request.getParameter("op");
		if (op.equals("getproject")) {
			List<VSportProject> projectlist = projectdao.select();
			LayuiData data = new LayuiData();
			data.code = LayuiData.SUCCESS;
			data.data = projectlist;
			data.msg = "³É¹¦";
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
			return null;
		}
		return null;
	}
}