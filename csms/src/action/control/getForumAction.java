package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
import model.TForumTitle;

import com.alibaba.fastjson.JSON;

public class getForumAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		try {
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			List<TForumTitle> list = forumdao.getForumTitleByPages(page, limit);
			int count = forumdao.getPageCount();
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