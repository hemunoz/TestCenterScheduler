/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import cse.pkg308.ui.UserUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Course {
    
    private String courseID;
    private String department;
    private String coursename;
    private String coursedescription;
    private int section;
    private String term;
    
    public Course(){
        
    }

    public boolean lookupstudent(Student s)
    {
        String query = "Select s.studentID from student s, takes t, course c where "
                + "c.courseID = t.courseID AND t.StudentID = s.studentID AND c.courseID = '"
                + getCourseID() + "'";
        //String query = "Select * from course where courseID = '" + getCourseID() + "'";
        System.out.println(getCourseID());
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        String id = s.getID() + "";
        try {
            while (rs.next()) {

                if (id.equals(rs.getString(1)))
                    return true;
                
                //System.out.println(rs.getString(1));

            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    /**
     * @return the courseID
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * @param courseID the courseID to set
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the coursename
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * @param coursename the coursename to set
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    /**
     * @return the coursedescription
     */
    public String getCoursedescription() {
        return coursedescription;
    }

    /**
     * @param coursedescription the coursedescription to set
     */
    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
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
}
