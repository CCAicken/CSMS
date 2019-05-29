package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
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
	 */
	public String execute() {
		response.setCharacterEncoding("utf-8");
		Integer roletype = (Integer) session.getAttribute("role");
		if(roletype.equals(RoleType.Student)){
			VStudent stu = (VStudent) session.getAttribute("loginuser");
			int classid = stu.getClassid();
//			Object[] para = {classid};
//			List<VStudent> stuList = (List<VStudent>)bdao.selectByPage("form VStudent where classid=?", para, page, limit);
			List<VStudent> stuList = userdao .selectStuByClassPage(classid, page, limit);
			int count = userdao.stucount(classid);
			//LayuiData data = new LayuiData(0, "成功", count, stuList);
			ReturnData data = new ReturnData();
			data.code=ReturnData.SUCCESS;
			data.count = count;
			data.data = stuList;
			try {
				out = response.getWriter();
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(roletype.equals(RoleType.Teacher)){
			VTeacher tea = (VTeacher) session.getAttribute("loginuser");
			int colid = tea.getCollegeid();
			//List<VTeacher> teaList = userdao.selectTeaByCollPage(colid, page, limit);
			Object[] para = {colid};
			List<VTeacher> teaList = bdao.selectByPage("from VTeacher where collegeid=?", para,page,limit);
//			int count = userdao.teacount(colid);
			int count = bdao.selectValue("select count(userid) from VTeacher where collegeid=?", para);
			LayuiData data = new LayuiData(0, "成功", count, teaList);
			try {
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
}