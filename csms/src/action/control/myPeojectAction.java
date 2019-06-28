package action.control;

import java.io.IOException;
import java.util.List;

import model.VMatch;
import util.Expression;
import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class myPeojectAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String startPage = request.getParameter("page");
		String pageSize = request.getParameter("limit");
		String collegeid = request.getParameter("collegeid");
		String majorid = request.getParameter("majorid");
		String classid = request.getParameter("classid");
		String roletype = request.getParameter("roletype");
		String userid = request.getParameter("userid");
		Expression exp = new Expression();
		// 查询条件
		if (collegeid != null && !collegeid.equals("0")
				&& !collegeid.equals("")) {
			// strwhere = " and collegeid=" + collegeid;
			exp.andEqu("collegeid", collegeid, String.class);
		}
		if (majorid != null && !majorid.equals("0") && !majorid.equals("")) {
			// strwhere += " and majorid=" + majorid;
			exp.andEqu("majorid", majorid, String.class);
		}
		if (classid != null && !classid.equals("0") && !classid.equals("")) {
			// strwhere += " and classid=" + classid;
			exp.andEqu("classid", classid, String.class);
		}
		if (userid != null && !userid.equals("0") && !userid.equals("")) {
			// strwhere += " and classid=" + classid;
			exp.andLike("userid", userid, String.class);
		}
		// 角色判断
		// if (roletype.equals("教职工")) {
		// exp.orEqu("protype", 3, Integer.class);
		// exp.orEqu("protype", 4, Integer.class);
		// }
		// if (roletype.equals("学生")) {
		// exp.orEqu("protype", 1, Integer.class);
		// exp.orEqu("protype", 2, Integer.class);
		// }
		String strwhere = exp.toString();
		if (roletype != "" && roletype != null) {
			if (strwhere != null && !strwhere.equals("")) {
				if (roletype.equals("教职工")) {
					strwhere += " and (protype = 3  or protype = 4)";
				}
				if (roletype.equals("学生")) {
					strwhere += " and (protype = 1  or protype = 2)";
				}
			} else {
				if (roletype.equals("教职工")) {
					strwhere += " where (protype = 3  or protype = 4)";
				}
				if (roletype.equals("学生")) {
					strwhere += " where (protype = 1  or protype = 2)";
				}
			}
		}
		List<VMatch> list = matchdao.getByid(strwhere,
				Integer.parseInt(startPage), Integer.parseInt(pageSize));
		int count = matchdao.getByidCount(strwhere);
		LayuiData data = new LayuiData(0, "成功", count, list);
		try {
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}