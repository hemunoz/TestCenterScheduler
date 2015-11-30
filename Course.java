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
    private int students;
    
    public Course(){
        
    }

    public boolean lookupstudent(String studentID)
    {
        /*
        This query returns the students enrolled in the course
        */
        String query = "Select studentID from takes where courseID = '" + getCourseID() + "'";

        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        
        try {
            while (rs.next()) {
                /*
                If one of the student IDs equals that of the student trying to make an appointment,
                the student is enrolled in the course. Return true
                */
                if (studentID.equals(rs.getString(1)))
                    return true;

            }
            /*
            If the student's ID is not one of the IDs returned, the student is not enrolled in the
            course. Return false
            */
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
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

    /**
     * @return the students
     */
    public int getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(int students) {
        this.students = students;
    }
}
