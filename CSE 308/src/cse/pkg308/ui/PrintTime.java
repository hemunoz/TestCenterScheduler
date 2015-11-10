/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import static cse.pkg308.ui.UserUI.sessionframe;
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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Schedule a task that executes once every second.
 */

public class PrintTime extends TimerTask{
  Toolkit toolkit;

  Timer timer;
  //static JLabel time;
  public static Calendar cal2;

  
    public void run() {
      
       
       Calendar cal = Calendar.getInstance();
       cal2 = cal;
       
       
       String minutes;
       String seconds;

       String hours = cal.getTime().getHours() + "";
       
       if(cal.getTime().getMinutes() < 10)
           minutes = "0" + cal.getTime().getMinutes() + "";
       else
            minutes = cal.getTime().getMinutes() + "";
       
       if(cal.getTime().getSeconds() < 10)
           seconds = "0" + cal.getTime().getSeconds() + "";
       else
            seconds = cal.getTime().getSeconds() + "";
       
       UserUI.time.setText(hours + ":" + minutes + ":" + seconds);
        
       int searchhours = cal.getTime().getHours() + TestingCenter.getReminderForTime().getHours();
       if(searchhours > 24)
           searchhours = searchhours - 24;
       
       int searchminutes = cal.getTime().getMinutes();
       //if(searchminutes >= 60)
       //    searchminutes = searchminutes - 60;
       
       int searchseconds = cal.getTime().getSeconds();
      // if(searchseconds >= 60)
      //     searchseconds = searchseconds - 60;
            
           String query = "Select examID from exam where startTime = '" + searchhours+ ":" 
                   + searchminutes + ":" + searchseconds + "'";

            java.sql.ResultSet rs = DBConnection.ExecQuery(query);
            //System.out.println(DBConnection.getconnection());
        try {
            //if(rs.next())
            while (rs.next()) {
                String query2 = "Select a.date, u.email from appointment a, forexam f, has h,"
                        + " student s, user u where h.appointmentID = a.appointmentID AND "
                        + "f.examID = '" + rs.getString(1) + "' AND f.appointmentID = a.appointmentID"
                        + " AND h.studentID = s.studentID AND s.studentID = u.userID";
                
                java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);
                
                try{
                    while(rs2.next())
                    {
                        Date date = rs2.getDate(1);
                        String email = rs2.getString(2);

                        
                        if(cal.getTime().getYear() == date.getYear()
                                && cal.getTime().getMonth() == date.getMonth()
                                && cal.getTime().getDay() == date.getDay())
                        {
                            System.out.println(email);
                        }
                        
                    }
                }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }
  

  public static void displaytime() {
    //test = Calendar.getInstance();
    Timer timer = new Timer();
 timer.schedule(new PrintTime(), 0, 1000);
 
    //System.out.println("Task scheduled.");
 //return test.getTime();
 
  }

  public static boolean morethanaday(String exam, String term){
      String query = "Select a.date, e.startTime from exam e, appointment a, forexam f where "
              + "e.examname = '" + exam + "' AND e.examID = f.examID AND f.appointmentID = a.appointmentID"
              + " AND e.term = '" + term + "'";
      java.sql.ResultSet rs = DBConnection.ExecQuery(query);
      
      Date date = cal2.getTime();
      Date time = cal2.getTime();
      
      try {
          while(rs.next())
          {
              date = rs.getDate(1);
              time = rs.getTime(2);
          }
      } catch (SQLException ex) {
          Logger.getLogger(PrintTime.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Date testdate = cal2.getTime();
      testdate.setDate(testdate.getDay() + 1);
      
      if(testdate.getYear() != date.getYear() && cal2.getTime().getYear() != date.getYear())
          return true;
      else if(testdate.getMonth() != date.getMonth() && cal2.getTime().getMonth() != date.getMonth())
          return true;
      else if(testdate.getDay() != date.getDay() && cal2.getTime().getDay() != date.getDay())
          return true;
      else if(testdate.getDay() == date.getDay() && cal2.getTime().getHours() < time.getHours())
          return true;
      else if(cal2.getTime().getDay() == date.getDay())
          return false;
      
      return false;

  }
}
