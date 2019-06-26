package action.control;

import java.io.IOException;

import model.TUser;

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

			boolean result = false;
			// int result = 0;
			for (int i = 0; i < a.length; i++) {
				result = matchdao.isSignUp((String) a[i],
						Integer.parseInt(proid));
				// String procName = "up_AddMatch(" + (String) a[i] + ","
				// + Integer.parseInt(proid) + ")";
				// result = (Integer) bdao.executeProduce(procName);
				try {
					if (result) {
						out.write("�����ɹ�");
						out.flush();
						out.close();
					} else {
						out.write("����ʧ��");
						out.flush();
						out.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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