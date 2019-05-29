package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
import model.TClass;
import model.TCollege;
import model.VClassScore;
import model.VCollegeScore;
import model.VScore;
import model.VStudent;
import model.VStudentScore;
import model.VTeacher;

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
					TClass tclass = (TClass)bdao.findById(TClass.class, Integer.parseInt(classid));
					List<VScore> scorelist = scoredao.getByClass(Integer.parseInt(classid));
					double totalScore = scoreclassesdao.allScore(Integer.parseInt(classid));
					double avgScore = scoreclassesdao.avgScore(Integer.parseInt(classid));
					request.setAttribute("scorelist", scorelist);
					request.setAttribute("totalScore", totalScore);
					request.setAttribute("avgScore", avgScore);
					request.setAttribute("title", tclass.getClassname());
					request.setAttribute("type", "class");
					return SUCCESS;
				}else{
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op.equals("college")){
			String startPage = request.getParameter("page");// 当前
			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
			List<VCollegeScore> clalist = scorecollegedao.getAllScoreByPage(Integer.parseInt(startPage),limit);
			int count = scorecollegedao.geDataCount();
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
		}else if(op.equals("collegedetail")){
			try{
				String collegeid = request.getParameter("collegeid");
				if(collegeid!=null && !collegeid.equals("")){
					TCollege college = (TCollege)bdao.findById(TCollege.class, Integer.parseInt(collegeid));
					List<VScore> scorelist = scoredao.getByCollege(Integer.parseInt(collegeid));
					if(scorelist!=null && scorelist.size()>0){
						double stuTotalScore = scorecollegedao.allStuScore(Integer.parseInt(collegeid));
						double stuAvgScore = scorecollegedao.avgStuScore(Integer.parseInt(collegeid));
						double teaTotalScore = scorecollegedao.allTeaScore(Integer.parseInt(collegeid));
						double teaAvgScore = scorecollegedao.avgTeaScore(Integer.parseInt(collegeid));
						request.setAttribute("teacher", "none");
						for(VScore score:scorelist){
							if(score.getProtype() == 3||score.getProtype()==4){
								request.setAttribute("teacher", "have");
								break;
							}
						}
						request.setAttribute("scorelist", scorelist);
						request.setAttribute("stuTotalScore", stuTotalScore);
						request.setAttribute("stuAvgScore", stuAvgScore);
						request.setAttribute("teaTotalScore", teaTotalScore);
						request.setAttribute("teaAvgScore", teaAvgScore);
						request.setAttribute("title", college.getCollegename());
						request.setAttribute("type", "college");
					}else{
						request.setAttribute("scorelist", null);
						request.setAttribute("stuTotalScore", 0);
						request.setAttribute("stuAvgScore", 0);
						request.setAttribute("teaTotalScore", 0);
						request.setAttribute("teaAvgScore", 0);
						request.setAttribute("title", college.getCollegename());
						request.setAttribute("type", "college");
					}
					return SUCCESS;
				}else{
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op.equals("single")){
			String startPage = request.getParameter("page");// 当前
			int limit = Integer.parseInt(request.getParameter("limit"));// 条数
			List<VScore> stulist = scorestudentdao.getAllScoreByPage(Integer.parseInt(startPage),limit);
			int count = scorestudentdao.allScoreCount();
			try {
				ReturnData rd = new ReturnData();
				rd.code=ReturnData.SUCCESS;
				rd.count = count;
				rd.data = stulist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op.equals("singledetail")){
			try{
				String userid = request.getParameter("userid");
				String usertype = request.getParameter("usertype");
				if(userid!=null && !userid.equals("") && usertype!=null && !usertype.equals("")){
					if(usertype.equals("1")){
						VStudent student = userdao.getStudent(userid);
						List<VScore> scorelist = scorestudentdao.getScoreStudent(userid);
						double totalScore = scorestudentdao.allScore(userid);
						double avgScore = scorestudentdao.avgScore(userid);
						request.setAttribute("scorelist", scorelist);
						request.setAttribute("totalScore", totalScore);
						request.setAttribute("avgScore", avgScore);
						request.setAttribute("title", student.getUsername());
						request.setAttribute("type", "single");
					}else{
						VTeacher teacher = userdao.getTeacher(userid);
						List<VScore> scorelist = scorestudentdao.getScoreStudent(userid);
						double totalScore = scorestudentdao.allScore(userid);
						double avgScore = scorestudentdao.avgScore(userid);
						request.setAttribute("scorelist", scorelist);
						request.setAttribute("totalScore", totalScore);
						request.setAttribute("avgScore", avgScore);
						request.setAttribute("title", teacher.getUsername());
						request.setAttribute("type", "single");
					}
					return SUCCESS;
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