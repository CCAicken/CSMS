package action.control;

import java.io.IOException;
import java.util.List;

import model.TMajor;

import util.LayuiData;

import com.alibaba.fastjson.JSON;

public class getMajorAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		try {
			String collegeid = request.getParameter("collegeid");
			if(collegeid!=null && !collegeid.equals("")){
				List<TMajor> list = majordao.selectByColl(Integer.parseInt(collegeid));
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
				rd.msg = "³É¹¦";
				rd.data = list;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			}else{
				out.write("Ê§°Ü");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}