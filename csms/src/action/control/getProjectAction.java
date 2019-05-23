package action.control;

import java.io.IOException;
import java.util.List;

import model.TProject;
import model.VScene;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getProjectAction extends BaseAction {
	private String userid;
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return
	 * @throws IOException 
	 */
	public String execute() throws IOException {
		List<TProject> prolist = projectdao.select();
		out.write(JSON.toJSONString(prolist));
		return SUCCESS;
	}
}