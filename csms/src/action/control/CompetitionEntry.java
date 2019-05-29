package action.control;

import java.io.IOException;
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
	 */
	public String execute() {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		Integer roletype = (Integer) session.getAttribute("role");
		if(roletype.equals(RoleType.Student)){
			VStudent stu = (VStudent)session.getAttribute("loginuser");
			int classid = stu.getClassid();
			List<VStudent> list = userdao.selectStuByClassPage(classid, page, limit);
			int count = userdao.stucount(classid);
			LayuiData data = new LayuiData(0, "�ɹ�", count, list);
			try {
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
			List<VTeacher> list = userdao.selectTeaByCollPage(colid, page, limit);
			int count = userdao.teacount(colid);
			LayuiData data = new LayuiData(0, "�ɹ�", count, list);
			try {
				out = response.getWriter();
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