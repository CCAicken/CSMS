package action.control;

import java.io.IOException;
import java.util.List;

import model.TUser;
import model.VSportProject;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getProjectAction extends BaseAction {
	private String returnUrl;

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {
		// String op = request.getParameter("op");
		// if (op.equals("getproject")) {
		// List<VSportProject> projectlist = projectdao.select();
		// request.setAttribute("projectlist", projectlist);
		// returnUrl = "CompetitionTimesCheck.jsp";
		// return SUCCESS;
		// } else if (op.equals("project")) {
		// List<VSportProject> projectlist = projectdao.select();
		// request.setAttribute("projectlist", projectlist);
		// returnUrl = "projectScore.jsp";
		// return SUCCESS;
		// }

		TUser user = (TUser) session.getAttribute("loginuser");
		String startPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String proname = request.getParameter("strwhere");
		String strwhere = null;
		if (user != null) {
			int roletype = user.getUsertype();
			if (proname != null && !proname.equals("")) {
				strwhere = "proname like '%" + proname + "%'";
			}
			int count = projectdao.getProCountByRole(strwhere, roletype);
			List<VSportProject> list = null;
			if (startPage == null || startPage.equals("") || pageSize == null
					|| pageSize.equals("")) {
				list = projectdao.select();
			} else {
				list = projectdao
						.selectByPage(strwhere, roletype,
								Integer.parseInt(startPage),
								Integer.parseInt(pageSize));
			}
			out = response.getWriter();
			LayuiData data = new LayuiData(0, "成功", count, list);
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		} else {
			if (proname != null && !proname.equals("")) {
				strwhere = "proname like '%" + proname + "%'";
			}
			int count = projectdao.getAllAmount(strwhere);
			List<VSportProject> list = projectdao.getAllProject(strwhere,
					Integer.parseInt(startPage), Integer.parseInt(pageSize));
			out = response.getWriter();
			LayuiData data = new LayuiData(0, "成功", count, list);
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		}
		return null;
	}
}
