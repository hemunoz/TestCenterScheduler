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
import cse.pkg308.ui.TestingCenter;
import cse.pkg308.ui.User;
import cse.pkg308.ui.schedulesession;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

 
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Owner
 */
public class CSE308 {

    static User user = new User();
    static TestingCenter testing = new TestingCenter();
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        user.startlogin();
        /*final String fromEmail = "carblover327@gmail.com"; //requires valid gmail id
        final String password = "pussycat"; // correct password for gmail id
        final String toEmail = "carblover327@gmail.com"; // can be any email id 

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
         
                //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);
         
        sendEmail(session, toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
         
*/


    }
    
    public static void sendEmail(Session session, String toEmail, String subject, String body){
        try
        {
          MimeMessage msg = new MimeMessage(session);
          //set message headers
          msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
          msg.addHeader("format", "flowed");
          msg.addHeader("Content-Transfer-Encoding", "8bit");
 
          msg.setFrom(new InternetAddress("no_reply@journaldev.com", "NoReply-JD"));
 
          msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
 
          msg.setSubject(subject, "UTF-8");
 
          msg.setText(body, "UTF-8");
 
          msg.setSentDate(new Date());
 
          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
          
          System.out.println("Message is ready");
          Transport.send(msg);
 
          System.out.println("EMail Sent Successfully!!");
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }

}
