package action.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.LayuiData;
import model.MedalRank;
import model.TClass;
import model.TCollege;
import model.TConfig;
import model.TMajor;
import model.VClassScore;
import model.VCollegeScore;
import model.VMajorScore;
import model.VScore;
import model.VUserScore;

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
			List<MedalRank> ranklist = scoredao.getRank();
			List<MedalRank> newlist = new ArrayList<MedalRank>();
			if(ranklist.size()>6){
				for(int i=0;i<6;i++){
					newlist.add(ranklist.get(i));
				}
			}else{
				newlist = ranklist;
			}
			//����
			Collections.sort(newlist, new Comparator<MedalRank>(){
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
				rd.data = newlist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("getallscore")){
			List<TConfig> sportlist = sportsdao.select();
			//����
			Collections.sort(sportlist, new Comparator<TConfig>(){
				@Override
				public int compare(TConfig config1, TConfig config2){
					Integer id1 = config1.getSportid();
					Integer id2 = config2.getSportid();
					return id1.compareTo(id2);//����
					//id2.compareTo(id1)//����
				}
			});
			List<VScore> scorelist = scoredao.getAllCollScore();
			List<double[]> returnlist = new ArrayList<double[]>();
			for(int i=0;i<sportlist.size();i++){
				double[] doubles = new double[scorelist.size()];
				for(int j=0;j<scorelist.size();j++){
					if(sportlist.get(i).getSportid().equals(scorelist.get(j).getSportid())){
						doubles[j] = scorelist.get(j).getScorenumber();
					}else{
						doubles[j] = 0;
					}
				}
				returnlist.add(doubles);
			}
			try {
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
				rd.data = returnlist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("allcollege")) {
			List<VCollegeScore> clalist = scorecollegedao.getAllCollegeScore();
			try {
				LayuiData rd = new LayuiData();
				rd.code = LayuiData.SUCCESS;
				rd.data = clalist;
				out.write(JSON.toJSONString(rd));
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("college")) {
			startPage = Integer.parseInt(request.getParameter("page"));// ��ǰ
			limit = Integer.parseInt(request.getParameter("limit"));// ����
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
					out.write("��ˢ�º����ԣ�");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("major")) {
			try {
				startPage = Integer.parseInt(request.getParameter("page"));// ��ǰ
				limit = Integer.parseInt(request.getParameter("limit"));// ����
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
					out.write("��ˢ�º����ԣ�");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if (op.equals("class")) {
			try {
				startPage = Integer.parseInt(request.getParameter("page"));// ��ǰ
				limit = Integer.parseInt(request.getParameter("limit"));// ����
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
					out.write("��ˢ�º����ԣ�");
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (op.equals("single")) {
			startPage = Integer.parseInt(request.getParameter("page"));// ��ǰ
			limit = Integer.parseInt(request.getParameter("limit"));// ����
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
			List<VUserScore> stulist = scoredao.getAllScoreByPage(strsearch,startPage, limit);
			int count = scoredao.allUserScoreCount(strsearch);
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
				String username = request.getParameter("username");
				String avgscore = request.getParameter("avgscore");
				String sumscore = request.getParameter("sumscore");
				if (userid != null && !userid.equals("")) {
					List<VScore> scorelist = scoredao.getByUser(userid);
					request.setAttribute("scorelist", scorelist);
					request.setAttribute("totalScore", sumscore);
					request.setAttribute("avgScore", avgscore);
					request.setAttribute("title", username);
					request.setAttribute("type", "single");
					return SUCCESS;
				} else {
					out.write("��ˢ�º����ԣ�");
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