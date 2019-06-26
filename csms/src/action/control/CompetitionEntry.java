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
	private int proid;

	public void setProid(int proid) {
		this.proid = proid;
	}

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
		String conditions = request.getParameter("strwhere");
		String strwhere = null;
		String hql = null;
		String hql2 = null;
		if (roletype == RoleType.Student || roletype == RoleType.Committee) {
			VStudent student = (VStudent) session.getAttribute("loginuser");
			int classid = student.getClassid();
			// hql = "from VStudent where classid=" + classid;
			hql = "from VStudent where userid not in (select userid from VMatch where userid in (select userid from VStudent where classid="
					+ classid
					+ ") and proid="
					+ proid
					+ ") and classid="
					+ classid + "and limit<5";
			if (conditions != null && !conditions.equals("")) {
				strwhere = " and username like '%" + conditions
						+ "%' or collegename like '%" + conditions
						+ "%' or classname like '%" + conditions + "%'";
				hql += strwhere;
			}
			List<VStudent> list = bdao.selectByPage(hql, page, limit);
			// hql2 = "select count(*) from VStudent where classid=" + classid;
			hql2 = "select count(*) from VStudent where userid not in (select userid from VMatch where userid in (select userid from VStudent where classid="
					+ classid
					+ ") and proid="
					+ proid
					+ ") and classid="
					+ classid + "and limit<5";
			if (conditions != null && !conditions.equals("")) {
				strwhere = " and username like '%" + conditions
						+ "%' or collegename like '%" + conditions
						+ "%' or classname like '%" + conditions + "%'";
				hql2 += strwhere;
			}
			int count = bdao.selectValue(hql2);
			LayuiData data = new LayuiData();
			data.code = LayuiData.SUCCESS;
			data.count = count;
			data.data = list;
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		} else if (roletype == RoleType.Teacher
				|| roletype == RoleType.Organization) {
			VTeacher tea = (VTeacher) session.getAttribute("loginuser");
			int collegeid = tea.getCollegeid();
			// hql = "from VTeacher where collegeid=" + collegeid;
			hql = "from VTeacher where userid not in (select userid from VMatch where userid in (select userid from VTeacher where collegeid="
					+ collegeid
					+ ") and proid="
					+ proid
					+ ") and collegeid="
					+ collegeid + "and limit<5";
			if (conditions != null && !conditions.equals("")) {
				strwhere = " and username like '%" + conditions
						+ "%' or collegename like '%" + conditions;
				hql += strwhere;
			}
			List<VTeacher> list = bdao.selectByPage(hql, page, limit);
			// hql2 = "select count(*) from VTeacher where collegeid=" +
			// collegeid;
			hql2 = "select count(*) from VTeacher where userid not in (select userid from VMatch where userid in (select userid from VTeacher where collegeid="
					+ collegeid
					+ ") and proid="
					+ proid
					+ ") and collegeid="
					+ collegeid + "and limit<5";
			if (conditions != null && !conditions.equals("")) {
				strwhere = " and username like '%" + conditions
						+ "%' or collegename like '%" + conditions;
				hql2 += strwhere;
			}
			int count = bdao.selectValue(hql2);
			LayuiData data = new LayuiData();
			data.code = LayuiData.SUCCESS;
			data.count = count;
			data.data = list;
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		}
		return null;
	}
}