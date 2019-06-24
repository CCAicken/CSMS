package action.control;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import model.ReturnData;
import model.TProject;
import model.VProject;
import model.VClassScore;
import model.VScore;

import com.alibaba.fastjson.JSON;

public class getProjectScoreAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		try{
			String op = request.getParameter("op");
			if(op.equals("prodetail")){
				String proid = request.getParameter("proid");
				if(proid!=null && !proid.equals("")){
					List<VScore> proscorelist = scoredao.getScoreByProSingle(Integer.parseInt(proid));
					request.setAttribute("proscorelist", proscorelist);
					TProject project = projectdao.getptoject(Integer.parseInt(proid));
					request.setAttribute("project", project);
					return SUCCESS;
				}
			}else if(op.equals("record")){
				String project = request.getParameter("project");
				String user = request.getParameter("usertype");
				String strsearch = "";
				if (project != null && !project.equals("") && !project.equals("0")) {
					if(strsearch!=null && !strsearch.equals("")){
						strsearch = " where proid=" + project;
					}else{
						strsearch += " and proid=" + project;
					}
				}
				if (user != null && !user.equals("") && !user.equals("0")) {
					if(user.equals("stusingle")){
						if(strsearch!=null && !strsearch.equals("")){
							strsearch = " where protype=1";
						}else{
							strsearch += " and protype=1";
						}
					}else if(user.equals("stuteam")){
						if(strsearch!=null && !strsearch.equals("")){
							strsearch = " where protype=2";
						}else{
							strsearch += " and protype=2";
						}
					}else if(user.equals("teasingle")){
						if(strsearch!=null && !strsearch.equals("")){
							strsearch = " where protype=3";
						}else{
							strsearch += " and protype=3";
						}
					}else if(user.equals("teateam")){
						if(strsearch!=null && !strsearch.equals("")){
							strsearch = " where protype=4";
						}else{
							strsearch += " and protype=4";
						}
					}
				}
				List<VProject> clalist = scoredao.selectList(strsearch);
				request.setAttribute("type", "project");
				ReturnData rd = new ReturnData();
				rd.code = ReturnData.SUCCESS;
				rd.data = clalist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			}else if(op.equals("load")){
				String project = request.getParameter("project");
				String user = request.getParameter("usertype");
				String strsearch = "";
				if (project != null && !project.equals("") && !project.equals("0")) {
					strsearch = " and proid=" + project;
				}
				if (user != null && !user.equals("") && !user.equals("0")) {
					if(user.equals("stusingle")){
						strsearch = " and protype=1";
					}else if(user.equals("stuteam")){
						strsearch = " and protype=2";
					}else if(user.equals("teasingle")){
						strsearch = " and protype=3";
					}else if(user.equals("teateam")){
						strsearch = " and protype=4";
					}
				}
				List<VScore> clalist = scoredao.getScore(strsearch);
				request.setAttribute("type", "project");
				ReturnData rd = new ReturnData();
				rd.code = ReturnData.SUCCESS;
				rd.data = clalist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}