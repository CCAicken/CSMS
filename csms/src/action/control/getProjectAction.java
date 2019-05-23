package action.control;

import java.io.IOException;
import java.util.List;

import model.TProject;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getProjectAction extends BaseAction {

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