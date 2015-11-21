/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

//import static cse.pkg308.ui.UserUI.sessionframe;
//import static cse.pkg308.CSE308.sendEmail;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import cse.pkg308.ui.TestingCenter;

import cse.pkg308.DBConnection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Schedule a task that executes once every second.
 */
public class PrintTime extends TimerTask {

    Toolkit toolkit;

    Timer timer;
    
    public static Calendar cal2;

    public void run() {

        Calendar cal = Calendar.getInstance();
        cal2 = cal;

        String minutes;
        String seconds;
        String hours;
        
        /*
        Hours to be displayed. The hours displayed will always be 1 to 12. 
        If the hours are greater than 12, decrement by 12
        */
        if (cal.getTime().getHours() > 12)
            hours = (cal.getTime().getHours() - 12) + "";
        else if(cal.getTime().getHours() == 0)
            hours = "12";
        else
            hours = cal.getTime().getHours() + "";
        /*
        Minutes to be displayed. A zero is always included if there 
        are less than 10 minutes
        */
        if (cal.getTime().getMinutes() < 10)
            minutes = "0" + cal.getTime().getMinutes() + "";
        else
            minutes = cal.getTime().getMinutes() + "";
        
        /*
        Seconds to be displayed. A zero is always included if there are
        less than 10 seconds
        */
        if (cal.getTime().getSeconds() < 10) {
            seconds = "0" + cal.getTime().getSeconds() + "";
        } else {
            seconds = cal.getTime().getSeconds() + "";
        }

        /*
        Print the time to the screen
        */
        UserUI.time.setText(hours + ":" + minutes + ":" + seconds);

        /*
        For every minute, check if there is a student needs to be emailed a reminder
        */
        if (cal.getTime().getSeconds() == 0) 
        {
            TestingCenter t = new TestingCenter();
            
            /*
            The future time to check for appointments will be the current time plus the reminder
            interval. Add the reminder hours to the current hours and the reminder minutes to
            the current minutes
            */
            int searchhours = cal.getTime().getHours() + t.getReminderForTime().getHours();      
            int searchminutes = cal.getTime().getMinutes() + t.getReminderForTime().getMinutes();
            
            /*
            If the calculated future minutes is greater than 60 minutes, decrement the
            minutes by 60 and increment the hours by 1
            */
            if(searchminutes >= 60)
            {
                searchminutes = searchminutes - 60;
                searchhours++;
            }

            int searchseconds = cal.getTime().getSeconds();


            /*
            This query returns the the exam that starts on the current time
            */
            String query = "Select appointmentID from appointment where startTime = '" + searchhours + ":"
                    + searchminutes + ":" + searchseconds + "'";

            java.sql.ResultSet rs = DBConnection.ExecQuery(query);
            
            try {
                
                while (rs.next()) {
                    /*
                    This query gets the exam time, the appointment date for the exam, the name of the
                    student with the appointment, and the student's email
                    */
                    String query2 = "Select a.date, u.email, a.starttime, u.name from appointment a, has h,"
                            + " student s, user u where h.appointmentID = a.appointmentID AND "
                            + "a.appointmentID = '" + rs.getString(1) + "'"
                            + " AND h.studentID = s.studentID AND s.studentID = u.userID";

                    java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                    try {
                        while (rs2.next()) {
                            
                            Date date = rs2.getDate(1);
                            String email = rs2.getString(2);
                            System.out.println(email);
                            
                            /*
                            If the appointment date equals the current date, send an email,
                            passing the date, exam time, email, and student name
                            */
                            if ((cal.getTime().getYear()) == (date.getYear())
                                    && (cal.getTime().getMonth()) == (date.getMonth())
                                    && cal.getTime().getDate() == date.getDate()) 
                                    {
                                
                                newemail(email, rs2.getString(3), rs2.getString(4), rs2.getString(1));
                            }

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static void displaytime() {
        /*
        The Timer will update itself every second
        */
        Timer timer = new Timer();
        timer.schedule(new PrintTime(), 0, 1000);

    }

    public static boolean morethanaday(String exam, String term) {
        /*
        This query returns the time and date the student's appointment begins
        */
        String query = "Select a.date, e.startTime from exam e, appointment a, forexam f where "
                + "e.examname = '" + exam + "' AND e.examID = f.examID AND f.appointmentID = a.appointmentID"
                + " AND e.term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        Date date = cal2.getTime();
        Date time = cal2.getTime();

        try {
            while (rs.next()) {
                date = rs.getDate(1);
                time = rs.getTime(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrintTime.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
        Set the testdate to the current date plus 1 day.
        */
        Date testdate = cal2.getTime();
        testdate.setDate(testdate.getDay() + 1);

        /*
        Compare the current and future dates and times to the appointment date and times.
        An appointment can always be cancelled if the years are different, if the current and future
        months are not the same as the appointment month, if the current and future dates are not
        the same as the appointment date, and if the future date equals the appointment date while
        the current hours are less than the appointment hours. All other cases will return false,
        not allowing the appointment to be cancelled
        */
        if (testdate.getYear() != date.getYear() && cal2.getTime().getYear() != date.getYear()) {
            return true;
        } else if (testdate.getMonth() != date.getMonth() && cal2.getTime().getMonth() != date.getMonth()) {
            return true;
        } else if (testdate.getDay() != date.getDay() && cal2.getTime().getDay() != date.getDay()) {
            return true;
        } else if (testdate.getDay() == date.getDay() && cal2.getTime().getHours() < time.getHours()) {
            return true;
        } else if (cal2.getTime().getDay() == date.getDay()) {
            return false;
        }

        return false;

    }

    public void newemail(String dest, String time, String name, String date) {

        String source = "carblover327@gmail.com"; //The Source email address
        String password = "pussycat"; //The source email password

        /*
        Set up the email server and authenticate the email with the address and password
        */
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator a = new Authenticator() {
            
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(source, password);
            }
        };
        /*
        Begin a new email session
        */
        Session session = Session.getInstance(props, a);

        /*
        Send the email with to the dest email address with the subject and body
        */
        sendEmail(session, dest, "Exam Reminder", "Hello, " + name + 
                ". This is a reminder that you have an exam at " + time + " on " + date);
    }

    public void sendEmail(Session session, String toEmail, String subject, String body) {
        try {
            MimeMessage m = new MimeMessage(session);
            
            m.addHeader("Content-type", "text/HTML; charset=UTF-8");
            m.addHeader("format", "flowed");
            m.addHeader("Content-Transfer-Encoding", "8bit");

            m.setFrom(new InternetAddress("reminder@journaldev.com", "Exam Reminder"));

            m.setReplyTo(InternetAddress.parse("reminder@journaldev.com", false));

            m.setSubject(subject, "UTF-8");

            m.setText(body, "UTF-8");

            m.setSentDate(new Date());

            m.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));

            Transport.send(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
