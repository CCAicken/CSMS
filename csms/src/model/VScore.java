package model;



/**
 * VScore entity. @author MyEclipse Persistence Tools
 */

public class VScore  implements java.io.Serializable {

	 private Integer scoreid;
     private Integer matchid;
     private Double scorenumber;
     private Integer proid;
     private String userid;
     private String proname;
     private Integer scenelimit;
     private Integer collegelimit;
     private Integer totallimit;
     private Integer protype;
     private String username;
     private String mobile;
     private Integer classid;
     private Integer roleid;
     private String rolename;
     private String classname;
     private Integer majorid;
     private String majorname;
     private Integer collegeid;
     private String collegename;
     private String teausername;
     private String teamobile;
     private Integer teacollegeid;
     private Integer tearoleid;
     private String tearolename;
     private String teacollegename;
     private String pwd;
     private String agend;
     private String teapwd;
     private String teaagend;
     private Integer sceneid;
     private Integer sportid;


    // Constructors

    /** default constructor */
    public VScore() {
    }

	/** minimal constructor */
    public VScore(Integer scoreid, Integer matchid, Double scorenumber, Integer proid, String userid, Integer sceneid) {
        this.scoreid = scoreid;
        this.matchid = matchid;
        this.scorenumber = scorenumber;
        this.proid = proid;
        this.userid = userid;
        this.sceneid = sceneid;
    }
    
    /** full constructor */
    public VScore(Integer scoreid, Integer matchid, Double scorenumber, Integer proid, String userid, String proname, Integer scenelimit, Integer collegelimit, Integer totallimit, Integer protype, String username, String mobile, Integer classid, Integer roleid, String rolename, String classname, Integer majorid, String majorname, Integer collegeid, String collegename, String teausername, String teamobile, Integer teacollegeid, Integer tearoleid, String tearolename, String teacollegename, String pwd, String agend, String teapwd, String teaagend, Integer sceneid, Integer sportid) {
        this.scoreid = scoreid;
        this.matchid = matchid;
        this.scorenumber = scorenumber;
        this.proid = proid;
        this.userid = userid;
        this.proname = proname;
        this.scenelimit = scenelimit;
        this.collegelimit = collegelimit;
        this.totallimit = totallimit;
        this.protype = protype;
        this.username = username;
        this.mobile = mobile;
        this.classid = classid;
        this.roleid = roleid;
        this.rolename = rolename;
        this.classname = classname;
        this.majorid = majorid;
        this.majorname = majorname;
        this.collegeid = collegeid;
        this.collegename = collegename;
        this.teausername = teausername;
        this.teamobile = teamobile;
        this.teacollegeid = teacollegeid;
        this.tearoleid = tearoleid;
        this.tearolename = tearolename;
        this.teacollegename = teacollegename;
        this.pwd = pwd;
        this.agend = agend;
        this.teapwd = teapwd;
        this.teaagend = teaagend;
        this.sceneid = sceneid;
        this.sportid = sportid;
    }

   
    // Property accessors

    public Integer getScoreid() {
        return this.scoreid;
    }
    
    public void setScoreid(Integer scoreid) {
        this.scoreid = scoreid;
    }

    public Integer getMatchid() {
        return this.matchid;
    }
    
    public void setMatchid(Integer matchid) {
        this.matchid = matchid;
    }

    public Double getScorenumber() {
        return this.scorenumber;
    }
    
    public void setScorenumber(Double scorenumber) {
        this.scorenumber = scorenumber;
    }

    public Integer getProid() {
        return this.proid;
    }
    
    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getProname() {
        return this.proname;
    }
    
    public void setProname(String proname) {
        this.proname = proname;
    }

    public Integer getScenelimit() {
        return this.scenelimit;
    }
    
    public void setScenelimit(Integer scenelimit) {
        this.scenelimit = scenelimit;
    }

    public Integer getCollegelimit() {
        return this.collegelimit;
    }
    
    public void setCollegelimit(Integer collegelimit) {
        this.collegelimit = collegelimit;
    }

    public Integer getTotallimit() {
        return this.totallimit;
    }
    
    public void setTotallimit(Integer totallimit) {
        this.totallimit = totallimit;
    }

    public Integer getProtype() {
        return this.protype;
    }
    
    public void setProtype(Integer protype) {
        this.protype = protype;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getClassid() {
        return this.classid;
    }
    
    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getClassname() {
        return this.classname;
    }
    
    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Integer getMajorid() {
        return this.majorid;
    }
    
    public void setMajorid(Integer majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return this.majorname;
    }
    
    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public Integer getCollegeid() {
        return this.collegeid;
    }
    
    public void setCollegeid(Integer collegeid) {
        this.collegeid = collegeid;
    }

    public String getCollegename() {
        return this.collegename;
    }
    
    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public String getTeausername() {
        return this.teausername;
    }
    
    public void setTeausername(String teausername) {
        this.teausername = teausername;
    }

    public String getTeamobile() {
        return this.teamobile;
    }
    
    public void setTeamobile(String teamobile) {
        this.teamobile = teamobile;
    }

    public Integer getTeacollegeid() {
        return this.teacollegeid;
    }
    
    public void setTeacollegeid(Integer teacollegeid) {
        this.teacollegeid = teacollegeid;
    }

    public Integer getTearoleid() {
        return this.tearoleid;
    }
    
    public void setTearoleid(Integer tearoleid) {
        this.tearoleid = tearoleid;
    }

    public String getTearolename() {
        return this.tearolename;
    }
    
    public void setTearolename(String tearolename) {
        this.tearolename = tearolename;
    }

    public String getTeacollegename() {
        return this.teacollegename;
    }
    
    public void setTeacollegename(String teacollegename) {
        this.teacollegename = teacollegename;
    }

    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAgend() {
        return this.agend;
    }
    
    public void setAgend(String agend) {
        this.agend = agend;
    }

    public String getTeapwd() {
        return this.teapwd;
    }
    
    public void setTeapwd(String teapwd) {
        this.teapwd = teapwd;
    }

    public String getTeaagend() {
        return this.teaagend;
    }
    
    public void setTeaagend(String teaagend) {
        this.teaagend = teaagend;
    }

    public Integer getSceneid() {
        return this.sceneid;
    }
    
    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public Integer getSportid() {
        return this.sportid;
    }
    
    public void setSportid(Integer sportid) {
        this.sportid = sportid;
    }
}