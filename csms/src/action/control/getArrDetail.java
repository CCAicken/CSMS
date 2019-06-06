package action.control;

import java.util.List;

import model.VArrange;
import model.VScene;

public class getArrDetail extends BaseAction {

	/**
	 * @return
	 */
	public String execute() {
		String arrid = request.getParameter("arrid");
		if(arrid!= null && !arrid.equals("")){
			List<VScene> arrlist = arrangedao.selectById(Integer.parseInt(arrid));
			if(arrlist != null && arrlist.size()>0){
				int protype = arrangedao.getProType(Integer.parseInt(arrid));
				request.setAttribute("arrlist", arrlist);
				request.setAttribute("protype", protype);
			}
		}
		return SUCCESS;
	}
}