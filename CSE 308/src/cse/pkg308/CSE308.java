/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308;

import cse.pkg308.DBConnection;
import cse.pkg308.ui.Login;
import cse.pkg308.ui.Student;
import cse.pkg308.ui.StudentTakeAnExam;
import cse.pkg308.ui.User;
import cse.pkg308.ui.TestingCenter;
import cse.pkg308.ui.schedulesession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Owner
 */
public class CSE308 {

    static Login login = new Login();
    static User user = new User();
    static TestingCenter testing = new TestingCenter();
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        user.startlogin();
       /* 
        int searchhours = 10 + TestingCenter.getReminder().getHours();
       if(searchhours > 12)
           searchhours = searchhours - 12;
       
       int searchminutes = 56;
       //if(searchminutes >= 60)
       //    searchminutes = searchminutes - 60;
       
       int searchseconds = 0;
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
                        //date.setHours(date.getHours() + TestingCenter.getReminder().getHours());
                        //date.setMinutes(date.getMinutes() + TestingCenter.getReminder().getMinutes());
                        //date.setSeconds(date.getSeconds() + TestingCenter.getReminder().getSeconds());

                        //date.setDate(date.getDate() + 1);
                        
                        
                        System.out.println(date);
                    }
                }catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
}
}
