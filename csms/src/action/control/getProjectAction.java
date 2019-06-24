package action.control;

import java.io.IOException;
import java.util.List;

import model.TProject;
import model.VStudent;
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
		VStudent loginstu = userdao.getStudent("1001");
		session.setAttribute("loginuser", loginstu);
		session.setAttribute("role", loginstu.getRoleid());
		// String op = request.getParameter("op");
		// if (op.equals("getproject")) {
		// List<TProject> projectlist = projectdao.select();
		// request.setAttribute("projectlist", projectlist);
		// returnUrl = "CompetitionTimesCheck.jsp";
		// return SUCCESS;
		// } else if (op.equals("project")) {
		// List<TProject> projectlist = projectdao.select();
		// request.setAttribute("projectlist", projectlist);
		// returnUrl = "projectScore.jsp";
		// return SUCCESS;
		// }
		// String type = request.getParameter("type");
		// if (type != null && !type.equals("")) {
		// String proname = request.getParameter("strwhere");
		// int roletype = Integer.parseInt(session.getAttribute("role")
		// .toString());
		// String startPage = request.getParameter("page");
		// String pageSize = request.getParameter("limit");
		// int count = 0;
		// String strwhere = "";
		// if (roletype == RoleType.Student || roletype == RoleType.Committee) {
		// count = bdao
		// .selectValue("select count(proid) from TProject where (protype=1 or protype=2) and proname like '%"
		// + proname + "%'");
		// strwhere =
		// "from TProject where (protype=1 or protype=2) and proname like '%"
		// + proname + "%'";
		// } else {
		// count = bdao
		// .selectValue("select count(proid) from TProject where (protype=3 or protype=4) and proname like '%"
		// + proname + "%'");
		// strwhere =
		// "from TProject where (protype=3 or protype=4) and proname like '%"
		// + proname + "%'";
		// }
		// List<TProject> list = bdao.selectByPage(strwhere,
		// Integer.parseInt(startPage), Integer.parseInt(pageSize));
		// out = response.getWriter();
		// LayuiData data = new LayuiData(0, "成功", count, list);
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// return null;
		// } else {
		int roletype = Integer
				.parseInt(session.getAttribute("role").toString());
		String startPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		int count = projectdao.getProCount(roletype);
		List<TProject> list = projectdao.selectByPage(roletype,
				Integer.parseInt(startPage), Integer.parseInt(pageSize));
		out = response.getWriter();
		LayuiData data = new LayuiData(0, "成功", count, list);
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
		return null;
		// }

	}
}