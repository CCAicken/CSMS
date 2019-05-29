package action.control;

import java.io.IOException;
import java.util.List;

import model.TStudent;
import model.TTeacher;
import model.VStudent;
import model.VTeacher;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import common.properties.RoleType;


public class CompetitionEntry extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String proid = request.getParameter("proid");
		String startpage = request.getParameter("page");
		String pagesize = request.getParameter("limit");
		String roletype = session.getAttribute("role").toString();
		if(roletype.equals(RoleType.Student)){
			TStudent stu = (TStudent)session.getAttribute("loginuser");
			String classid = stu.getClassid().toString();
			List<VStudent> list = userdao.selectStuByClassPage(classid, Integer.parseInt(startpage), Integer.parseInt(pagesize));
			Object[] param = {classid};
			int count = bdao.selectValue("select count(*) from TStudent where classid=?", param);
			System.out.println(count);
			LayuiData data = new LayuiData(0, "成功", count, list);
			try {
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(roletype.equals(RoleType.Teacher)){
			TTeacher tea = (TTeacher) session.getAttribute("loginuser");
			String colid = tea.getCollegeid().toString();
			List<VTeacher> list = userdao.selectTeaByCollPage(colid, Integer.parseInt(startpage), Integer.parseInt(pagesize));
			Object[] param = {colid};
			int count = bdao.selectValue("select count(*) from VTeacher where collegeid=?", param);
			System.out.println(count);
			LayuiData data = new LayuiData(0, "成功", count, list);
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