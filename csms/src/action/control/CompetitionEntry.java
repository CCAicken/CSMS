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
		response.setCharacterEncoding("utf-8");
		// String type = request.getParameter("type");
		// if (type != null && !type.equals("")) {
		// String strwhere = request.getParameter("strwhere");
		// Integer roletype = (Integer) session.getAttribute("role");
		// if (roletype.equals(RoleType.Student)
		// || roletype.equals(RoleType.Committee)) {
		// VStudent stu = (VStudent) session.getAttribute("loginuser");
		// int classid = stu.getClassid();
		// // Object[] para = {classid};
		// // List<VStudent> stuList =
		// // (List<VStudent>)bdao.selectByPage("form VStudent where classid=?",
		// // para, page, limit);
		// List<VStudent> stuList = bdao.selectByPage(
		// "from VStudent where classid=" + classid
		// + " and (username like '%" + strwhere
		// + "%' or userid like '%" + strwhere + "%')",
		// page, limit);
		//
		// int count = userdao.stucount(classid);
		// // LayuiData data = new LayuiData(0, "成功", count, stuList);
		// ReturnData data = new ReturnData();
		// data.code = ReturnData.SUCCESS;
		// data.count = count;
		// data.data = stuList;
		// try {
		// out = response.getWriter();
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return SUCCESS;
		// } else if (roletype.equals(RoleType.Teacher)
		// || roletype.equals(RoleType.Organization)) {
		// VTeacher tea = (VTeacher) session.getAttribute("loginuser");
		// int colid = tea.getCollegeid();
		// // List<VTeacher> teaList = userdao.selectTeaByCollPage(colid,
		// // page,
		// // limit);
		// List<VTeacher> teaList = bdao.selectByPage(
		// "from VTeacher where collegeid=" + colid
		// + " and (username like '%" + strwhere
		// + "%' or userid like '%" + strwhere + "%')",
		// page, limit);
		// // int count = userdao.teacount(colid);
		// int count = bdao
		// .selectValue("select count(userid) from VTeacher where collegeid="
		// + colid
		// + " and (username like '%"
		// + strwhere
		// + "%' or userid like '%" + strwhere + "%')");
		// LayuiData data = new LayuiData(0, "成功", count, teaList);
		// try {
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// return SUCCESS;
		// }
		//
		// } else {

		// Integer roletype = (Integer) session.getAttribute("role");
		// String search = request.getParameter("strwhere");
		// String strwhere = null;
		// if (roletype.equals(RoleType.Student)
		// || roletype.equals(RoleType.Committee)) {
		// VStudent stu = (VStudent) session.getAttribute("loginuser");
		// int classid = stu.getClassid();
		//
		// // 查询条件
		// if (search != null && !search.equals("")) {
		// strwhere = "username like '%" + strwhere
		// + "%' or classname like '%" + strwhere
		// + "%' or collegename like '%" + strwhere + "%'";
		// }
		//
		// List<VStudent> stuList = userdao.selectStuByClassPage(strwhere,
		// classid, page, limit);
		// int count = userdao.stucount(strwhere, classid);
		// ReturnData data = new ReturnData();
		// data.code = ReturnData.SUCCESS;
		// data.count = count;
		// data.data = stuList;
		// try {
		// out = response.getWriter();
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// } else if (roletype.equals(RoleType.Teacher)
		// || roletype.equals(RoleType.Organization)) {
		// VTeacher tea = (VTeacher) session.getAttribute("loginuser");
		// int colid = tea.getCollegeid();
		//
		// // 查询条件
		// if (search != null && !search.equals("")) {
		// strwhere = "username like '%" + strwhere
		// + "%' or classname like '%" + strwhere
		// + "%' or collegename like '%" + strwhere + "%'";
		// }
		//
		// List<VTeacher> teaList = userdao.selectTeaByCollPage(strwhere,
		// colid, page, limit);
		// int count = userdao.teacount(strwhere, colid);
		// LayuiData data = new LayuiData(0, "成功", count, teaList);
		// try {
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		// }

		// int roletype =
		// Integer.parseInt(session.getAttribute("role").toString());
		// String startPage = request.getParameter("page");
		// String pageSize = request.getParameter("limit");
		//
		// String proname = request.getParameter("strwhere");
		// String strwhere = null;
		// if (proname != null && !proname.equals("")) {
		// strwhere = "proname like '%" + proname + "%'";
		// }
		// int count = projectdao.getProCount(strwhere, roletype);
		// List<TProject> list = projectdao.selectByPage(strwhere, roletype,
		// Integer.parseInt(startPage), Integer.parseInt(pageSize));
		// out = response.getWriter();
		// LayuiData data = new LayuiData(0, "成功", count, list);
		// out.write(JSON.toJSONString(data));
		// out.flush();
		// out.close();
		// return null;

		int roletype = Integer
				.parseInt(session.getAttribute("role").toString());
		VStudent student = (VStudent) session.getAttribute("loginuser");
		int classid = student.getClassid();
		List<VStudent> list = userdao.selectStuByClassPage(null, classid, page,
				limit);
		int count = userdao.stucount(null, classid);
		PrintWriter out = response.getWriter();
		LayuiData data = new LayuiData();
		data.code = LayuiData.SUCCESS;
		data.count = count;
		data.data = data;
		out.write(JSON.toJSONString(data));
		out.flush();
		out.close();
		return null;
	}
}