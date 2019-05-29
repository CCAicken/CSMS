package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import util.LayuiData;
import model.TArrange;
import model.VScene;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getArrangeAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		// ��ȡѧԺ��Ϣ�Ͱ༶רҵ��Ϣ

		String op = request.getParameter("op");
		if (op.equals("load")) {
			String startPage = request.getParameter("page");// ��ǰ
			int limit = Integer.parseInt(request.getParameter("limit"));// ����
			int allcount = bdao
					.selectValue(("select count(sceneid) from VScene"));
			Writer out;
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "�ɹ�", allcount,
						bdao.selectByPage("from VScene",
								Integer.parseInt(startPage), limit));

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
}