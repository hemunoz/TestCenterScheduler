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
    private Date date;

    public Appointment() {

    }

    public void addappointment(int examID, String studentID, Date date) {
        /*
        This query returns the maximum appointment ID value and increments it
        */
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
        
        /*
        This query will insert the incremented max id value into the appointment table
        This is the id of the new appointment. The appointment information will also be entered
        into the appointment object
        */
        query = "INSERT INTO appointment VALUES ("
                + "'" + id + "', 'pending', '" + date + "')";
        DBConnection.ExecUpdateQuery(query);
        setCheckedin("pending");
        setStudentid(studentID);
        setExamid(examID);
        setAppointmentid(id);

        /*
        This query updates the relation table "has" between Student and Appointment with the
        student and appointment IDs where the student now has a new appointment.
        */
        query = "INSERT INTO has VALUES ('" + studentID + "', '" + id + "')";
        DBConnection.ExecUpdateQuery(query);

        /*
        This query updates the relation table "forexam between appointment and exam with the
        exam and appointment IDs where there is a new appointment for the exam
        */
        query = "INSERT INTO forexam VALUES ('" + id + "', '" + examID + "')";
        DBConnection.ExecUpdateQuery(query);

    }

    public void deleteappointment(String id) {
        /*
        This query returns the exam ID, date, and available seats of the exam the selected
        appointment i for
        */
        String query = "Select i.examid, i.date, i.seatsavailable from individualexam i, forexam f, appointment a where"
                + " i.examid = f.examid AND f.appointmentid = a.appointmentID AND a.appointmentID"
                + " = '" + id + "' AND a.date = i.date";

        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        String date = "";
        String examid = "";
        int seats = 0;
        try {
            while (rs.next()) {
                examid = rs.getString(1);
                date = rs.getString(2);
                seats = rs.getInt(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
        Increment the number of seats and set this value in the individualexam table
        for the where the examid and date equal the selected values
        */
        seats++;
        query = "UPDATE individualexam SET seatsavailable ='" + seats + "' WHERE"
                + " examid = '" + examid + "' AND date = '" + date + "'";
        DBConnection.ExecUpdateQuery(query);

        /*
        Delete the appointment from appointment, forexam, and has tables where the appointment
        is no longer for the exam and the student no longer has the appointment
        */
        query = "Delete from has where appointmentID = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);

        query = "Delete from forexam where appointmentID = '" + id + "'";
        DBConnection.ExecUpdateQuery(query);

        query = "Delete from appointment where appointmentID = '" + id + "'";
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
