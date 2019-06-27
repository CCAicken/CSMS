package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import model.TConfig;
import model.TMatch;
import model.TUser;
import model.VClass;
import util.ResponseJSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class SignUpAction extends BaseAction {

	/**
	 * @return
	 * @throws IOException
	 */
	public String execute() throws IOException {
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if (op.equals("add")) {
			String proid = request.getParameter("proid");
			String userinfo = request.getParameter("userinfo");

			TUser user = (TUser) session.getAttribute("loginuser");
			TConfig config = (TConfig) session.getAttribute("config");
			TMatch match = new TMatch();
			match.setSportid(config.getSportid());
			match.setProid(Integer.parseInt(proid));

			JSONArray json = JSON.parseArray(userinfo);
			PrintWriter out = response.getWriter();
			if (user.getUsertype() == 0) {
				for (int i = 0; i < json.size(); i++) {
					String userid = json.getJSONObject(i).get("userid")
							.toString();
					String username = json.getJSONObject(i).get("username")
							.toString();
					VClass userclass = classesdao.selectByidVclass(user
							.getUserregion());
					match.setClassid(user.getUserregion());
					match.setCollegeid(userclass.getCollegeid());
					match.setUserid(userid);
					match.setUsername(username);
					boolean result = matchdao.insert(match);
					if (result == false) {
						out.write("对" + userid + "用户报名时失败,请对" + userid
								+ "用户及其后面的用户进行重新报名");
						out.flush();
						out.close();
						break;
					}
				}
				ResponseJSON data = new ResponseJSON();
				data.flag = ResponseJSON.FLAG_SUCC;
				data.msg = "报名成功";
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} else if (user.getUsertype() == 1) {
				for (int i = 0; i < json.size(); i++) {
					String userid = json.getJSONObject(i).get("userid")
							.toString();
					String username = json.getJSONObject(i).get("username")
							.toString();
					match.setClassid(0);
					match.setCollegeid(user.getUserregion());
					match.setUserid(userid);
					match.setUsername(username);
					boolean result = matchdao.insert(match);
					if (result == false) {
						out.write("对" + userid + "用户报名时失败,请对" + userid
								+ "用户及其后面的用户进行重新报名");
						out.flush();
						out.close();
						break;
					}

				}
				ResponseJSON data = new ResponseJSON();
				data.flag = ResponseJSON.FLAG_SUCC;
				data.msg = "报名成功";
				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			}
		}
		return SUCCESS;
	}
}