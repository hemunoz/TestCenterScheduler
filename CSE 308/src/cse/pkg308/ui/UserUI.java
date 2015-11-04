/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserUI {
    
    public static JFrame sessionframe;
    public static JFrame frmStudentInterface;
    
    /*public static JTextField textFieldUserID = new JTextField();
    public static JPasswordField passwordFieldPassword = new JPasswordField();
    public static JLabel lblPassword = new JLabel("Password:");
    public static JLabel lblUserID = new JLabel("UserID:");
    public static JLabel lblTestingCenter = new JLabel("Testing Center");
    public static JLabel lblPleaseLogIn = new JLabel("Please log in");
    public static JButton btnLogin = new JButton("Login");
    public static JButton btnExit = new JButton("Exit");*/
    public static JTextField textFieldUserID;
    public static JPasswordField passwordFieldPassword;
    public static JLabel lblPassword;
    public static JLabel lblUserID;
    public static JLabel lblTestingCenter;
    public static JLabel lblPleaseLogIn;
    public static JButton btnLogin;
    public static JButton btnExit;
    public static JButton btnBacktoHome;
    public static JLabel invalid;
    public static JLabel time;
    
    
    public void initializeLogin(JFrame sessionFrame)
    {
        sessionframe = sessionFrame;
        continueLogin();
    }
    
    public JTextField getID(){
        return textFieldUserID;
    }
    
    public JPasswordField getPassword(){
        return passwordFieldPassword;
    }
    
    public JFrame getSession(){
        return sessionframe;
    }
    
    public void continueLogin(){
        
        sessionframe.setTitle("Testing Center Login");
		sessionframe.setBounds(100, 100, 264, 207);
		sessionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sessionframe.getContentPane().setLayout(null);
                
                PrintTime.displaytime();
                //PrintTime.displaytime();
                
                time = new JLabel();
                time.setFont(new Font("Tahoma", Font.PLAIN, 10));
		time.setBounds(200, 11, 140, 25);
		sessionframe.getContentPane().add(time);
		
		lblTestingCenter = new JLabel("Testing Center");
		lblTestingCenter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTestingCenter.setBounds(56, 11, 146, 25);
		sessionframe.getContentPane().add(lblTestingCenter);
		
		lblPleaseLogIn = new JLabel("Please log in.");
		lblPleaseLogIn.setBounds(92, 47, 63, 14);
		sessionframe.getContentPane().add(lblPleaseLogIn);
		
		lblUserID = new JLabel("UserID:");
		lblUserID.setBounds(40, 82, 63, 14);
		sessionframe.getContentPane().add(lblUserID);
		
		textFieldUserID = new JTextField();
		textFieldUserID.setBounds(113, 79, 104, 20);
		sessionframe.getContentPane().add(textFieldUserID);
		textFieldUserID.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(40, 107, 63, 14);
		sessionframe.getContentPane().add(lblPassword);
                
                
                
                passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(113, 104, 104, 20);
		sessionframe.getContentPane().add(passwordFieldPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(128, 135, 89, 23);
		sessionframe.getContentPane().add(btnLogin);
                
                btnBacktoHome = new JButton("Back to Login");
		btnBacktoHome.setBounds(128, 135, 89, 23);
		sessionframe.getContentPane().add(btnBacktoHome);
                
                invalid = new JLabel("Incorrect Username or Password");
		invalid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		invalid.setBounds(56, 11, 146, 25);
		sessionframe.getContentPane().add(invalid);
                
                btnBacktoHome.setVisible(false);
                invalid.setVisible(false);
                
                btnExit = new JButton("Exit");
		btnExit.setBounds(29, 135, 89, 23);
		sessionframe.getContentPane().add(btnExit);
                
                
                
                btnLogin.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        //System.out.println(6);
                        
                        
                        switchtouserscreen();
                        
                        //Student.openstudent();
                    }
                });
                
                
                btnExit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
    }
    
    public void switchToLogin()
    {
        
        textFieldUserID.setVisible(true);
                        passwordFieldPassword.setVisible(true);
                        lblUserID.setVisible(true);
                        lblPassword.setVisible(true);
                        lblTestingCenter.setVisible(true);
                        lblPleaseLogIn.setVisible(true);
                        btnLogin.setVisible(true);
                        btnExit.setVisible(true);
                        
                        btnLogin.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        
                        switchtouserscreen();
                        
                        //Student.openstudent();
                    }
                });
                
                
                btnExit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                });
                    
                       
    }
    
    public void switchtouserscreen(){
        //System.out.println(getID().getText());
            String usertype = "";
            
            String query = "SELECT usertype from isa where "
                    + "userid = '" + getID().getText() + "'";
        
        //Connection connection = DBConnection.getconnection();
        //System.out.println(connection);
            
            java.sql.ResultSet rs = DBConnection.ExecQuery(query);
            //System.out.println(DBConnection.getconnection());
        try {
            while (rs.next()) {
                
                usertype = rs.getString(1);
                
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(usertype.equals("student"))
        {
            
            //Student.openstudent();
            
            String password = "";
            String name = "";
            String email = "";
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";
            
            //query = "Select * from user";
            
            rs = DBConnection.ExecQuery(query);
            
            try {
            while (rs.next()) {
                password = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            
        }          
            
            String id = getID().getText();
            Student s = new Student();
            int intid = Integer.parseInt(id);
            
            s.setID(intid);
            s.setPassword(password);
            s.setName(name);
            s.setEmail(email);
            if(!(s.getName().equals("")))
                User.student.initializestudent(s);
            else
                switchToTryAgainPage();
            {
                
                /*textFieldUserID.setVisible(false);
                passwordFieldPassword.setVisible(false);

                lblPassword.setVisible(false);
                lblUserID.setVisible(false);
                lblTestingCenter.setVisible(false);
                lblPleaseLogIn.setVisible(false);

                btnLogin.setVisible(false);
                btnExit.setVisible(false);
                
                continueLogin();*/
            }
            //StudentUI su = new StudentUI();
            //su.initializestudent(s);
        }
        else if(usertype.equals("instr"))
        {
            String password = "";
            String name = "";
            String email = "";
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";
            
            //query = "Select * from user";
            
            rs = DBConnection.ExecQuery(query);
            
            try {
            while (rs.next()) {
                password = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            
        }          
            
            String id = getID().getText();
            Instructor i = new Instructor();
            int intid = Integer.parseInt(id);
            
            i.setID(intid);
            i.setPassword(password);
            i.setName(name);
            i.setEmail(email);
            
            if(!(i.getName().equals("")))
                User.instructor.initializeinstructor(i);
            else
                switchToTryAgainPage();
            /*if(!(i.getName().equals("")))
                User.instructor.initializeinstructor(i);
            else
            {
                
                textFieldUserID.setVisible(false);
                passwordFieldPassword.setVisible(false);

                lblPassword.setVisible(false);
                lblUserID.setVisible(false);
                lblTestingCenter.setVisible(false);
                lblPleaseLogIn.setVisible(false);

                btnLogin.setVisible(false);
                btnExit.setVisible(false);
                
                continueLogin();
            }*/
        }
        else if(usertype.equals("admin"))
        {
            String password = "";
            String name = "";
            String email = "";
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";
            
            //query = "Select * from user";
            
            rs = DBConnection.ExecQuery(query);
            
            try {
            while (rs.next()) {
                password = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            
        }          
            
            String id = getID().getText();
            Administrator a = new Administrator();
            int intid = Integer.parseInt(id);
            
            a.setID(intid);
            a.setPassword(password);
            a.setName(name);
            a.setEmail(email);
            
            
            
            if(!(a.getName().equals("")))
                User.admin.initializeadmin(a);
            
        }
        else
            switchToTryAgainPage();
        
        
        
            
        }
    
    public void switchToTryAgainPage(){
       
		textFieldUserID.setVisible(false);
                passwordFieldPassword.setVisible(false);

                lblPassword.setVisible(false);
                lblUserID.setVisible(false);
                lblTestingCenter.setVisible(false);
                lblPleaseLogIn.setVisible(false);
                time.setVisible(false);

                btnLogin.setVisible(false);
                btnExit.setVisible(false);
		
                btnBacktoHome.setVisible(true);
                invalid.setVisible(true);
                
                
                btnBacktoHome.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        invalid.setVisible(false);
                        btnBacktoHome.setVisible(false);
                        
                        continueLogin();
                        
                        //Student.openstudent();
                    }
                });
    }
    
    
}
