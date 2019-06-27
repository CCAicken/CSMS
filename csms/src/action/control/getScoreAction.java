package action.control;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.LayuiData;
import model.MedalRank;
import model.TClass;
import model.TCollege;
import model.TMajor;
import model.VClassScore;
import model.VCollegeScore;
import model.VMajorScore;
import model.VScore;
import business.factory.DAOFactory;

import com.alibaba.fastjson.JSON;

public class getScoreAction extends BaseAction {
	private String collegeid = "", majorid = "", classid = "", strsearch = "";
	private int startPage = 1, limit = 1;

	/**
	 * @return
	 */
	public String execute() {
		String op = request.getParameter("op");
		if (op.equals("getrank")){
			List<MedalRank> ranklist = DAOFactory.getScoreDAO().getRank();
			Collections.sort(ranklist, new Comparator<MedalRank>(){
				@Override
				public int compare(MedalRank rank1, MedalRank rank2){
					Integer gold1 = rank1.getGold();
					Integer gold2 = rank2.getGold();
					return gold2.compareTo(gold1);
				}
			});
			try {
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
				rd.data = ranklist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("college")) {
			startPage = Integer.parseInt(request.getParameter("page"));// 当前
			limit = Integer.parseInt(request.getParameter("limit"));// 条数
			collegeid = request.getParameter("collegeid");
			if (collegeid != null && !collegeid.equals("") && !collegeid.equals("0")) {
				strsearch = " and collegeid='" + collegeid + "'";
			}
			List<VCollegeScore> clalist = scorecollegedao.getAllScoreByPage(
					strsearch, startPage, limit);
			int count = scorecollegedao.geAllCount(strsearch);
			try {
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
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
				List<VMajorScore> clalist = majordao.getAllScoreByPage(strsearch, startPage, limit);
				int count = majordao.allScoreCount(strsearch);
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
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
					strsearch = " and collegeid='" + collegeid + "'";
				}
				if (majorid != null && !majorid.equals("") && !majorid.equals("0")) {
					strsearch = " and majorid='" + majorid + "'";
				}
				if (classid != null && !classid.equals("") && !classid.equals("0")) {
					strsearch = " and classid='" + classid + "'";
				}
				List<VClassScore> clalist = scoreclassesdao.getAllScoreByPage(strsearch, startPage, limit);
				int count = scoreclassesdao.allScoreCount(strsearch);
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
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
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
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
					//TUser user = userdao.getStudent(userid);
					List<VScore> scorelist = scoredao.getByUser(userid);
					double totalScore = scorestudentdao.allScore(userid);
					double avgScore = scorestudentdao.avgScore(userid);
					request.setAttribute("scorelist", scorelist);
					request.setAttribute("totalScore", totalScore);
					request.setAttribute("avgScore", avgScore);
					//request.setAttribute("title", user.getUsername());
					request.setAttribute("type", "single");
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
		return null;
	}
}