package action.control;

import java.util.List;

import model.VScene;

import com.opensymphony.xwork2.ActionSupport;

public class myPeojectAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String userid = request.getParameter("userid");
		List<VScene> scenlist = scenedao.seleScenes(userid);
		request.setAttribute("scenlist", scenlist);
		return SUCCESS;
	}
}