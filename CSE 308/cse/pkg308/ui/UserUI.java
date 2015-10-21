/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cse.pkg308.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

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
    
    public void initializeLogin(JFrame sessionFrame)
    {
        sessionframe = sessionFrame;
        continueLogin();
    }
    
    public JTextField getID(){
        return textFieldUserID;
    }
    
    public JFrame getSession(){
        return sessionframe;
    }
    
    public void continueLogin(){
        //System.out.println(5);
        sessionframe.setTitle("Testing Center Login");
		sessionframe.setBounds(100, 100, 264, 207);
		sessionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sessionframe.getContentPane().setLayout(null);
		
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
                    + "userid = '" + getID().getText() + "'";
            
            //query = "Select * from user";
            
            rs = DBConnection.ExecQuery(query);
            System.out.println(4);
            try {
            while (rs.next()) {
                password = rs.getString(2);
                name = rs.getString(3);
                email = rs.getString(4);
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(5);
        }          
            
            String id = getID().getText();
            Student s = new Student();
            int intid = Integer.parseInt(id);
            
            s.setID(intid);
            s.setPassword(password);
            s.setName(name);
            s.setEmail(email);
            User.student.initializestudent(s);
            //StudentUI su = new StudentUI();
            //su.initializestudent(s);
        }
        
        
            
        }
    
    
}
