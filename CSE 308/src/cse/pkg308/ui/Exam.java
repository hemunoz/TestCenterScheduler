/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.StudentUI.coursecomboBox;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Owner
 */
public class Exam {
    
    private int examID;
    private Date startDate;
    private Date endDate;
    private Time StartTime;
    private Time endTime;
    private int seatsAvailable;
    private String term;
    private String examtype;
    private String examname;
   
    
    public Exam(){
        
    }
    
    public boolean lookupstudent(String studentID)
    {
        //System.out.println(getExamID());
        String query = "Select h.studentID from has h, appointment a, exam e, forexam f where "
                + "e.examID = '" + getExamID() + "' AND e.examID = f.examID AND f.appointmentID = a.appointmentID"
                + " AND h.appointmentID = a.appointmentID";
        //String query = "Select * from course where courseID = '" + getCourseID() + "'";
        //System.out.println(getExamID());
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        //String id = s.getID() + "";
        int takingexam = 0;
        try {
            while (rs.next()) {
                //System.out.println(id);
                //System.out.println(rs.getString(1));
                if (studentID.equals(rs.getString(1)))
                    takingexam = 1;
                
                //System.out.println(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(takingexam);
        if(takingexam == 0)
            return false;
        else
            return true;
    }
    
    public boolean availableseats(String examID, Date date)
    {
        String query = "Select seatsavailable from individualexam where examid = '" + examID + "'"
                + " AND date = '" + date + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        
        int seats = 0;
        
        try {
            while(rs.next())
            {
                seats = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(seats == 0)
        {
            return false;
        }
        else
        {
            seats--;
            query = "UPDATE `scheduler`.`individualexam` SET `seatsavailable`='" + seats + "' WHERE"
                    + " examID = '" + examID + "' AND date = '" + date + "'";
            DBConnection.ExecUpdateQuery(query);
            
            return true;
        }
        
        
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
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the StartTime
     */
    public Time getStartTime() {
        return StartTime;
    }

    /**
     * @param StartTime the StartTime to set
     */
    public void setStartTime(Time StartTime) {
        this.StartTime = StartTime;
    }

    /**
     * @return the endTime
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Time endTime) {
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
