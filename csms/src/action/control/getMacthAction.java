package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
import model.VMatch;

import com.alibaba.fastjson.JSON;

public class getMacthAction extends BaseAction {
	/**
	 * @return
	 */
	public String execute() {
		try {
			int page = Integer.parseInt(request.getParameter("page"));
			int limit = Integer.parseInt(request.getParameter("limit"));
			List<VMatch> list = matchdao.selectByPage(page, limit);
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