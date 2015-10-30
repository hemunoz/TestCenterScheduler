/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import java.awt.EventQueue;
import cse.pkg308.ui.StudentUI;
import cse.pkg308.ui.User;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import properties_manager.PropertiesManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cse.pkg308.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Appointment {
    
    private String appointmentid;
    private String checkedin;
    private int examid;
    private String studentid;
    
    public Appointment(){
        
    }
    
    public void addappointment(int examID, String studentID, Date date){
        String query = "Select (Max(appointmentID)+1) from appointment";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        String id = "";

        try {
            while (rs.next()) {
                
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(id);
        query = "INSERT INTO appointment VALUES ("
                + "'" + id + "', 'pending', '" + date + "')";
        DBConnection.ExecUpdateQuery(query);
        setCheckedin("pending");
        setStudentid(studentID);
        setExamid(examID);
        setAppointmentid(id);

        query = "INSERT INTO has VALUES ('" + studentID + "', '" + id + "')";
        DBConnection.ExecUpdateQuery(query);

        query = "INSERT INTO forexam VALUES ('" + id + "', '" + examID + "')";
        DBConnection.ExecUpdateQuery(query);
    }

    /**
     * @return the appointmentid
     */
    public String getAppointmentid() {
        return appointmentid;
    }

    /**
     * @param appointmentid the appointmentid to set
     */
    public void setAppointmentid(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    /**
     * @return the checkedin
     */
    public String getCheckedin() {
        return checkedin;
    }

    /**
     * @param checkedin the checkedin to set
     */
    public void setCheckedin(String checkedin) {
        this.checkedin = checkedin;
    }

    /**
     * @return the examid
     */
    public int getExamid() {
        return examid;
    }

    /**
     * @param examid the examid to set
     */
    public void setExamid(int examid) {
        this.examid = examid;
    }

    /**
     * @return the studentid
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * @param studentid the studentid to set
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }
    
}
