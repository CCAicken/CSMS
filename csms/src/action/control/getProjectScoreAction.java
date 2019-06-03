package action.control;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import model.ReturnData;
import model.VClassScore;
import model.VScore;

import com.alibaba.fastjson.JSON;

public class getProjectScoreAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		try{
			int startPage = Integer.parseInt(request.getParameter("page"));// 当前
			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
			String collegeid = request.getParameter("collegeid");
			String user = request.getParameter("user");
			String strsearch = "";
			if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
				if(user.equals("student")){
					strsearch = " where collegeid='" + collegeid + "'";
				}else{
					strsearch = " where teacollegeid='" + collegeid + "'";
				}
			}
			if (user != null && !user.equals("") && !user.equals("0")) {
				if(strsearch.equals("")){
					if(user.equals("student")){
						strsearch = " where protype=1 or protype=2";
					}else{
						strsearch = " where protype=3 or protype=4";
					}
				}else{
					if(user.equals("student")){
						strsearch += " and (protype=1 or protype=2)";
					}else{
						strsearch += " and (protype=3 or protype=4)";
					}
				}
			}
			List<VScore> clalist = scoredao.getScoreByPage(strsearch, startPage, limit);
			int count = scoredao.allScoreCount(strsearch);
			request.setAttribute("type", "project");
			ReturnData rd = new ReturnData();
			rd.code = ReturnData.SUCCESS;
			rd.count = count;
			rd.data = clalist;
			out.write(JSON.toJSONString(rd));
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}