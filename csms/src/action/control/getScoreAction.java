package action.control;

import java.util.List;

import model.VClass;
import model.VCollegeScore;
import model.VStudent;
import model.VStudentScore;

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
			List<VClass> clalist = scoreclassesdao.getAllScoreClasses();
			request.setAttribute("clalist", clalist);
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