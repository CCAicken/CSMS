package action.control;

import java.io.IOException;
import java.io.PrintWriter;

import model.TConfig;
import model.TMatch;
import model.TUser;
import model.VClass;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class StuSignAction extends BaseAction {

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
						out.write("��" + userid + "�û�����ʱʧ��,���" + userid
								+ "�û����������û��������±���");
						out.flush();
						out.close();
						break;
					}
				}
				out.write("�����ɹ�");
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
						out.write("��" + userid + "�û�����ʱʧ��,���" + userid
								+ "�û����������û��������±���");
						out.flush();
						out.close();
						break;
					}
				}
				out.write("�����ɹ�");
				out.flush();
				out.close();
			}
		} else if (op.equals("islogin")) {
			TUser user = (TUser) session.getAttribute("loginuser");
			if (user != null) {
				try {
					out.write("�ѵ�¼");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					out.write("�㻹û�е�¼������������Ҫ��¼");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}