/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.StudentUI.coursecomboBox;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Exam {
    
    private int examID;
    private String startDate;
    private String endDate;
    private String StartTime;
    private String endTime;
    private int seatsAvailable;
    private String term;
    private String examtype;
    private String examname;
   
    
    public Exam(){
        
    }
    
    public boolean lookupstudent(Student s)
    {
        String query = "Select s.studentID from student s, has h, appointment a, exam e, forexam f where "
                + "e.examID = '" + getExamID() + "' AND e.examID = f.examID AND f.appointmentID = a.appointmentID"
                + " AND h.appointmentID = a.appointmentID AND h.studentID = s.studentID";
        //String query = "Select * from course where courseID = '" + getCourseID() + "'";
        
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        String id = s.getID() + "";
        try {
            while (rs.next()) {

                if (id.equals(rs.getString(1)))
                    return true;
                else 
                    return false;
                //System.out.println(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public boolean checkTime(String time)
    {
        if(!(getStartTime().equals(time)))
            return false;
        else
            return true;
    }
    
    public boolean checkDate(String date)
    {
        
        return true;
    }
    
    /**
     * @return the examID
     */
    public int getExamID() {
        return examID;
    }

    /**
     * @param examID the examID to set
     */
    public void setExamID(int examID) {
        this.examID = examID;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the StartTime
     */
    public String getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the seatsAvailable
     */
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    /**
     * @param seatsAvailable the seatsAvailable to set
     */
    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    /**
     * @return the term
     */
    public String getTerm() {
        return term;
    }

    /**
     * @param term the term to set
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * @return the examtype
     */
    public String getExamtype() {
        return examtype;
    }

    /**
     * @param examtype the examtype to set
     */
    public void setExamtype(String examtype) {
        this.examtype = examtype;
    }

    /**
     * @return the examname
     */
    public String getExamname() {
        return examname;
    }

    /**
     * @param examname the examname to set
     */
    public void setExamname(String examname) {
        this.examname = examname;
    }
}
