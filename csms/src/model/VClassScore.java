package model;



/**
 * VClassScore entity. @author MyEclipse Persistence Tools
 */

public class VClassScore  implements java.io.Serializable {

	private Integer classid;
    private String collegename;
    private String majorname;
    private String classname;
    private Double scorenumber;
    private Integer sportid;


   // Constructors

   /** default constructor */
   public VClassScore() {
   }

	/** minimal constructor */
   public VClassScore(String majorname) {
       this.majorname = majorname;
   }
   
   /** full constructor */
   public VClassScore(Integer classid, String collegename, String majorname, String classname, Double scorenumber, Integer sportid) {
       this.classid = classid;
       this.collegename = collegename;
       this.majorname = majorname;
       this.classname = classname;
       this.scorenumber = scorenumber;
       this.sportid = sportid;
   }

  
   // Property accessors

   public Integer getClassid() {
       return this.classid;
   }
   
   public void setClassid(Integer classid) {
       this.classid = classid;
   }

   public String getCollegename() {
       return this.collegename;
   }
   
   public void setCollegename(String collegename) {
       this.collegename = collegename;
   }

   public String getMajorname() {
       return this.majorname;
   }
   
   public void setMajorname(String majorname) {
       this.majorname = majorname;
   }

   public String getClassname() {
       return this.classname;
   }
   
   public void setClassname(String classname) {
       this.classname = classname;
   }

   public Double getScorenumber() {
       return this.scorenumber;
   }
   
   public void setScorenumber(Double scorenumber) {
       this.scorenumber = scorenumber;
   }

   public Integer getSportid() {
       return this.sportid;
   }
   
   public void setSportid(Integer sportid) {
       this.sportid = sportid;
   }
}