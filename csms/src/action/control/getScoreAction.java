package action.control;

import java.io.IOException;
import java.util.List;

import model.VClass;
import model.VCollegeScore;
import model.VStudent;
import model.VStudentScore;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import common.properties.RoleType;



public class getScoreAction extends BaseAction {
	private String classes;
	private String college;
	private String personal;
	
	public void setClasses(String classes) {
		this.classes = classes;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	/**
	 * @return
	 */
	public String execute() {
		if(!classes.equals("")){
			String startPage = request.getParameter("page");// 当前
			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
			List<VClass> clalist = scoreclassesdao.getClassesByPage(Integer.parseInt(startPage), limit);
			int count = bdao.selectValue("select count(classid) as count from(select collegeid,collegename,majorid,majorname,classid,classname,ROUND(AVG(scorenumber), 2) as scorenumber from V_StudentScore GROUP BY classid,classname,collegeid,collegename,majorid,majorname) as temp");
			LayuiData data = new LayuiData(0, "成功", count, clalist);
			try {
				out.write(JSON.toJSONString(clalist));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(!college.equals("")){
			List<VCollegeScore> collist = scorecollegedao.getAllCollegeScore();
			request.setAttribute("collists", collist);
		}
		else if(!personal.equals("")){
			int roletype = (Integer) session.getAttribute("role");
			if(roletype==RoleType.Student){
				VStudent stu = (VStudent) session.getAttribute("loginuser");
				VStudentScore vstulist =  scorestudentdao.getByUserid(stu.getUserid());
			}
		}
		return SUCCESS;
	}
}