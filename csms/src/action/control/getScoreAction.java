package action.control;

import java.io.IOException;
import java.util.List;

import model.ReturnData;
import model.TClass;
import model.TCollege;
import model.TMajor;
import model.VClassScore;
import model.VCollegeScore;
import model.VScore;
import model.VStudent;
import model.VStudentScore;
import model.VTeacher;

import com.alibaba.fastjson.JSON;

public class getScoreAction extends BaseAction {
	private String collegeid = "", majorid = "", classid = "", strsearch = "";
	private int startPage = 1, limit = 1;

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		if (op.equals("college")) {
			startPage = Integer.parseInt(request.getParameter("page"));// 当前
			limit = Integer.parseInt(request.getParameter("limit"));// 条数
			collegeid = request.getParameter("collegeid");
			if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
				strsearch = " where collegeid='" + collegeid + "'";
			}
			List<VCollegeScore> clalist = scorecollegedao.getAllScoreByPage(
					strsearch, startPage, limit);
			int count = scorecollegedao.geAllCount(strsearch);
			try {
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
		} else if (op.equals("collegedetail")) {
			try {
				String collegeid = request.getParameter("collegeid");
				if (collegeid != null && !collegeid.equals("")) {
					TCollege college = (TCollege) bdao.findById(TCollege.class,
							Integer.parseInt(collegeid));
					List<VScore> scorelist = scoredao.getByCollege(Integer
							.parseInt(collegeid));
					if (scorelist != null && scorelist.size() > 0) {
						double stuTotalScore = scorecollegedao
								.allStuScore(Integer.parseInt(collegeid));
						double stuAvgScore = scorecollegedao
								.avgStuScore(Integer.parseInt(collegeid));
						double teaTotalScore = scorecollegedao
								.allTeaScore(Integer.parseInt(collegeid));
						double teaAvgScore = scorecollegedao
								.avgTeaScore(Integer.parseInt(collegeid));
						request.setAttribute("teacher", "none");
						for (VScore score : scorelist) {
							if (score.getProtype() == 3
									|| score.getProtype() == 4) {
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
					} else {
						request.setAttribute("scorelist", null);
						request.setAttribute("stuTotalScore", 0);
						request.setAttribute("stuAvgScore", 0);
						request.setAttribute("teaTotalScore", 0);
						request.setAttribute("teaAvgScore", 0);
						request.setAttribute("title", college.getCollegename());
						request.setAttribute("type", "college");
					}
					return SUCCESS;
				} else {
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("major")) {
			try {
				startPage = Integer.parseInt(request.getParameter("page"));// 当前
				limit = Integer.parseInt(request.getParameter("limit"));// 条数
				collegeid = request.getParameter("collegeid");
				majorid = request.getParameter("majorid");
				if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
					strsearch = " and collegeid='" + collegeid + "'";
				}
				if (majorid != null && !majorid.equals("") && !majorid.equals("0")) {
					strsearch = " and majorid='" + majorid + "'";
				}
				List<VScore> clalist = scoredao.getScoreByPage(strsearch, startPage, limit);
				int count = scoredao.allScoreCount(strsearch);
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
		} else if (op.equals("majordetail")) {
			try {
				majorid = request.getParameter("majorid");
				if (majorid != null && !majorid.equals("")) {
					TMajor tmajor = (TMajor) bdao.findById(TMajor.class,
							Integer.parseInt(majorid));
					List<VScore> scorelist = scoredao.getByClass(Integer
							.parseInt(majorid));
					double totalScore = scoreclassesdao.allScore(Integer
							.parseInt(majorid));
					double avgScore = scoreclassesdao.avgScore(Integer
							.parseInt(majorid));
					request.setAttribute("scorelist", scorelist);
					request.setAttribute("totalScore", totalScore);
					request.setAttribute("avgScore", avgScore);
					request.setAttribute("title", tmajor.getMajorname());
					request.setAttribute("type", "major");
					return SUCCESS;
				} else {
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("class")) {
			try {
				startPage = Integer.parseInt(request.getParameter("page"));// 当前
				limit = Integer.parseInt(request.getParameter("limit"));// 条数
				collegeid = request.getParameter("collegeid");
				majorid = request.getParameter("majorid");
				classid = request.getParameter("classid");
				if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
					strsearch = " where collegeid='" + collegeid + "'";
				}
				if (majorid != null && !majorid.equals("") && !majorid.equals("0")) {
					strsearch = " where majorid='" + majorid + "'";
				}
				if (classid != null && !classid.equals("") && !classid.equals("0")) {
					strsearch = " where classid='" + classid + "'";
				}
				List<VClassScore> clalist = scoreclassesdao.getAllScoreByPage(strsearch, startPage, limit);
				int count = scoreclassesdao.allScoreCount(strsearch);
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
		} else if (op.equals("classdetail")) {
			try {
				String classid = request.getParameter("classid");
				if (classid != null && !classid.equals("")) {
					TClass tclass = (TClass) bdao.findById(TClass.class,
							Integer.parseInt(classid));
					List<VScore> scorelist = scoredao.getByClass(Integer
							.parseInt(classid));
					double totalScore = scoreclassesdao.allScore(Integer
							.parseInt(classid));
					double avgScore = scoreclassesdao.avgScore(Integer
							.parseInt(classid));
					request.setAttribute("scorelist", scorelist);
					request.setAttribute("totalScore", totalScore);
					request.setAttribute("avgScore", avgScore);
					request.setAttribute("title", tclass.getClassname());
					request.setAttribute("type", "class");
					return SUCCESS;
				} else {
					out.write("请刷新后重试！");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (op.equals("single")) {
			startPage = Integer.parseInt(request.getParameter("page"));// 当前
			limit = Integer.parseInt(request.getParameter("limit"));// 条数
			collegeid = request.getParameter("collegeid");
			majorid = request.getParameter("majorid");
			classid = request.getParameter("classid");
			if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
				strsearch = " and collegeid='" + collegeid + "'";
			}
			if (majorid != null && !majorid.equals("") && !majorid.equals("0")) {
				strsearch = " and majorid='" + majorid + "'";
			}
			if (classid != null && !classid.equals("") && !classid.equals("0")) {
				strsearch = " and classid='" + classid + "'";
			}
			List<VScore> stulist = scorestudentdao.getAllScoreByPage(strsearch,
					startPage, limit);
			int count = scoredao.allScoreCount(strsearch);
			try {
				ReturnData rd = new ReturnData();
				rd.code = ReturnData.SUCCESS;
				rd.count = count;
				rd.data = stulist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (op.equals("singledetail")) {
			try {
				String userid = request.getParameter("userid");
				String usertype = request.getParameter("usertype");
				if (userid != null && !userid.equals("") && usertype != null
						&& !usertype.equals("")) {
					if (usertype.equals("1")) {
						VStudent student = userdao.getStudent(userid);
						List<VScore> scorelist = scorestudentdao
								.getScoreStudent(userid);
						double totalScore = scorestudentdao.allScore(userid);
						double avgScore = scorestudentdao.avgScore(userid);
						request.setAttribute("scorelist", scorelist);
						request.setAttribute("totalScore", totalScore);
						request.setAttribute("avgScore", avgScore);
						request.setAttribute("title", student.getUsername());
						request.setAttribute("type", "single");
					} else {
						VTeacher teacher = userdao.getTeacher(userid);
						List<VScore> scorelist = scorestudentdao
								.getScoreStudent(userid);
						double totalScore = scorestudentdao.allScore(userid);
						double avgScore = scorestudentdao.avgScore(userid);
						request.setAttribute("scorelist", scorelist);
						request.setAttribute("totalScore", totalScore);
						request.setAttribute("avgScore", avgScore);
						request.setAttribute("title", teacher.getUsername());
						request.setAttribute("type", "single");
					}
					return SUCCESS;
				} else {
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