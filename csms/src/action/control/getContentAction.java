package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.TForumContent;
import model.TForumTitle;
import model.VForum;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getContentAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		// 返回layui表格
		if (op.equals("table")) {
			String startPage = request.getParameter("page");// 起始页面
			int limit = Integer.parseInt(request.getParameter("limit"));// 每页限制条数
			int allcount = bdao
					.selectValue(("select count(collegeid) from TCollege"));
			Writer out;
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "成功", allcount,
						bdao.selectByPage("from TCollege",
								Integer.parseInt(startPage), limit));

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} else if (op.equals("byforumid")) {
			// 返回所有学院信息列表
			int forumid = Integer.parseInt(request.getParameter("titleid"));
			TForumTitle forum = forumdao.getTForumById(forumid);
			List<VForum> listcontent = contentdao.getContentByForumid(forumid);
			request.setAttribute("listcontent", listcontent);
			request.setAttribute("forum", forum);
		} else if (op.equals("byid")) {
			// 根据学院id返回该学院信息列表
			int contentid = (Integer) request.getAttribute("contentid");
			TForumContent content = contentdao.getTContnentById(contentid);
			request.setAttribute("content", content);
		}
		return SUCCESS;
	}
}