package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import model.TUser;

public class ChangePwdAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		PrintWriter out;
		try {
			out = response.getWriter();
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			String userid = request.getParameter("userid");

			boolean result = userdao.changePwd(userid, oldpwd, newpwd);
			if (result) {
				TUser user = userdao.login(userid, newpwd);
				session.setAttribute("loginuser", user);
				out.write("√‹¬Î–ﬁ∏ƒ≥…π¶");
				out.flush();
				out.close();
			} else {
				out.write("√‹¬Î–ﬁ∏ƒ ß∞‹");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}