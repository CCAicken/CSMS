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
	//�ɹ����ص�ҳ��
		private String requesturl;
		public String getRequesturl() {
			return requesturl;
		}
		public void setRequesturl(String requesturl) {
			this.requesturl = requesturl;
		}
	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		//��������ѧԺ��Ϣ�б�
		List<TCollege> listcollege = collegedao.select();
		request.setAttribute("listcollege", listcollege);
		if(op.equals("single")){
			requesturl = "singleScore.jsp";
		}else if(op.equals("class")){
			requesturl = "classScore.jsp";
		}else if(op.equals("college")){
			requesturl = "collegeScore.jsp";
		}else if(op.equals("project")){
			requesturl = "projectScore.jsp";
		}
		return SUCCESS;
//		//����layui���
//		if (op.equals("table")) {
//			String startPage = request.getParameter("page");// ��ʼҳ��
//			int limit = Integer.parseInt(request.getParameter("limit"));// ÿҳ��������
//			int allcount = bdao
//					.selectValue(("select count(collegeid) from TCollege"));
//			Writer out;
//			try {
//				out = response.getWriter();
//				LayuiData data = new LayuiData(0, "�ɹ�", allcount,
//						bdao.selectByPage("from TCollege",
//								Integer.parseInt(startPage), limit));
//
//				out.write(JSON.toJSONString(data));
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return SUCCESS;
//		} else if (op.equals("all")) {
//			//��������ѧԺ��Ϣ�б�
//			List<TCollege> listcollege = collegedao.select();
//			request.setAttribute("listcollege", listcollege);
//			requesturl = "singleScore";
//			return SUCCESS;
//		} else if (op.equals("byid")) {
//			//����ѧԺid���ظ�ѧԺ��Ϣ�б�
//			int collegeid  = (Integer) request.getAttribute("collegeid");
//			TCollege college = collegedao.selectByid(collegeid);
//			request.setAttribute("college", college);
//			return SUCCESS;
//		}
	}
}