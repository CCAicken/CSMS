package action.control;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import util.LayuiData;

import com.alibaba.fastjson.JSON;

import model.VMatch;
import model.VScore;

public class getApplication extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
	String op=	request.getParameter("op");
		if(op.equals("score")){
			List<VScore> scorelist=scoredao.getCollegeScoreOrder();
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "成功", 2, scorelist);

				out.write(JSON.toJSONString(data));
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}else {
			List<VMatch> list = matchdao.selectAll();
			try {
				out = response.getWriter();
				LayuiData data = new LayuiData(0, "成功", 2, list);

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
}