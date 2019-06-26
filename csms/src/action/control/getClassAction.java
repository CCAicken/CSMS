package action.control;

import java.io.IOException;
import java.util.List;

import model.VClass;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getClassAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		try {
			String majorid = request.getParameter("majorid");
			if(majorid!=null && !majorid.equals("")){
				List<VClass> listclass = classesdao.selectByMajorVclass(Integer.parseInt(majorid));
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
				rd.msg = "成功";
				rd.data = listclass;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			}else{
				out.write("失败");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		String op = request.getParameter("op");
//		//返回layui表格
//		if (op.equals("table")) {
//			
//			String startPage = request.getParameter("page");// 当前
//			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
//			int allcount = bdao
//					.selectValue(("select count(forumid) from TForumTitle"));
//			Writer out;
//			try {
//				out = response.getWriter();
//				LayuiData data = new LayuiData(0, "成功", allcount,
//						bdao.selectByPage("from TForumTitle",
//								Integer.parseInt(startPage), limit));
//			
//			out.write(JSON.toJSONString(data));
//				out.flush();
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return SUCCESS;
//		} else if (op.equals("all")) {
//			
//			//返回所有班级视图信息列表
//			List<VClass> listclass = classesdao.selectVclass();
//			request.setAttribute("listclass", listclass);
//			return SUCCESS;
//		} else if (op.equals("bymajorid")) {
//			
//			//根据专业id返回所有班级视图信息列表
//			int majorid = (Integer) request.getAttribute("majorid");
//			List<VClass> listclass = classesdao.selectByMajorVclass(majorid);
//			request.setAttribute("listclass", listclass);
//			return SUCCESS;
//		}else if (op.equals("byid")) {
//			
//			//根据班级id返回该班级视图信息列表
//			int classid  = (Integer) request.getAttribute("classid");
//			VClass tclass = classesdao.selectByidVclass(classid);
//			request.setAttribute("tclass", tclass);
//			return SUCCESS;
//		}
//		return SUCCESS;
	}
}