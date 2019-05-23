package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.TCollege;
import model.VClass;
import util.LayuiData;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getCollegeAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		//����layui���
		if (op.equals("table")) {
			String startPage = request.getParameter("page");// ��ʼҳ��
			int limit = Integer.parseInt(request.getParameter("limit"));// ÿҳ��������
			int allcount = bdao
					.selectValue(("select count(collegeid) from TCollege"));
			Writer out;
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "�ɹ�", allcount,
						bdao.selectByPage("from TCollege",
								Integer.parseInt(startPage), limit));

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		} else if (op.equals("all")) {
			//��������ѧԺ��Ϣ�б�
			List<TCollege> listcollege = collegedao.select();
			request.setAttribute("listcollege", listcollege);
			return SUCCESS;
		} else if (op.equals("byid")) {
			//����ѧԺid���ظ�ѧԺ��Ϣ�б�
			int collegeid  = (Integer) request.getAttribute("collegeid");
			TCollege college = collegedao.selectByid(collegeid);
			request.setAttribute("college", college);
			return SUCCESS;
		}
		return SUCCESS;
	}
}