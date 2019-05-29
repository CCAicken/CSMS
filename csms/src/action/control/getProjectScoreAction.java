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
			if (collegeid != null && !collegeid.equals("")) {
				strsearch = " where collegeid='" + collegeid + "'";
			}
			if (user != null && !user.equals("")) {
				if(strsearch.equals("")){
					if(user=="student"){
						strsearch = " where protype=1 or protype=2";
					}else{
						strsearch = " where protype=3 or protype=4";
					}
				}else{
					if(user=="student"){
						strsearch = " and protype=1 or protype=2";
					}else{
						strsearch = " and protype=3 or protype=4";
					}
				}
			}
			List<VScore> clalist = scoredao.getProjectScoreOrderByPage(strsearch, startPage, limit);
			int count = scorestudentdao.allScoreCount(strsearch);
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