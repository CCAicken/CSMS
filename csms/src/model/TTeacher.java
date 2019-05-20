package model;



/**
 * TTeacher entity. @author MyEclipse Persistence Tools
 */

public class TTeacher  implements java.io.Serializable {


    // Fields    

     private TTeacherId id;


    // Constructors

    /** default constructor */
    public TTeacher() {
    }

    
    /** full constructor */
    public TTeacher(TTeacherId id) {
        this.id = id;
    }

   
    // Property accessors

    public TTeacherId getId() {
        return this.id;
    }
    
    public void setId(TTeacherId id) {
        this.id = id;
    }
   








}