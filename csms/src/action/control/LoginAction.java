package action.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import model.TConfig;
import model.TUser;

public class LoginAction extends BaseAction {
	private String userid;
	private String password;
	private String safecode;

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setSafecode(String safecode) {
		this.safecode = safecode;
	}

	/**
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public String execute() throws IOException {
		response.setCharacterEncoding("utf-8");
		String sRand = (String) session.getAttribute("rand");
		if (!safecode.toLowerCase().equals(sRand.toLowerCase())) {
			try {
				out.write("验证码不正确");
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			TConfig config = sportsdao.getConfig();
			if (config != null) {
				session.setAttribute("config", config);
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");// 设置日期格式
				String newDate = df.format(new Date());
				int res = config.getStarttime().compareTo(newDate);// if(res>0)
				// config.getStarttime>newDate
				int res2 = config.getEndtime().compareTo(newDate);
				if (res <= 0 && res2 >= 0) {
					session.setAttribute("sporttype", "yes");
				} else {
					session.setAttribute("sporttype", "no");
				}
			} else {
				session.setAttribute("sporttype", "no");
			}
			TUser loginuser = userdao.login(userid, password);
			if (loginuser != null) {
				session.setAttribute("loginuser", loginuser);
				out.write("登录成功");
				out.flush();
				out.close();
			} else {
				out.write("登录失败");
				out.flush();
				out.close();
			}
		}
		return null;

	}
}