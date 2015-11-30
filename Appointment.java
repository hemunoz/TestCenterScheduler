/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

import com.toedter.calendar.JCalendar;
import cse.pkg308.DBConnection;
import cse.pkg308.ui.StudentUI;
import cse.pkg308.ui.User;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Appointment {

    private String appointmentid;
    private String checkedin;
    private int examid;
    private String studentid;
    private Date date;
    private Time starttime;
    private Time endtime;

    public Appointment() {

    }

    public void addappointment(int examID, String studentID, Date date, Time time, String term) {
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

        int num = getnewseat(term, time, date, id);

        Time endtime = new Time(time.getHours() + 2, time.getMinutes(), 0);
        /*
         This query will insert the incremented max id value into the appointment table
         This is the id of the new appointment. The appointment information will also be entered
         into the appointment object
         */
        //Time endtime = new Time(time.getHours() + 2, time.getMinutes(), 0);
        //System.out.println(id + " " + date + " " + time + " " + endtime);
        query = "INSERT INTO appointment VALUES ("
                + "'" + id + "', 'pending', '" + date + "', '" + time + "', '" + endtime + "', '" + num + "')";
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
        /* seats++;
         query = "UPDATE individualexam SET seatsavailable ='" + seats + "' WHERE"
         + " examid = '" + examid + "' AND date = '" + date + "'";
         DBConnection.ExecUpdateQuery(query);*/

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

    /**
     * @return the starttime
     */
    public Time getStarttime() {
        return starttime;
    }

    /**
     * @param starttime the starttime to set
     */
    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    /**
     * @return the endtime
     */
    public Time getEndtime() {
        return endtime;
    }

    /**
     * @param endtime the endtime to set
     */
    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }
        
    public int getnewseat(String term, Time time, Date date, String appointmentID)
    {
        String query = "Select seats from testingcenter where term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        int seatnum = 0;

        try {
            while (rs.next()) {

                seatnum = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Time endtime = new Time(time.getHours() + 2, time.getMinutes(), 0);
        
        System.out.println(date + " " + time + " " + endtime);

        query = "Select appointmentID, seat from appointment where checkedin != 'superfluous' AND date = '" + date
                + "' AND ((starttime <= '" + endtime + "' AND endtime >= '" + endtime + "') OR "
                + "(starttime <= '" + time + "' AND endtime >= '" + endtime + "') OR (starttime >= '" + time + "' AND "
                + "endtime <= '" + endtime + "') OR (starttime <= '" + time + "' AND endtime >= '" + time + "'))"
                + " ORDER BY seat";

        rs = DBConnection.ExecQuery(query);
        //int num = 0;
        ArrayList<Integer> seats = new ArrayList();

        try {
            while (rs.next()) {
                //num = rs.getInt(1);
                //System.out.println(rs.getString(1) + " " + appointmentID);
                if(!(rs.getString(1).equals(appointmentID)))
                {
                    seats.add(rs.getInt(2));
                    //System.out.println("seat: " + rs.getInt(2));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }

        int num = 0;
        int diff = 0;
        int consec = 0;
        //System.out.println(seats.size());

        if (seats.size() == 1) {
                if (seats.get(0) >= 3) {
                    num = 1;
                    //System.out.println(num);
                } else if (seats.get(0) == 2) {
                    consec = 1;
                }
            }
        else
        {
        for (int i = 0; i < seats.size() - 1; i++) {
            
            if (i == 0) {
                if (seats.get(i) >= 3) {
                    num = 1;
                    //System.out.println(num);
                } else if (seats.get(i) == 2) {
                    consec = 1;
                }
            }
            
            diff = seats.get(i + 1) - seats.get(i);
            if (diff == 2) {
                consec = seats.get(i) + 1;
            } else if (diff >= 3 && (seats.get(i + 1) - (seats.get(i) + 2)) >= 2) {
                num = seats.get(i) + 2;
                break;
            }
            
        }
        }
        if (num == 0) {
            if (seats.isEmpty()) {
                num = 1;
            } else if (seats.get(seats.size() - 1) + 2 <= seatnum) {
                num = seats.get(seats.size() - 1) + 2;
            } else if (num == 0 && consec != 0) {
                num = consec;
            } else {
                num = seats.get(seats.size() - 1) + 1;
            }
        }
        
        return num;
    }

}
