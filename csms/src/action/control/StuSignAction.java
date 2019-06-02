package action.control;

import java.io.IOException;

public class StuSignAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if (op.equals("add")) {
			String ds = request.getParameter("datastr");
			String proid = request.getParameter("proid");
			String a[] = ds.split(",");

			int count = 0;
			for (int i = 0; i < a.length; i++) {
				count = matchdao.countUser(Integer.parseInt(proid),
						(String) a[i]);
				if (count > 0) {
					break;
				}
			}
			if (count <= 0) {
				boolean result = false;
				for (int i = 0; i < a.length; i++) {
					result = matchdao.isSignUp((String) a[i],
							Integer.parseInt(proid));
					if (result == false) {
						break;
					}
				}
				try {
					if (result) {
						out.write("报名成功");
						out.flush();
						out.close();
					} else {
						out.write("报名失败");
						out.flush();
						out.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				try {
					out.write("有同学已经报名过该项目，请认真审核后再报");
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return SUCCESS;
	}
}