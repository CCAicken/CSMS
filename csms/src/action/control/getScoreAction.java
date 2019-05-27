package action.control;

import java.io.IOException;
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
			String classid = request.getParameter("classid");
			if(classid!=null && !classid.equals("")){
				List<VScore> scorelist = scoredao.getByClass(Integer.parseInt(classid));
				request.setAttribute("scorelist", scorelist);
				return SUCCESS;
			}else{
				try {
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return SUCCESS;
	}
}