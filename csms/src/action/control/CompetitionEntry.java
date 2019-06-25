package action.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.VStudent;
import model.VTeacher;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import common.properties.RoleType;

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
		PrintWriter out = response.getWriter();
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			VStudent student = (VStudent) session.getAttribute("loginuser");
			int classid = student.getClassid();
			String hql = "from VStudent where classid=" + classid;
			List<VStudent> list = bdao.selectByPage(hql, page, limit);
			String hql2 = "select count(*) from VStudent where classid="
					+ classid;
			int count = bdao.selectValue(hql2);
			LayuiData data = new LayuiData();
			data.code = LayuiData.SUCCESS;
			data.count = 10;
			data.data = list;
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			VTeacher tea = (VTeacher) session.getAttribute("loginuser");
			int collegeid = tea.getCollegeid();
			String hql = "from VTeacher where collegeid=?" + collegeid;
			List<VTeacher> list = bdao.selectByPage(hql, page, limit);
			String hql2 = "select count(*) from VTeacher where collegeid=?"
					+ collegeid;
			int count = bdao.selectValue(hql2);
			LayuiData data = new LayuiData();
			data.code = LayuiData.SUCCESS;
			data.count = 10;
			data.data = list;
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		}
		return SUCCESS;
	}
}