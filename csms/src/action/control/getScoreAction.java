package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
import model.VClassScore;

import com.alibaba.fastjson.JSON;



public class getScoreAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String startPage = request.getParameter("page");// ��ǰ
		int limit = Integer.parseInt(request.getParameter("limit"));// ����
		List<VClassScore> clalist = scoreclassesdao.getAllScoreByPage(Integer.parseInt(startPage), limit);
		int count = scoreclassesdao.allScoreCount();
//		LayuiData data = new LayuiData(0, "�ɹ�", count, clalist);
		try {
			ReturnData rd = new ReturnData();
			rd.code=ReturnData.SUCCESS;
			rd.count = count;
			rd.data = clalist;
			out.write(JSON.toJSONString(rd));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}