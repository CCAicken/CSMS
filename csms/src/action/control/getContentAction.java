package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import model.TForumContent;
import model.TForumTitle;
import model.VForum;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getContentAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		// ����layui���
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
			return null;
		} else if (op.equals("byforumid")) {
			// ��������ѧԺ��Ϣ�б�
			int forumid = Integer.parseInt(request.getParameter("titleid"));
			TForumTitle forum = forumdao.getTForumById(forumid);
			List<VForum> listcontent = contentdao.getContentByForumid(forumid);
			request.setAttribute("listcontent", listcontent);
			request.setAttribute("forum", forum);
		} else if (op.equals("byid")) {
			// ����ѧԺid���ظ�ѧԺ��Ϣ�б�
			int contentid = (Integer) request.getAttribute("contentid");
			TForumContent content = contentdao.getTContnentById(contentid);
			request.setAttribute("content", content);
		}
		return SUCCESS;
	}
}