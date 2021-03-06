/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import cse.pkg308.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PendingRequest {
    
    private String requestid;
    private Date StartDate;
    private Date EndDate;
    private Time startTime;
    private Time endTime;
    private String Term;
    private int section;
    private String course;
    private String requestname;
    private String status;
    
    
    public PendingRequest(){
        
    }

    public void addrequest(int inid, Date startdate, Date enddate, Time starttime, Time endtime, String term, int section, String courseid, String requestname, int students)
    {
        String query = "Select (Max(requestID) + 1) from pendingrequest";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        String id = "";
        
        try {
            while(rs.next())
            {
                id = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        query = "Insert into pendingrequest values ('" + id + "', '" + startdate + "', '"
                            + enddate + "', '" + starttime + "', '" + endtime + "', '" + term
                            + "', '" + section + "', '" + courseid + "', '" + requestname 
                + "', 'pending', '" + students + "')";
        DBConnection.ExecUpdateQuery(query);
        
        query = "Insert into requests values ('" + id + "', '" + inid + "')";
        DBConnection.ExecUpdateQuery(query);
        
        setRequestid(id);
    }
    
    public void deleterequest(String id)
    {
        String query = "Delete from requests where requestid = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);
        
        query = "Delete from pendingrequest where requestid = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);
    }
    
    public void addadhocrequest(int inid, Date startdate, Date enddate, Time starttime, Time endtime, String term, String requestname, int students, String [] studentarray)
    {
        String query = "Select (Max(requestID) + 1) from pendingrequest";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        String id = "";
        
        try {
            while(rs.next())
            {
                id = rs.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendingRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        query = "Insert into pendingrequest values ('" + id + "', '" + startdate + "', '"
                            + enddate + "', '" + starttime + "', '" + endtime + "', '" + term
                            + "', '0', 'ad hoc', '" + requestname 
                + "', 'pending', '" + students + "')";
        DBConnection.ExecUpdateQuery(query);
        
        query = "Insert into requests values ('" + id + "', '" + inid + "')";
        DBConnection.ExecUpdateQuery(query);
        
        for(int i = 0; i < studentarray.length; i++)
        {
            query = "Insert into studentrequest values ('" + id + "', '" + studentarray[i] + "')";
            DBConnection.ExecUpdateQuery(query);
        }
        
        setRequestid(id);
    }
    
    public void deleteadhocrequest(String id)
    {
        String query = "Delete from requests where requestid = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);
        
        query = "Delete from pendingrequest where requestid = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);
        
        query = "Delete from studentrequest where requestid = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);
    }
    
    /**
     * @return the requestid
     */
    public String getRequestid() {
        return requestid;
    }

    /**
     * @param requestid the requestid to set
     */
    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    /**
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the EndDate
     */
    public Date getEndDate() {
        return EndDate;
    }

    /**
     * @param EndDate the EndDate to set
     */
    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    /**
     * @return the startTime
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
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
     * @return the Term
     */
    public String getTerm() {
        return Term;
    }

    /**
     * @param Term the Term to set
     */
    public void setTerm(String Term) {
        this.Term = Term;
    }

    /**
     * @return the section
     */
    public int getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(int section) {
        this.section = section;
    }

    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     * @return the coursename
     */
    public String getRequestname() {
        return requestname;
    }

    /**
     * @param coursename the coursename to set
     */
    public void setRequestname(String requestname) {
        this.requestname = requestname;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
