package action.control;

import java.io.IOException;
import java.io.Writer;

import util.LayuiData;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

public class getClassAction extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		//String startPage =request.getParameter("page");//当前
		//int limit=Integer.parseInt(request.getParameter("limit"));//条数
		//int allcount= bdao.selectValue(("select count(titleid) from TForum"));
		Writer out;
		try {
			out = response.getWriter();
			LayuiData data=new LayuiData(0, "js", 11,bdao.selectByPage("from TForumTitle", 1, 2));
			
			out.write(JSON.toJSONString(data));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return SUCCESS;
	}
}