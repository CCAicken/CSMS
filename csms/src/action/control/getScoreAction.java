package action.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

import model.ReturnData;
import model.VClassScore;
import model.VScore;

import com.alibaba.fastjson.JSON;

public class getScoreAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		if(op.equals("class")){
			String startPage = request.getParameter("page");// 当前
			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
			List<VClassScore> clalist = scoreclassesdao.getAllScoreByPage(Integer.parseInt(startPage), limit);
			int count = scoreclassesdao.allScoreCount();
			try {
				ReturnData rd = new ReturnData();
				rd.code=ReturnData.SUCCESS;
				rd.count = count;
				rd.data = clalist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op.equals("classdetail")){
			try{
				String classid = request.getParameter("classid");
				if(classid!=null && !classid.equals("")){
					List<VScore> scorelist = scoredao.getByClass(Integer.parseInt(classid));
					double totalScore = scoreclassesdao.allScore(Integer.parseInt(classid));
					double avgScore = scoreclassesdao.avgScore(Integer.parseInt(classid));
					ReturnData data = new ReturnData();
					data.code = ReturnData.SUCCESS;
					data.totalScore = totalScore;
					data.avgScore = avgScore;
					data.data = scorelist;
					data.msg = "成功";
					out.write(JSON.toJSONString(data));
					out.flush();
					out.close();
				}else{
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
}